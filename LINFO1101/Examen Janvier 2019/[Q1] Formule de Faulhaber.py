def faulhaber_max(x, p):
    som = 0
    for i in range(x):
        som += i**p
        if som >= x:
            return pi
        pi = i