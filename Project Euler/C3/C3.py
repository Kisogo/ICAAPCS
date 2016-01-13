# 2016-01-11 ID 3
# Largest prime factor


t = 600851475143

for n in range(int(t/3), 1, -1):
	if(n % 2 != 0 and n % 3 != 0):
		if(t % n == 0):
			result = n
			print(result)
	print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" + str(n))

			
print(result)