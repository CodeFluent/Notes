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
    file = open("user.txt", "w")

    # to be put into a file
    balance = 0
    username = "charles"
    pin = "02323"

    client_details = []  # list to hold client tuples
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
        This is used namely to connect back to clients for an auth check.
        See auth_challenge() for more info.
        """
        if addr in self.client_details:
            pass
        self.client_details.append(addr)
        print("Connected by: ", addr)

    def bind(self):
        """Binds the socket to any available port"""
        try:
            # a tuple of the address and port is used for the bind function
            self.socket.bind((self.server_address, self.server_port))
        except:
            self.socket.close()
            raise Exception(
                'Error in binding socket to address and port specified.')

    def check_auth(self, username, pin):
        # forgot list comprehension, so we separate the first chars here
        username = username[1:]
        pin = pin[1:]

        if (username == self.username and pin == self.pin):
            return True
        else:
            return False

    def auth_challege(self):
        message = "\n\tPlease give the username and pin number.\n"

        # send a message back to the client asking for auth info
        self.socket.sendto(message.encode(), (self.client_details[0]))

        conn, addr = self.socket.recvfrom(2048)
        credentials = conn.decode()
        credentials = credentials.split()
        credentials = [
            word for line in credentials for word in line.split()]  # separate the username and password strings

        if (self.check_auth(credentials[0], credentials[1]) == True):
            return True
        else:
            return False

    def check_balance(self):
        return str(self.balance) + " dollar(s) are in your balance."

    def deposit(self, amount):
        amount = amount[0:]
        self.balance = self.balance + int(amount)

    def withdraw(self, amount):
        amount = amount[0:]
        self.balance = self.balance - int(amount)

    def process_command(self, message):
        if (len(message) >= 1):
            if (message[0] == "b"):
                return self.check_balance()
            elif (message[0] == "w"):
                if (self.auth_challege() != False):
                    self.withdraw(message[1:])
                    return "Withdrew " + message[1:] + " dollar(s). Balance is now " + str(self.balance) + " dollar(s)."
                else:
                    return "Invalid credentials. Please try the withdraw command again."
            elif (message[0] == "d"):
                if (self.auth_challege() != False):
                    self.deposit(message[1:])
                    return "Deposited " + message[1:] + " dollar(s). Balance is now " + str(self.balance) + " dollar(s)."
                else:
                    return "Invalid credentails. Please try the deposit command again."
        else:
            return "Improper format, please send command again."

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
            server_sock.add_client_details(addr)
            message = conn.decode()
            message = server_sock.process_command(message)
            server_sock.socket.sendto(message.encode(), addr)

        server_sock.socket.close()
    except KeyboardInterrupt:
        print("\nExited by Ctrl+C.")
        server_sock.socket.close()
        sys.exit(1)


main()
