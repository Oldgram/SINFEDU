def plus_forte_moyenne(n_sieges, resultat_vote):
    """
    Calcul la repartition des sieges selon la methode de la plus
    forte moyenne (variante de D Hondt)
    pre: `n_sieges` > 0
    pre: len(`resultat_vote`) > 1
    pre: `resultat_vote[i]` >= 0
        pour tout `i` tel que 0 <= `i` < len(`resultat_vote`)
    post: retourne un tableau `t` de meme longueur que `resultat_vote`
        et tel que `t[i]` est le nombre de sieges attribues au parti
        correspondant a `resultat_vote[i]`
    """
    sieges, alloc, total = [], [], sum(resultat_vote)

    for index, element in enumerate(resultat_vote):
        alloc_exacte = element / total * n_sieges
        alloc.append([index, int(alloc_exacte), alloc_exacte % 1])

    for index, entier, decimal in alloc:
        sieges.append(entier)
        n_sieges -= entier

    while n_sieges > 0:
        iteration, bonus = 1, []
        for index, voies in enumerate(resultat_vote):
            bonus.append((index, voies / (sieges[index] + iteration)))
        bonus = sorted(bonus, key=lambda x: x[1], reverse=True)
        sieges[bonus[0][0]] += 1
        n_sieges -= 1
    return sieges


# Exemples de test:
if not plus_forte_moyenne(11, [437, 478, 85]) == [5, 5, 1]:
    print("Exemple de la méthode de D'Hondt")
