"""

tcpserver.py

A tcp server made in python.
Some variable and function names from socketserver.py in python 3.7 release.
Made by Wasfi Momen.

"""

"""
REQUIRMENTS
    - ~~Capitalizes strings~~
    - ~~Max 10 strings~~
    - ~~Client ask for termination~~ **"Appropiate message" to terminate is Ctrl+C**
    - ~~Limit reached, send message to client~~
    - Multithreaded

"""

"""
ISSUES
    - Multithreading*
    - Sending out of order*
    - Prompt for next string AFTER capitalized string is sent*
    - Don't bind port to specific number
    - KeyboardInterrupt won't work until enter is pressed.
    - ~~Figure out what the classes actually do instead of just implementing socket functions.~~
"""

import socket
import sys


class TCPServer:

    """TCPServer class contains the necessary functions
    for the application by keeping track of the strings
    and only binding the socket to the specified ports in 
    the constructor. 

    All other socket operations should
    be used by the .socket member access.

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

    def capitalize_string(self, client_string):
        """Capitalizes string that is received from the client."""
        self.received_string()
        return client_string.upper()

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
        server_sock.socket.setblocking(1)
        server_sock.socket.settimeout(10)
        server_sock.socket.listen()
        server_sock.print_details()
        while True:
            conn, addr = server_sock.socket.accept()
            print("Connected by: ", addr)
            while True:
                sentence = conn.recv(1024).decode()
                """Turn if loops into a function"""
                # break out of while loop if shutdown request is given
                if (sentence == "CLIENT REQUESTS SHUTDOWN"):
                    print("\nCLIENT HAS REQUESTED SHUTDOWN")
                    # 2 means SHUT_RDWR or disable read and write, Windows only takes numbers
                    conn.shutdown(2)
                    conn.close()
                    break
                # break out of while loop if number of strings exceeds 10
                if (server_sock.get_num_of_strings() >= 10):
                    print(
                        "STRINGS LIMIT REACHED, SHUTTING DOWN AND CLOSING SOCKET")
                    conn.sendall(
                        "STRINGS LIMIT REACHED, CLOSING CONNECTION".encode())
                    conn.shutdown(2)
                    conn.close()
                    break
                print("\nSentence is: ", sentence)
                conn.sendall(
                    server_sock.capitalize_string(sentence).encode() + "\nAwaiting next string...".encode())
                print("Number of strings ",
                      server_sock.get_num_of_strings())
            break
        server_sock.socket.close()
    except KeyboardInterrupt:
        print("\nExited by Ctrl+C.")
        server_sock.socket.close()
        sys.exit(1)


main()
