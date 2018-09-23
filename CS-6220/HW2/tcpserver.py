"""

tcpserver.py

A tcp server made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

"""
REQUIRMENTS
    - ~~Capitalizes strings~~
    - ~~Max 10 strings~~
    - ~~Client ask for termination~~ **"Appropiate message" to terminate is Ctrl+C**
    - ~~Limit reached, send message to client~~
    - ~~Multithreaded~~

"""

"""
ISSUES
"""

import socket
import sys
import threading


class TCPServer:

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

    # request_queue_size = 1  # we only take one connection

    num_strings = 0  # number of strings received
    client_details = []  # list of clients connected

    # constructor from the socket.py module
    def __init__(self, server_address, server_port):
        self.server_address = server_address
        self.server_port = server_port
        self.socket = socket.socket(self.address_family, self.socket_type)

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

    def capitalize_string(self, client_string):
        """Capitalizes string that is received from the client."""
        self.received_string()
        return client_string.upper()

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

    def process_clients(self, connection, address):
        """
        Main logic of the program. Takes care of the shutdow of
        client sockets and termination of server when strings limit
        is reached.
        """
        while True:
            sentence = connection.recv(1024).decode()

            # break out of while loop if shutdown request is given
            if (sentence == "CLIENT REQUESTS SHUTDOWN"):
                print("\nCLIENT HAS REQUESTED SHUTDOWN")
                # 2 means SHUT_RDWR or disable read and write, Windows only takes numbers
                connection.shutdown(2)
                connection.close()
                break

            # break out of while loop if number of strings exceeds 10
            if (self.get_num_of_strings() >= 10):
                print(
                    "STRINGS LIMIT REACHED, SHUTTING DOWN AND CLOSING SOCKET")
                connection.sendall(
                    "STRINGS LIMIT REACHED, CLOSING CONNECTION".encode())
                connection.shutdown(2)
                connection.close()
                break

            print("\nSentence is: ", sentence)
            connection.sendall(
                self.capitalize_string(sentence).encode() + "\nAwaiting next string...".encode())
            print("Number of strings ",
                  self.get_num_of_strings())
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

    def received_string(self):
        """Increments the number of string received by the server."""
        self.num_strings += 1

    def get_num_of_strings(self):
        """Returns the number of strings the server has received."""
        return self.num_strings


host = "127.0.0.1"
# port = 0  # the OS should choose an open port for us
port = 65434

TCPServer(host, port).start_client_listen()
