import sys
from collections import deque

R, C = map(int, sys.stdin.readline().split())
field=[]
gooses = []
water = []
next_water = []
goose = []
next_goose = []
move = [[1,0],[0,1],[-1,0],[0,-1]]

for i in range(R):
    field.append(list(sys.stdin.readline().replace("\n","")))
    for j,val in enumerate(field[i]):
        if val == 'L':
            gooses.append([i,j])
        if val != 'X':
            water.append([i,j])

    
goose.append(gooses[0])
visited = [[0]* C for _ in range(R)]
visited[gooses[0][0]][gooses[0][1]] = 1
found = 0
for i in range(R+C):
    # goose bfs
    next_goose=[]
    while goose:
        gPos = goose.pop()
        for j in range(4):
            gY = gPos[0] + move[j][0]
            gX = gPos[1] + move[j][1]

            if gY < 0 or gY >= R or gX < 0 or gX >=C:
                continue
            if visited[gY][gX]:
                continue

            visited[gY][gX] = 1
            if field[gY][gX] == '.':
                goose.append([gY,gX])
            elif field[gY][gX] == 'X':
                next_goose.append([gY,gX])
            else:
                found =1
                break
        if found:
            break
    if goose:
        print(i)
        break
    goose = next_goose
    # water bfs
    next_water = []
    while water:
        wPos = water.pop()
        for j in range(4):
            wY = wPos[0] + move[j][0]
            wX = wPos[1] + move[j][1]

            if wY < 0 or wY >= R or wX < 0 or wX >=C:
                continue

            if field[wY][wX] == 'X':
                field[wY][wX] = '.'
                next_water.append([wY,wX])

    water = next_water


