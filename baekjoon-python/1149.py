

#참고 풀이 : https://youtu.be/YUtGZ2AQ2Rc

n = int(input())
li = []
r, g, b = [int(x) for x in input().split()]
li.append([r, g, b])
for i in range(1, n):
    r, g, b = [int(x) for x in input().split()]
    pR, pG, pB = li[-1]
    R = r + min(pG, pB)
    G = g + min(pR, pB)
    B=  b + min(pR, pG)
    li.append([R,G,B])
fR,fG,fB = li[-1]
print(min(fR,fG,fB))