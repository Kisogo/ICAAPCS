# 2016-03-22 ID 6
# Sum square difference

import math

sum_of_squares = 0
sum_of_i = 0

for i in range(1, 100):
    sum_of_squares = sum_of_squares + math.pow(i, 2)
    sum_of_i = sum_of_i + i
    
print(math.pow(sum_of_i, 2) - sum_of_squares)