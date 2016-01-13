# 2015-11-03 ID 1
# Multiples of 3 and 5
K, V, I = 3, 5, 1
Kt, Vt = 0, 0

while K * I < 1000:
	Kt = Kt + (K * I)
	print("K: I = " + str(I) + " K = " + str(K * I) + " Kt = " + str(Kt))
	I = I + 1
	
	#if (K * I + 3) > 1000:
	#	break

I = 1


while V * I < 1000:
	Vt = Vt + (V * I)
	print("V: I = " + str(I) + " V = " + str(V * I) + " Vt = " + str(Vt))
	I = I + 1
	
	#if (V * I + 5) > 1000:
	#	break

print("sum: " + str(Kt + Vt))