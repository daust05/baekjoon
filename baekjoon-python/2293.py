'''
예시
3 10
1
2
5

'''

n, k = [int(x) for x in input().split()]
ls = [0]
for i in range(n):
    ls.append(int(input()))

dt= [[0]*(k+1) for _ in range(n+1)]
for i in range(1,n+1):
    dt[i][0] = 1
    for j in range(1,k+1):
        if j >= ls[i]:
            dt[i][j] = dt[i][j-ls[i]]+dt[i-1][j]
        else:
            dt[i][j] = dt[i-1][j]

print(dt[n][k])
print(dt)