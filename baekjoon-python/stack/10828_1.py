n = int(input())

stk = []

class Lib:
    def push(num):
        stk.append(num)

    def pop():
        if len(stk) == 0:
            print(-1)
        else:
            print(stk.pop())

    def top():
        if len(stk) == 0:
            print(-1)
        else:
            print(stk[-1])
    
    def size():
        print(len(stk))
    
    def empty():
        if len(stk)==0:
            print(1)
        else:
            print(0)

for i in range(n):
    inp = input().split()

    # print(len(inp))
    # print(inp)

    if len(inp) == 1:
        Lib.__dict__[inp[0]]()
    else:
        Lib.__dict__[inp[0]](int(inp[1]))
