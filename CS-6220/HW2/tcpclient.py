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

    def connect(self):
        """Attempts to connect to the server socket, throws exception and closes socket if fails."""
        try:
            self.socket.connect((self.server_address, self.server_port))
        except:
            self.socket.close()
            raise Exception('Failed to connect to server socket.')

    def shutdown(self):
        """Schedules resources for GC."""
        self.socket.shutdown(2)

    def close(self):
        """Closes socket."""
        self.socket.close()


host = '127.0.0.1'
# port = 0  # the OS should choose an open port for us
port = 65434


def main():
    try:
        client_sock = TCPClient(host, port)
        client_sock.connect()
        while True:  # from python 3.7 docs examples
            sentence = input("\n\tInput a lowercase sentence...\n")
            client_sock.socket.sendall(sentence.encode())
            data = client_sock.socket.recv(1024)
            print("\nFrom Server: ", data.decode())
            # server has terminated connection, clean up and close socket
            if (data == "STRINGS LIMIT REACHED, CLOSING CONNECTION".encode()):
                print("\n\tCLIENT CONNECTION CLOSED.")
                client_sock.shutdown()
                break
        client_sock.close()
    except KeyboardInterrupt:
        print("Interrupted")
        client_sock.close()
        sys.exit(1)


main()
