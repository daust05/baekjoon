n = int(input())
for l in range(n):
    x1,y1,x2,y2 = [int(x) for x in input().split()]
    case_num = int(input())
    count = 0
    for i in range(case_num):
        cx,cy,cr = [int(x) for x in input().split()]
        dist = ((cx-x1)**2 + (cy-y1)**2)**0.5
        if dist <= cr:
            dist = ((cx-x2)**2 + (cy-y2)**2)**0.5
            if dist >= cr:
                count += 1

        dist = ((cx-x2)**2 + (cy-y2)**2)**0.5
        if dist <= cr:
            dist = ((cx-x1)**2 + (cy-y1)**2)**0.5
            if dist >= cr:
                count += 1
    print(count)

        