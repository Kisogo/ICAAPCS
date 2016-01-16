# 2016-01-11 ID 3
# Largest prime factor


#t = 600851475143
t = 13195

for n in range(1, t, 1):
	if(n % 2 != 0 and n % 3 != 0):
		if(t % n == 0):
			result = n
			#print(result)
	#print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" + str(n))

			
print(result)
