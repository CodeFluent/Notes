"""

httpserver.py

A TCP-based HTTP server made in python.
Some code from Python's http.server module.
Made by Wasfi Momen.

"""

"""
REQUIREMENTS
    - Starts a HTTP server on any port other than port 80
    - Shows 404 if a page is not found
    - Shows 504 if server is down

"""

import socket
import threading
import socketserver # TCPServer will be used as our server.
import sys
import time

# for proper processing of HTTP verbs
from http.server import HTTPServer, BaseHTTPRequestHandler


DEFAULT_PAGE = """\
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
        "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>Hello</title>
    </head>
    <body>
        <h1>Welcome to the HTTP Server!</h1>
        <p>Try to go to an unknown page like <a href="wtf.html">here.</a></p>
        <p>Or try to intiate a timeout <a href="/long_page">here.</a></p>
    </body>
</html>
"""

ERROR_404_PAGE = """\
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
        "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>404</title>
    </head>
    <body>
        <h1>Woops, something went wrong.</h1>
        <p>This is the 404 page.</p>
    </body>
</html>
"""

ERROR_504_PAGE = """\
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
        "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>504</title>
    </head>
    <body>
        <h1>Server is stopped.</h1>
        <p>This is the 504 page.</p>
    </body>
</html>
"""



class Page_Handler(BaseHTTPRequestHandler):

    def do_HEAD(self, status):
        self.send_response(status)
        self.send_header("Content-Type", "text/html")
        self.end_headers()

    def do_GET(self):
        if (self.path == "/"):
            self.do_HEAD(200)
            self.wfile.write(DEFAULT_PAGE.encode("utf-8"))
        elif (self.path == "/long_page"):
            self.do_TIMEOUT()
        else:
            self.do_HEAD(404)
            self.wfile.write(ERROR_404_PAGE.encode("utf-8"))
    
    def do_TIMEOUT(self):
        """Sleep for 10 seconds. Then do a 504 error."""
        i = 10 
        while (i != 0):
            i -= 1
            time.sleep(1)
        self.do_HEAD(504)
        self.wfile.write(ERROR_504_PAGE.encode("utf-8")) 


def main():
    host = "127.0.0.1"
    port = 8343
    
    # initialize the server with our custom handler
    server = socketserver.TCPServer((host, port), Page_Handler)

    try:
        server.serve_forever()
    except KeyboardInterrupt:
        print("\nShutting down server...")
        server.shutdown()
    

if __name__ == '__main__':
    main()