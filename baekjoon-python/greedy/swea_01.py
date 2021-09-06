T = int(input())

for _ in range(T):
    N = int(input())
    si = []
    fi = []
    for i in range(N):
        s, f = [int(x) for x in input().split(" ")]
        si.append(s)
        fi.append(f)

    total = 0
    count = 0

    while len(fi) != 0:
        minNum = min(fi)
        minIdx = fi.index(minNum)

        if total + si[minIdx] <= minNum:
            total += si[minIdx]
            count += 1

        del si[minIdx]
        del fi[minIdx]

    print(count)