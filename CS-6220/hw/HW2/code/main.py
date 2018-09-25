from classes.tcpserver import TCPServer

host = "127.0.0.1"
# port = 0  # the OS should choose an open port for us
port = 65434


def main():
    try:
        sock = TCPServer(host, port)
        while True:
            conn, addr = sock.accept()
            sentence = conn.recv(1024).decode()
            print("Sentence is: ", sentence)
            processed_sentence = sock.capitalize_string(sentence)
            conn.send(processed_sentence.encode())
            print("Number of strings ", sock.get_num_of_strings())
            conn.send("Awaiting next sentence...".encode())
    except KeyboardInterrupt:
        print("\nExited by Ctrl+C.")
        sock.close()


if __name__ == '__main__':
    main()
