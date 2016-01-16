# 2016-01-11 ID 2
# Even Fibonacci Numbers


x, y, result = 0, 1, 0
z = x+y


while z < 4000000:
	if(z % 2 == 0):
		print("EVEN result: " + str(result) + " x: " + str(x) + " y: " + str(y) + " z: " + str(z))
		result += z
	else:
		print("ODD result: " + str(result) + " x: " + str(x) + " y: " + str(y) + " z: " + str(z))
	#print(x,y,z)
	x = y
	y = z
	z = x+y
		
print(result)