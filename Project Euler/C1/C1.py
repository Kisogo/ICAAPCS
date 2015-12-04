# 2015-11-03 ID 1
# Multiples of 3 and 5
K, V, I = 3, 5, 1
Kt, Vt = 0, 0

while Kt < 1000:
	Kt = Kt + (K * I)
	print("K: I = " + str(I) + " Kt = " + str(Kt))
	I = I + 1
	
	if (Kt + 3) > 1000:
		break

I = 1


while Vt < 1000:
	Vt = Vt + (V * I)
	print("V: I = " + str(I) + " Vt = " + str(Vt))
	I = I + 1
	
	if (Vt + 5) > 1000:
		break

print("sum: " + str(Kt + Vt))