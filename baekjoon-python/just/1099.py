import sys
from sys import stdin, stdout

rd = stdin.readline
wr = stdout.write

deStr = list(rd().rstrip())
N = int(rd())

start = 0
total = 0
for i in range(N):
    nextStr = list(rd().rstrip())
    min = len(nextStr)+1
    while start < len(deStr):
        cost = 0
        objStr = deStr[start:start+len(nextStr)]
        if sorted(nextStr) != sorted(objStr):
            break
        else:
            for i,s in enumerate(nextStr):
                if s != objStr[i]:
                    cost += 1
        if cost < min:
            min = cost
        start += len(nextStr)
        
    if min <= len(nextStr):
        total += min

if total == 0:
    print(-1)
else:
    print(total)
    
