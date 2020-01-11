def diviseurs(l1, l2):
    div = {}
    if l1:
        for diviseur in l1:
            div[diviseur] = []
            for dividende in l2:
                if dividende % diviseur == 0:
                    div[diviseur].append(dividende)
    return div


print(diviseurs([3,5,10], [9,15,10,150]))
print(diviseurs([], [9,15,10,150]))
print(diviseurs([3,5,10], []))
