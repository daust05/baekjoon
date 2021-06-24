'''

'''
import sys
sys.setrecursionlimit(100000)

n = int(input())
wine = [-1]
for ls in range(n):
    wine.append(int(input()))

dt = [-1]*(n+1)
def dp(n):
    if dt[n] != -1:
        return dt[n]
    if n <= 2:
        dt[n] = sum(wine[1:(n+1)])
        return dt[n]

    cand = []
    cand.append(dp(n-1))
    cand.append(wine[n] + dp(n-2))
    if n == 3:
        cand.append(wine[n]+wine[n-1])
    else:
        cand.append(wine[n] + wine[n-1] + dp(n-3))
    dt[n] = max(cand)
    return dt[n]
dp(n)
print(dt[n])