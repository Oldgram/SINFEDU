i = 0
num = 0
den = 0
while l[i] < 9999 and i < len(l):
    if l[i] >= 0:
        num += l[i]
        den += 1
    i += 1
return num/den