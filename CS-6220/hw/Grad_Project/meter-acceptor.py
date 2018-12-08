"""
An example of a Paxos SmartMeter acceptor using TCP sockets.
"""

import socket
import sys

from random import randint


class SmartMeter:

    """SmartMeter class that acts as the
    Acceptor to reject or accept proposals by
    the Proposer.

    """

    address_family = socket.AF_INET  # only IPv4 connections
    socket_type = socket.SOCK_STREAM  # constant to use TCP socket type

    # constructor from the socket.py module

    def __init__(self, server_address, server_port):
        self.server_address = server_address
        self.server_port = server_port
        self.socket = socket.socket(self.address_family, self.socket_type)

        # PAXOS VARIABLES
        METER_ID = randint(1, 100)  # id of the Acceptor
        self.LAST_HIGHEST_ID = -1  # last id that was taken max, -1 since first proposal is 0
        # in this case, we will set privacy of all clients to .3 so consensus happens in two rounds,
        # however, could do a bounded [0,1] random variable on both Proposer and Acceptor.
        self.PRIVACY = 0.3

    def connect(self):
        """Attempts to connect to the server socket, throws exception and closes socket if fails."""
        try:
            self.socket.connect((self.server_address, self.server_port))
        except:
            self.socket.close()
            raise Exception('Failed to connect to server socket.')


host = '127.0.0.1'
# port = 0  # the OS should choose an open port for us
port = 65434


def main():
    try:
        client_sock = SmartMeter(host, port)
        client_sock.connect()
        while True:  # from python 3.7 docs examples

            data = client_sock.socket.recv(1024)
            print("\nFrom Server: ", data.decode())

            if (data == "CONSENSUS".encode()):
                print("\n Reached Consensus with privacy value:",
                      client_sock.PRIVACY)
                break
            else:
                # 0 is uid, 1 is value, 2 is substation id
                if(data.decode()[0] <= SmartMeter.LAST_HIGHEST_ID):
                    # reject

                if(data.decode[1] < SmartMeter.PRIVACY):
                    # reject
                elif(data.decode[1] == SmartMeter.PRIVACY):
                    # accept

        client_sock.socket.close()
    except KeyboardInterrupt:
        print("Interrupted")
        client_sock.socket.sendall("CLIENT REQUESTS SHUTDOWN".encode())
        client_sock.socket.shutdown(2)
        client_sock.socket.close()
        sys.exit(1)


main()
