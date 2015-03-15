import math

while True:
    n = int(input("What number would you like Goldilocks to look at? "))

    binaryN = str(bin(n))[2:]
    print(binaryN)

    zeroes = 0
    ones = 0

    for char in binaryN:
        if int(char) == 0:
            zeroes += 1
        else:
            ones += 1

    if zeroes > ones:
        print("Too Light")
    elif ones > zeroes:
        print("Too Heavy")
    else:
        print("Just right")

