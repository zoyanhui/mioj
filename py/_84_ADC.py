import sys

for line in sys.stdin:
    line = line.strip()
    a, b = tuple([int(x) for x in line.split(" ")])
    axeArmo = b - (100 + a * 10)
    axe = (100 + 85) * (1.0 - axeArmo / (602 + axeArmo))
    bowArmo = b * (1.0 - 0.45)
    bow = (100 + 80) * (1 - bowArmo / (602 + bowArmo))
    if axe > bow:
        print("axe")
    elif axe < bow:
        print("bow")
    else:
        print("same")