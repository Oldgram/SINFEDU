def paire_max_efficace(a):
    """
    Calcule la somme maximale d'une paire d'entiers de `a`
    pre: `a` est un tableau (list) d'entiers
    pre: len(`a`) >= 2
    post: retourne la somme maximale obtenue a partir d'une
        paire d'entiers de `a`

    Cet algorithme est en theta(n)
    """
    highest, secondhighest = max(a[0], a[1]), min(a[0], a[1])

    for i in range(2, len(a)):
        if a[i] > highest:
            secondhighest = highest
            highest = a[i]
        else:
            if a[i] > secondhighest:
                secondhighest = a[i]
    return highest + secondhighest


# Exemples de test:
if not paire_max_efficace([0, 1]) == 1:
    print("Tableau de deux entiers")
