"""

tcpclient.py

A tcp client made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

import socket
import sys


class TCPClient:

    """TCPClient class for the TCP socket client to send messages
    to the server.

    """

    address_family = socket.AF_INET  # only IPv4 connections
    socket_type = socket.SOCK_STREAM  # constant to use TCP socket type

    # constructor from the socket.py module
    def __init__(self, server_address, server_port):
        self.server_address = server_address
        self.server_port = server_port
        self.socket = socket.socket(self.address_family, self.socket_type)

        try:
            self.connect()
        except:
            raise Exception('Error in setting up connection to host port.')
        finally:
            self.socket.close()

    def connect(self):
        self.socket.connect((self.server_address, self.server_port))

    def __enter__(self):
        return self

    def __exit__(self, *args):
        try:
            self.socket.close()
        except:
            raise Exception('Socket was already closed.')


host = '127.0.0.1'
# port = 0  # the OS should choose an open port for us
port = 65434


def main():
    try:
        with TCPClient(host, port) as sock:
            sock.socket.sendall(b'Hello World')
            data = sock.socket.recv(1024)
            print(repr(data))
    except KeyboardInterrupt:
        print("Interrupted")
        sys.exit()


main()
