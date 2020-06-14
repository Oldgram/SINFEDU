def top3(mesures):
    """
    Etant donne une sequence de mesures espacees de 10 minutes, identifie les trois mesures les plus élevées.

    pre: - mesures est un tableau (list)
         - len(mesures) >= 3
    post: renvoie un tableau t de longueur 3 tel que mesures[t[i]] correspond à la i^eme mesure la plus elevee.
    """
    lst = []
    for i in range(len(mesures)):
        if len(lst) < 1 or mesures[i] > mesures[lst[0]]:
            lst.insert(0, i)
        elif len(lst) < 2 or mesures[i] > mesures[lst[1]]:
            lst.insert(1, i)
        elif len(lst) < 3 or mesures[i] > mesures[lst[2]]:
            lst.insert(2, i)
    return lst[:3]


# Exemples tests:
if not top3([10, 9, 8, 7, 6, 5, 4, 3, 2, 1]) == [0, 1, 2]:
    print("Top 3 au début")
if not top3([0, 1, 2, 3]) == [3, 2, 1]:
    print("Top 3 à la fin")
if not top3([-1, -1, -1, -1, -1, -1, -1, -1, -1]) == [0, 1, 2]:
    print("Top 3 au début")