import sys

for line in sys.stdin:
    line = line.strip()
    ints = [int(x) for x in line.split()]
    if not ints:
        print(0)
        continue
    ints.sort()
    silver=0
    damage=0
    kill = False
    for i in range(len(ints)):
        if ints[i] <= damage:
            continue
        if kill:
            damage += 2
            kill = False
        if ints[i] <= damage:
            kill = True
            continue
        need = ints[i] - damage
        inc = int(need/2)+(need&1)
        silver+=inc
        damage+=inc*2
        kill = True
    print(silver)

