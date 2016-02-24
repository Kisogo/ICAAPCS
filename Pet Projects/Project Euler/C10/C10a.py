# 2016-01-16 ID10
# Summation of Primes

from math import sqrt

primality = []
target, z, x, i = 30, 0, 2, 1

for i in range(target):
    primality.append(True)

while x < sqrt(target): # x = number to factorize by
    while z < target: # z = factor * i ([2,3,4,5 ...] * i)
        z = x * i
        print(x, z)
        del primality[z-1]
        primality.insert(z-1, False)
        i += 1
        
    x += 1
        
print(primality)
    
        

