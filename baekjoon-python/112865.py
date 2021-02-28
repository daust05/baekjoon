'''
각 무게에 가장 높은 가치를 저정한 배열을 지정한다

'''

n, max_weight = [int(x) for x in input().split()]
weight = []
value = []

for i in range(n):
    w, v = [int(x) for x in input().split()]
    weight.append(w)
    value. append(v)

# 최선의 무게를 저장할 배열
bag = [{'weight': -1, 'list':[]} for _ in range(max_weight)]

def dp(k):
    if bag[k].weight == -1:
        # 최선의 경우 찾기
        max = {'index': -1, 'value' : 0}
        for index, w, v in enumerate(weight, value):
            if w <= k and (v / w) > max.value:
                max.index = index
                max.value = (v / w)
        # 최선의 무게를 제외한 나머지 무게로 재귀
        if max.index > -1:
            bag[k].weight = weight[max.index] + dp(k- weight[max.index])
        # 만약 무게에 맞는 경우가 없다면 0을 반환
        else:
            return 0
    else:
        return bag[k].weight

dp(max_weight)
