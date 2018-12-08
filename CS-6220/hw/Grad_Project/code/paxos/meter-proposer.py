"""
An example of a Paxos SubStation proposer using TCP sockets.
"""


import socket
import sys
import collections
import threading


class Ballot:
    def __init__(self):
        self.uid = 0  # default beginning proposal id
        self.value = 0  # default value to propose to SmartMeter
        self.id = 0  # to be replaced by Substation Id


class SubStation:

    """
    TCPServer class contains the necessary functions
    for the application by keeping track of the strings
    and only binding the socket to the specified ports in
    the constructor.

    All other socket operations should
    be used by the .socket member access.
    """

    address_family = socket.AF_INET  # only IPv4 connections
    socket_type = socket.SOCK_STREAM  # constant to use TCP socket type

    client_details = []  # list of clients connected

    # constructor from the socket.py module
    def __init__(self, server_address, server_port):
        self.server_address = server_address
        self.server_port = server_port
        self.socket = socket.socket(self.address_family, self.socket_type)

        # PAXOS VARIABLES
        self.CONSENSUS_REACHED = 2  # Consensus reached when 2 SmarteMeters accept
        self.QUORUM_SIZE = 3  # Known in advance; includes the proposer
        self.ACKS_RECEIVED = 0  # tracks the amount of acks by acceptors
        self.NAKS_RECEIVED = 0  # tracks the amount of naks by acceptors
        self.SUBSTATION_ID = 1223  # id of the Proposer, sent out with each ballot
        self.LAST_HIGHEST_ID = 0  # last id that was taken max
        self.PRIVACY = 0.2  # the privacy value we wish for SmartMeter to accept

        self.ballot = Ballot()
        self.ballot.id = self.SUBSTATION_ID
        self.ballot.uid = 0
        self.ballot.value = self.PRIVACY

        try:
            self.bind()
        except:
            self.socket.close()
            raise Exception('Error in setting up connection to host port.')

    def add_client_details(self, addr):
        """
        Add the tuples of our connected clients to a list.
        This is not currently used, but would be great to 
        gracefully except during shutdowns of client sockets.
        """
        if addr in self.client_details:
            return
        self.client_details.append(addr)
        print("Connected by: ", addr)

    def bind(self):
        """Binds the socket to a port"""
        try:
            # option to reuse addresses for sockets
            self.socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
            # a tuple of the address and port is used for the bind function
            self.socket.bind((self.server_address, self.server_port))
        except:
            self.socket.close()
            raise Exception(
                'Error in binding socket to address and port specified.')

    def increment_acks(self):
        self.ACKS_RECEIVED += 1  # message succeed, increase acks

        # ballot succeed if all nodes accepted or just the ones required for majority, exit.
        if (self.ACKS_RECEIVED >= self.QUORUM_SIZE or self.ACKS_RECEIVED >= self.CONSENSUS_REACHED):
            self.socket.sendall("CONSENSUS".encode())
            self.socket.close()

    def increment_naks(self):
        self.NAKS_RECEIVED += 1  # message failed, increase naks

        # ballot failed if all nodes reject, do a new query.
        if (self.NAKS_RECEIVED >= self.QUORUM_SIZE):
            self.new_ballot_propose()

    def new_ballot_propose(self):
        """
        Note that this would go to infinity and no consensus reached
        if SmartMeter didn't have a limit.
        """
        # keep adding to privacy so SmartMeter might accept higher values.
        self.PRIVACY += 0.1
        self.ballot.uid += 1  # just increase for sequential id
        self.ballot.value = self.PRIVACY

    def process_clients(self, connection, address):
        """
        Main logic of the program. Takes care of the shutdown of
        client Acceptors.
        """
        while True:

            # quick string encode
            a = str(self.ballot.uid)
            b = "," + str(self.ballot.value)
            c = "," + str(self.ballot.id)
            d = a + b + c

            connection.sendall(d.encode())  # send the ballot

            response = connection.recv(1024).decode()

          # Acceptor rejects proposal.
            if (response == "REJECT"):
                print("\n ACCEPTOR REJECTS VALUE")
                self.increment_naks()
                break

          # Acceptor accepts proposal.
            if (response == "ACCEPT"):
                print("\n ACCEPTOR ACCEPTS VALUE")
                self.increment_acks()
                print("\n PEERS REQUIRED FOR CONSENSUS: ",
                      (self.CONSENSUS_REACHED - self.ACKS_RECEIVED))

        self.socket.close()

    def start_client_listen(self):
        """
        Starts the mulithreaded listen for the 
        clients. Also adds clients to a list of 
        connected clients.

        Every client added will go through 
        here to be processed by process_clients()
        """
        try:
            self.socket.listen(4)  # listen to 4 clients max
            self.print_details()
            while True:
                conn, addr = self.socket.accept()
                self.add_client_details(addr)
                threading.Thread(target=self.process_clients,
                                 args=(conn, addr)).start()

            self.socket.close()
        except KeyboardInterrupt:
            print("\nExited by Ctrl+C.")
            self.socket.close()
            sys.exit(1)

    def print_details(self):
        """Print out the server details"""
        print('SERVER READY @ ', self.socket.getsockname())


host = "127.0.0.1"
# port = 0  # the OS should choose an open port for us
port = 65434

SubStation(host, port).start_client_listen()
