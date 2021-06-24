n = int(input())

ls = [[0]*10 for _ in range(0,n)]
ls[0] = [int(x) for x in range(1,11)]

for i in range(1, n):
    ls[i][0] = ls[i-1][9]
    for j in range(1,10):
        ls[i][j] = (ls[i][j-1] + ls[i][0] - ls[i-1][j-1])%10007

print(ls[n-1][9])
