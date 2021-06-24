#2021.04.06
#input => sys.stdin.readline() / map(int, sys.stdin.readline().split()) 으로 변경했더니 시간 대폭 감소
#탑다운으로 풀어도 문제 없을 것 같음

#탑다운으로 접근시 시간초과발생
#위상정렬(topological sort)로 다시 풀어야함
#위상정렬 관련 https://gmlwjd9405.github.io/2018/08/27/algorithm-topological-sort.html
import sys

# input
t = int(sys.stdin.readline())
for i in range(t):       
    n, k = map(int, sys.stdin.readline().split())
    cost = [0]+ list(map(int,sys.stdin.readline().split()))
    build = [[] for x in range(n+1)]
    # 진입차수(연결되있는 노드 수) 저장
    in_degree = [-1]+[0 for x in range(n)]
    dp = in_degree[:]
    for j in range(k):
        s, d = map(int, sys.stdin.readline().split())
        in_degree[d] += 1
        build[s].append(d)  
    
    top_queue = []
    for idx, item in enumerate(in_degree):
        if item == 0:
            top_queue.append(idx)
            dp[idx] = cost[idx]
    
    while top_queue:
        item = top_queue.pop(0)
        for i in build[item]:
            in_degree[i] -= 1
            dp[i] = max(dp[item] + cost[i], dp[i])
            if in_degree[i] == 0:
                top_queue.append(i)
                
    final = int(sys.stdin.readline())
    print(dp[final])

