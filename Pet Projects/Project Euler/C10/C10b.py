# 2016-02-20
# Summation of Primes ID 10
# Eratosthenes' set lookup sieve


def a(n):
    multiples = set()
    for i in range (2, n+1):
        if i not in multiples:
            yield i
            multiples.update(i*i, n+1, i)
    
    #for i in multiples:
    #    total = total + multiples.pop()
    
    #print(total)     
            
           
for i in a(20):
    print(i)
            