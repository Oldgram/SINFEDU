def caracteres_occurrences(l):
    dic = {}
    for index, i in enumerate(l):
        for k in i:
            if k in dic.keys():
                if index not in dic[k]:
                    dic[k].append(index)
            else:
                dic[k] = [index]
    return dic