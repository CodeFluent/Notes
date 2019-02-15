"""

tcpclient.py

A tcp client made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

import socket
import sys


class TCPClient:

    """TCPClient class that only binds the 
    socket using the specified ports in the
    constructor.

    All other socket operations should 
    be used by the .socket member access.

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
                client_sock.socket.shutdown(2)
                break
        client_sock.socket.close()
    except KeyboardInterrupt:
        print("Interrupted")
        client_sock.socket.sendall("CLIENT REQUESTS SHUTDOWN".encode())
        client_sock.socket.shutdown(2)
        client_sock.socket.close()
        sys.exit(1)


main()