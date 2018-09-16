"""

tcpserver.py

A tcp server made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen. 
   
"""

import socket


class TCPServer:

    """TCPServer class for the TCP socket server to listen
    to the client.

    """

    address_family = socket.AF_INET  # only IPv4 connections
    socket_type = socket.SOCK_STREAM  # constant to use TCP socket type
    # request_queue_size = 1  # we only take one connection
    strings = []  # empty array to gather strings from client

    # constructor from the socket.py module
    def __init__(self, server_address, server_port):
        self.server_address = server_address
        self.server_port = server_port
        self.socket = socket.socket(self.address_family, self.socket_type)

        try:
            self.server_bind()
            self.server_start()
        except:
            self.socket.close()
            raise Exception('Error in setting up connection to host port.')

    def accept(self):
        """Start accepting incoming connections and data"""
        return self.socket.accept()

    def server_bind(self):
        """Binds the socket to any available port"""

        """See Unix man socket(7) SO_REUSEPORT"""
        # self.socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

        try:
            # a tuple of the address and port is used for the bind function
            self.socket.bind((self.server_address, self.server_port))
        except:
            self.socket.close()
            raise Exception(
                'Error in binding socket to address and port specified.')

    def server_start(self):
        """Start listening for any clients"""
        self.socket.listen(1)
        self.print_details()  # print the details of the connection

    def print_details(self):
        """Print out the server details"""
        print('SERVER READY @ ', self.socket.getsockname())

    def __enter__(self):
        return self

    def __exit__(self, *args):
        try:
            self.socket.close()
        except:
            raise Exception('Socket was already closed.')


host = '127.0.0.1'
port = 0  # the OS should choose an open port for us
with TCPServer(host, port) as sock:
    conn, addr = sock.accept()
