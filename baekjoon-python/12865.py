'''
물건을 한번 씩만 사용가능하기 때문에 이차원 배열로 물건 체크와 무게 체크를 동시에 한다

예시
4 7
6 13
4 8
3 6
5 12

N:4 K:7 W:  1   2   3   4   5   6   7   j
[6, 13]     0   0   0   0   0   13  13
[4, 8]      0   0   0   8   8   13  13
[3, 6]      0   0   6   8   8   13  14
[5, 12]     0   0   6   8   12  13  14
    i
'''

n, k = [int(x) for x in input().split()]
item=[[0, 0]]
for i in range(n):
    w, v = [int(x) for x in input().split()]
    item.append([w, v])

bag = [[0]*(k+1) for _ in range(0,n+1)]
for i in range(1,n+1):
    for j in range(1,k+1):
        weight = item[i][0]
        value = item[i][1]
        if j >= weight:
            bag[i][j] = max(bag[i-1][j], value + bag[i-1][j-weight])
        else:
            bag[i][j] = bag[i-1][j]

print(bag[n][k])