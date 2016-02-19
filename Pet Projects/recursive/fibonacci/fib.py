def fib(n):
    if n <= 2:
        return 1
    else:
        #print(n)
        return fib(n - 1) + fib(n - 2)
        

print(fib(8))