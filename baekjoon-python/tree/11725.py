import sys
sys.setrecursionlimit(150000)

n = int(input())

tree = [[] for _ in range(n+1)]

for i in range(n-1):
    n1, n2 = [int(x) for x in input().split()]
    tree[n1].append(n2)
    tree[n2].append(n1)

parent = [0]*(n+1)
def dfs(n):
    for leaf in tree[n]:
        if parent[leaf] == 0:
            parent[leaf] = n
            dfs(leaf)
dfs(1)
for leaf in range(2,n+1):
    print(parent[leaf])