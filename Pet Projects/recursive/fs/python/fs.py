# 2016-02-12
# Recursively walks the filesystem to a specified depth from the specified root directory.

import os

def walk(path):
    if(os.path.isdir(path) == True):
        os.chdir(path)
        for subdir in os.listdir(path):
            try:
                print(os.path.realpath(subdir))
                #walk(os.path.realpath(subdir))
            finally:
                break

            
    
walk("/home/ryan/ICAAPCS")
