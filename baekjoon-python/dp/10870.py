def fibo(n):
    if dp[n] == -1:
        dp[n] = fibo(n-1) + fibo(n-2) 
    return dp[n]

N = int(input())
dp = [0, 1] + [-1]*N
print(fibo(N))