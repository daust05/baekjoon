'''
0 [1]
1 [0 2]
2 [1 3]
'''

n = int(input())
dt = [[-1]*(n+1) for _ in range(10)]
def solve(num, n):
    if n == 1:
        return 1
    if dt[num][n] != -1:
        return dt[num][n]
    
    if num == 0:
        dt[num][n] = solve(1,n-1)
        return dt[num][n]
    elif num == 9:
        dt[num][n] = solve(8,n-1)
        return dt[num][n]
    else:
        dt[num][n] = solve(num-1,n-1) + solve(num+1,n-1)
        return dt[num][n]

ans = 0
for i in range(1,10):
    ans += solve(i,n)
    
print(*dt, sep='\n')
print(ans%1000000000)