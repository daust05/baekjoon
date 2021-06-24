n = int(input())
stk =[]
ans = []
for i in range(n):
    inp = input().split()
    if inp[0] == 'push':
        stk.append(int(inp[1]))
    elif inp[0] == 'pop':
        if len(stk) == 0:
            ans.append(-1)
        else:
            ans.append(stk.pop())
    elif inp[0] == 'size':
        ans.append(len(stk))
    elif inp[0] == 'top':
        if len(stk) == 0:
            ans.append(-1)
        else:
            ans.append(stk[-1])
    elif inp[0] == 'empty':
        if len(stk) == 0:
            ans.append(1)
        else:
            ans.append(0)

for i in ans:
    print(i)