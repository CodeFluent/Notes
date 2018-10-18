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
import socketserver
import sys

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
        <p>Or try to intiate a timeout here.</p>
    </body>
</html>
"""



class Page_Handler(BaseHTTPRequestHandler):

    def do_HEAD(self):
        self.send_response(200)
        self.send_header("Content-Type", "text/html")
        self.end_headers()

    def do_GET(self):
        if (self.path == "/"):
            self.send_response(200)
            self.send_header("Content-Type", "text/html")
            self.end_headers()         
            self.wfile.write(DEFAULT_PAGE.encode("utf-8"))

 

def main():
    host = "127.0.0.1"
    port = 8343
    
    
    server = socketserver.TCPServer((host, port), Page_Handler)

    try:
        server.serve_forever()
    except KeyboardInterrupt:
        pass

    server.shutdown()

if __name__ == '__main__':
    main()