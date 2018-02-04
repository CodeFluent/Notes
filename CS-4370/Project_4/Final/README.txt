SPECIAL INSTRUCTIONS
=========================================================

You will need to have this done.html page running on some sort of webserver or other ftp/http complaint service that provides XMLHTTPRequests. The javascript runs with local file origin enabled since lesmis.json is hardcoded.

An example webserver in python is

> python -m SimpleHTTPServer 8000

and browse to localhost:8000.

Or you can view it here: http://codefluent.github.io/Notes

Note that the file upload doesn't work properly. Clicking on the file and selecting the exact "lesmis.json" from the project samples changes the data, but it doesn't actually upload anything, it just selects the data that is 
stored locally on the server aka localhost/lesmis.json.