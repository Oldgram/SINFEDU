def carre_magique(carre):
    const = sum(carre[0])
    for line in carre[1:]:
        if const != sum(line): return False
    for i in range(len(carre)):
        som = 0
        for j in range(len(carre)):
            som += carre[j][i]
        if som != const: return False
    som = 0
    for i in range(len(carre)):
        som += carre[i][i]
    if som != const: return False
    som = 0
    for i in range(len(carre)):
        som += carre[i][-i-1]
    if som != const: return False
    return True