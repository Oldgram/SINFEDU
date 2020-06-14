def max_interval(mesures):
    """
    Etant donne une sequence de mesures espacees de 10 minutes, determine l'intervalle d'une heure durant lequel le
    niveau d'eau est le plus eleve en moyenne.

    pre: - mesures est un tableau (list)
         - len(mesures) >= 7
    post: renvoie l'indice du tableau mesures auquel commence le premier sous-tableau de longueur 7 de plus forte
    moyenne.
    """
    high, index = sum(mesures[:7]), 0
    if len(mesures) > 7:
        for i in range(1, len(mesures) - 6):
            inter = sum(mesures[i:i + 7])
            if inter > high:
                high, index = inter, i
    return index


# Exemples tests:
if not max_interval([60, 0, 5, 10, 30, 10, 20, 30]) == 0:
    print("Plus longue serie au debut")
if not max_interval([10, 0, 5, 10, 30, 10, 20, 30]) == 1:
    print("Plus longue serie a la fin")
if not max_interval([37, 13, 32, 8, 18, 8, 48, 6, 39]) == 0:
    print("Plus longue serie au debut")