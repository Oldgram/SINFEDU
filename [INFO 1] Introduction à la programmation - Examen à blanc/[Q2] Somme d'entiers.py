def combien(n):
    cmb, k = 0, 0
    while k < n:
        sum = 0
        for i in range(k, n+1):
            sum += i
            if sum == n:
                cmb, k = cmb + 1, k +1
            elif sum > n:
                sum, k = 0, k + 1
    return cmb