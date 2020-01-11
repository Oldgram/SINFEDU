def mix(l):
    r, i = [], 0
    while len(r) != len(l):
        if i >= 0 and i < len(l) and i % 2 == 0:
            r.extend((l[i//2], l[len(l)-1-(i//2)]))
            i += 1
        else:
            r.extend((l[i], l[-(i+1)]))
            i += 1
    return r