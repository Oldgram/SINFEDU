def somme_des(n):
    dic = {}
    comb = 0
    for i in range(1,n+1):
        for l in range(1,n+1):
            try:
                dic[i+l].append((i, l))
            except KeyError:
                dic[i+l] = []
                dic[i+l].append((i, l))
    return dic