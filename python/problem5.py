c = int(input("Enter the number of customers your fine establishment: "))
p = int(input("Enter the number of delicious pies you have made: "))
print(c, p)
totalSlices = c



while totalSlices%p != 0 and not (totalSlices%3 == 0 or totalSlices%4 == 0 or totalSlices%5 == 0):
    print(1)
    

print(totalSlices)

##d = 0
##if i%5 == 0:
##    d = 5
##if i%4 == 0:
##    d = 4
##if i%3 == 0:
##    d = 3
##
##if d == 0 or i%p != 0:
##    print("YA DONE MESSED UP")
##
##slicePerPie = i/p
##
##print("Cut ", p, " pies with the ", d, "-way cutter, into ", slicePerPie, " slices each")
##
