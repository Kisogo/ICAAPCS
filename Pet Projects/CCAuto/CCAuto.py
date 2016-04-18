#!/usr/bin/python3
import os
import requests
from time import localtime, strftime, sleep


class connwatcher:
    hostname = "8.8.8.8"
    
    def watch(self):
        response = 0
        
        # Connection is still active.
        while response == 0:
        
            print(strftime("%H:%M:%S", localtime()) + " [info] up")
            response = os.system("ping -c 1 -W 3 8.8.8.8 > /dev/null 2>&1")
            
            # Only test connection every few seconds.
            sleep(1)
            
        # Connection dropped, login.    
        if response != 0:
            print(strftime("%H:%M:%S", localtime()) + " [info] Connection dropped, login!")
            al.login(self)
        
            
class al:
    
    # Login automatically.
    def login(self):
        # Form data
        url = 'http://52.5.122.40:80'
        name_first = "anon"
        name_last = "anon"
        email = "anon@gmail.com"
    
        payload = {
                "first_name" : name_first,
                "last_name" : name_last,
                "email" : email
        }
        
        try:
            r = requests.post(url, data=payload)
            
            
            # Print status code
            print(strftime("%H:%M:%S", localtime()) + " [info] Got " + str(r.status_code) + ".")
        except ConnectionError:
            print(strftime("%H:%M:%S", localtime()) + " [err] Connection Failed/Refused: ConnectionError raised.")
        #except HTTPError:
        #    print(strftime("%H:%M:%S", localtime()) + " [err] Malformed/invalid HTTP response recieved: HTTPError raised.")
            
        # Start watching the connection again
        connwatcher.watch(self)
        
    
class main:
    cw = connwatcher()
    cw.watch()

m = main()