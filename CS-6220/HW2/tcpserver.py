"""

tcpserver.py

A tcp server made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

import socket
import sys
import time


class TCPServer:

    """TCPServer class for the TCP socket server to listen
    to the client.

    """

    address_family = socket.AF_INET  # only IPv4 connections
    socket_type = socket.SOCK_STREAM  # constant to use TCP socket type
    # request_queue_size = 1  # we only take one connection
    num_strings = 0  # number of strings received

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

    def capitalize_string(self, client_string):
        """Capitalizes string that is received from the client."""
        self.received_string()
        return client_string.upper()

    def close(self):
        """Closes the socket."""
        self.socket.close()

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

    def received_string(self):
        self.num_strings += 1

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
        sock = TCPServer(host, port)
        conn, addr = sock.accept()
        with conn:
            print(addr)
            while True:
                sentence = conn.recv(1024).decode()
                print("Sentence", sentence)
                processed_sentence = sock.capitalize_string(sentence)
                conn.send(processed_sentence.encode())
                conn.send("Awaiting next sentence...".encode())
    except KeyboardInterrupt:
        print("\nExited by Ctrl+C.")
        sock.close()
        sys.exit()


main()
