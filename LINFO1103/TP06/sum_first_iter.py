def sum_first_iter(t, n):
    """
    Calcule la somme des `n` premiers éléments de `t` avec une boucle
    pre: `t` un tableau (list) non vide
    pre: `n` un entier tel que 1<=`n`<=len(`t`)
    post: retourne la somme des `n` premiers éléments de `t`
    """
    result = 0
    for i in range(n):
        result += t[i]
    return result


# Exemple de test:
if not sum_first_iter([1, 2, 3, 5, 7, 9, 11], 2) == 3:
    print("Erreur : 1+2 = 3")
