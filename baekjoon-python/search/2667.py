n = int(input())
town =[]
for i in range(n):
    town.append(list(input()))

visited = [0 for j in town for i in j]