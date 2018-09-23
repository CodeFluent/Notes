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

    def process_command(self, number):
        """Formats a message to be received and interpreted server-side."""
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


host = '127.0.0.1'
# port = 0  # the OS should choose an open port for us
port = 65434


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

            # get a message to send to the server
            message = client_sock.process_command(command)

            if (message != "\nIllegal Command."):
                # send message to server.
                client_sock.socket.sendto(
                    message.encode(), (host, port))

            conn, addr = client_sock.socket.recvfrom(2048)
            message_from_server = conn.decode()
            print("\nFrom Server: ", message_from_server)

            if (message_from_server == "\n\tPlease give the username and pin number.\n"):
                username = input("\n\tPlease give the username.\n")
                pin = input("\n\tPlease give the pin number.\n")
                formatted = "u" + username + " " + "p" + pin
                client_sock.socket.sendto(formatted.encode(), (host, port))
                # we make another conn, addr here to get another frame of the UDP packet.
                # dunno how to fix except keeping track of packet data sent and received.
                conn, addr = client_sock.socket.recvfrom(2048)
                message_from_server = conn.decode()
                print("\nFrom Server: ", message_from_server)

        client_sock.socket.close()
    except KeyboardInterrupt:
        print("Interrupted")
        client_sock.socket.close()
        sys.exit(1)


main()
