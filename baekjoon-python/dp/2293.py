'''
예시
3 10
0 1 2 3 4 5 6 7 8 9 10
1 1 1 1 1 1 1 1 1 1 1
2 1 2 
5

'''

n, k = [int(x) for x in input().split()]
ls = [0]
for i in range(n):
    ls.append(int(input()))

dt= [[0]*(k+1) for _ in range(2)]
dt[1][0] = 1
for i in range(1,n+1):
    for j in range(1,k+1):
        if j >= ls[i]:
            dt[1][j] = dt[1][j-ls[i]]+dt[0][j]
        else:
            dt[1][j] = dt[0][j]
    dt[0] = dt[1]

print(dt[1][k])