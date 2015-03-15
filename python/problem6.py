# MVHS problem 6

import math

totalWeight = 0
ppr = int(input("Pies per rack: "))
rpf = int(input("Number of racks: "))
for i in range(rpf):
	density = eval(input("Density of pies on rack " + str(i+1) + ": "))
	height = eval(input("Height of pies on rack " + str(i+1) + ": "))
	weight = ppr * density * (height * 25 * math.pi)
	totalWeight += weight
	
print("Total weight is ", totalWeight, " pounds")
