# 2016-01-11 ID 1
# Multiples of 3 and 5


result = 0
for i in range(0, 1000):
	if(i % 3 == 0 or i % 5 == 0):
		result += i

print(result)
