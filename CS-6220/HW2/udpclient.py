"""

udpclient.py

A udp client made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

import socket
import sys


class UDPClient:

    address_family = socket.AF_INET  # only IPv4 connections
    socket_type = socket.SOCK_DGRAM  # constant to use TCP socket type

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


def process_command(number):
    amount = 0

    if (number == "1"):
        return "b"
    elif (number == "2"):
        amount = input("\n\tHow much do you want to withdraw?\n")
        return ("w" + amount)
    elif (number == "3"):
        amount = input("\n\tHow much do you want to deposit?\n")
        return ("d" + amount)
    else:
        return "\nIllegal Command."


def main():
    try:
        client_sock = UDPClient(host, port)
        client_sock.connect()
        while True:  # from python 3.7 docs examples
            print("\n")
            print("\t(1) Check Balance\n")
            print("\t(2) Withdraw\n")
            print("\t(3) Deposit\n")
            command = input("\n\tInput command by sending a number...\n")
            message = process_command(command)
            if (message != "\nIllegal Command."):
                client_sock.socket.sendto(
                    message.encode(), (host, port))
                conn, addr = client_sock.socket.recvfrom(2048)
                print("\nFrom Server: ", conn.decode())
            else:
                print(message)

        client_sock.socket.close()
    except KeyboardInterrupt:
        print("Interrupted")
        client_sock.socket.close()
        sys.exit(1)


main()
