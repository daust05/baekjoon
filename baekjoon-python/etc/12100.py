import copy

UP = 1
DOWN = 2
LEFT = 3
RIGHT = 4

def solve():
    n = int(input())
    board = []
    # 보드 구현
    for i in range(n):
        board.append(list(map(int, input().split())))

    value = []
    for i in range(1,5):
        value.append(move(copy.deepcopy(board), i, 5))
    print(max(value))

# merge
def move(board, dir, loop):
    if loop == 0:
        return 0
    n = len(board)
    for i in range(n):
        # get line of board
        if dir == UP:
            line = [b[i] for b in board]
        elif dir == DOWN:
            line = list(reversed([b[i] for b in board]))
        elif dir == LEFT:
            line = board[i]
        elif dir == RIGHT:
            line = list(reversed(board[i]))
        # merge line
        for j in range(n):
            if line[j] == 0:
                continue
            for k in range(1,n-j):
                if line[j+k] == line[j]:
                    line[j] *= 2
                    line[j+k] = 0
                    break
                elif line[j+k] == 0:
                    continue
                else:
                    break
        # save to board
        if dir == DOWN or dir == RIGHT:
            line = list(reversed(line))
        line = [l for l in line if l != 0]

        if dir == UP or dir == LEFT:
            line = line + [0]*(n-len(line))
        else:
            line = [0]*(n-len(line)) + line

        if dir == UP or dir == DOWN:
            for b in board:
                if line:
                    b[i] = line.pop(0)
                else:
                    b[i] = 0
        else:
            board[i] = line
            
    if loop != 0:
        save_to_file([[loop,dir]])
    save_to_file(board)
    value = []
    value.append(maxBoard(board))
    for i in range(1,5):
        value.append(move(copy.deepcopy(board), i, loop-1))

    return max(value)

def maxBoard(board):
    maxValue = 0
    for b in board:
        if max(b) > maxValue:
            maxValue = max(b)
    return maxValue

def save_to_file(board):
    f = open('./output.txt','a')
    for b in board:
        data = '\t'.join([str(_) for _ in b])+'\n'
        f.write(data)
    f.write('\n')
    f.close()

f = open('./output.txt','w')
f.close()
solve()