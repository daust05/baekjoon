N = int(input())
stair = []
for i in range(N):
    stair.append(int(input()))

dp=[0]*N
dp[0] = stair[0]
if N > 1:
    dp[1] = stair[1] + dp[0]
if N > 2:
    dp[2] = max(stair[2] + stair[0], stair[2]+ stair[1])

for i in range(3,N):
    dp[i] = max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i])

print(dp[-1])