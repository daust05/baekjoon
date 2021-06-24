'''
3
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
'''
n = int(input())

for i in range(n):
    c = [int(x) for x in input().split()]

    dist = ((c[3]-c[0])**2+ (c[4]-c[1])**2)**0.5
    if c[0:3] == c[3:6]:
        print(-1)
    elif abs(c[2]-c[5]) == dist or c[2]+c[5] == dist:
        print(1)
    elif abs(c[2]-c[5]) < dist and c[2]+c[5] > dist:
        print(2)
    else:
        print(0)
