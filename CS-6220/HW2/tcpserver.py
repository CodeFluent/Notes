"""

tcpserver.py

A tcp server made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

"""
TEMP
    - Multithreading*
    - Don't bind port to specific number
    - KeyboardInterrupt won't work for some reason until after client connects and server receives and processes input.
"""

import socket
import sys


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
            self.bind()
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

    def listen(self):
        """Start listening for any clients"""
        self.socket.listen(1)
        self.print_details()  # print the details of the connection

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


def main():
    try:
        server_sock = TCPServer(host, port)
        server_sock.listen()
        while True:
            conn, addr = server_sock.accept()
            with conn:  # from python 3.7 docs examples
                print("Connected by: ", addr)
                while (server_sock.get_num_of_strings() < 10):
                    sentence = conn.recv(1024).decode()
                    if not sentence:
                        break
                    print("\nSentence is: ", sentence)
                    conn.sendall(
                        server_sock.capitalize_string(sentence).encode())
                    print("Number of strings ",
                          server_sock.get_num_of_strings())
                    conn.sendall("Awaiting next sentence...".encode())
    except KeyboardInterrupt:
        print("\nExited by Ctrl+C.")
        server_sock.close()
        sys.exit(1)


main()
