N, M = map(int, input().split())
dic = dict()
for i in range(N):
    dic[i] = input()

dicR = {v:k for k,v in dic.items()}

for i in range(M):
    q = input()
    if q.isdigit():
        print(dic[int(q)-1])    
    else:
        print(dicR[q]+1)