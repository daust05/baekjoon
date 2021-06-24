import sys

## input
r, c = [int(x) for x in input().split()]
maze = []

pos_B = [-1,-1]
pos_R = [-1,-1]
for i in range(r):
    maze.append(list(input()))

    # find index of B
    if 'B' in maze[i]:
        index = maze[i].index('B')
        pos_B = [i, index]

    if 'R' in maze[i]:
        index = maze[i].index('R')
        pos_R = [i, index]
## input test print
# print(*maze, sep='\n') 

'''
while queue가 empty할경우 더이상 움직일 방향이 없을때까지
    이전 방향과 다른 방향으로 움직임 count_loop =0 (max = 3)
        새로운 방향 = (dir_num + count_loop)%4
    
    구슬이 움직이면 count_loop 초기화
    구슬의 움직임: 
        .이 안나올때까지 해당방향으로 구슬 이동
        O가 나오면 min 기록
    구슬이 움직이지 않을경우
        스택에 dir_num과 count_loop을 push하고 continue

    나머지 3방향으로 움직이고 움직일 곳이 없으면 체크 하고 돌아옴
'''
dir = [[-1,0], [0,1], [1,0], [0,-1]]
posQ = [ pos_B, pos_R]
dirQ = [[0, 0]]
#회전수
count = 0 

while dirQ:
    dirOffset, dirCount = dirQ.pop()
    pos_B,pos_R = posQ.pop()

    while dirCount <= 3:
        pos_old = pos_R
        y, x = pos_B + dir[(dirOffset+ dirCount)%4]

        if maze[y][x] == 'R' or maze[y][x] == '.':
            while maze[y][x] == 'R' or maze[y][x] == '.':
                pos_old = [y, x]
                y, x = pos_old + dir[dirOffset+ dirCount]

            y, x= pos_old
            



        dirCount += 1
    
