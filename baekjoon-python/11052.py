# 점화식 : cost = highest price + cost(total card - highest price card number) 

n = int(input())

price = [0] + [int(x) for x in input().split()]
cost = [0] + [-1 for _ in range(n)]


def buy(cards):
    if cards == 0:
        return 0
    if cost[cards] != -1:
        return cost[cards]
    else:
        max = 0
        for index, pack in enumerate(price):
            if index == 0:
                continue
            if index > cards:
                break
            
            money = pack + buy(cards-index)
            if money > max:
                max = money

        cost[cards] = max
        return cost[cards]

print(buy(n))