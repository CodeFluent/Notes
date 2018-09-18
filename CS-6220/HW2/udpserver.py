"""

udpserver.py

A udp server made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

"""
REQUIRMENTS
    - Maintains file with: name, pin, and balance
    - Prompts client for auth using name and pin
    - Allows client to deposit and withdraw AFTER auth
    - Messages client confirmation of record update
    - Allows client to ask for and receive current balance

"""

import socket
import sys


class UDPServer:

    address_family = socket.AF_INET  # only IPv4 connections
    socket_type = socket.SOCK_DGRAM  # constant to use UDP socket type
    # request_queue_size = 1  # we only take one connection

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

    def bind(self):
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

    def print_details(self):
        """Print out the server details"""
        print('SERVER READY @ ', self.socket.getsockname())


host = "127.0.0.1"
# port = 0  # the OS should choose an open port for us
port = 65434


def main():
    try:
        server_sock = UDPServer(host, port)
        server_sock.socket.setblocking(1)
        server_sock.print_details()
        while True:
            conn, addr = server_sock.socket.recvfrom(2048)
            print("Connected by: ", addr)
            while True:
                message = conn.decode()
                server_sock.socket.sendto(message.encode(), addr)
        server_sock.socket.close()
    except KeyboardInterrupt:
        print("\nExited by Ctrl+C.")
        server_sock.socket.close()
        sys.exit(1)


main()
