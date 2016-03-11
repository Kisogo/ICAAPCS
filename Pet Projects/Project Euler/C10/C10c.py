# 2016-02-20
# Summation of Primes ID 10


def sieve(n):
    multiples = []
    for i in range(2, n+1):
        if i not in multiples:
            multiples.append(i)
            for j in range(i+1, i*i, i):
                if j not in multiples:
                    multiples.append(j)
                    #print(str(j))
                    
    total = 0
    for i in multiples:
        total = total + i
        #print(str(i))
    
    print("\n" + str(total))
    
    
sieve(500)