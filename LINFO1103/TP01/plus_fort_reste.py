def plus_fort_reste(n_sieges, resultat_vote):
    """
    Calcul la repartition des sieges selon la methode du plus
    fort reste (variante du quotient de Hare)
    pre: `n_sieges` > 0
    pre: len(`resultat_vote`) > 1
    pre: `resultat_vote[i]` >= 0
        pour tout `i` tel que 0 <= `i` < len(`resultat_vote`)
    post: retourne un tableau `t` de même longueur que `resultat_vote`
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
    alloc = sorted(alloc, key=lambda x: x[2], reverse=True)
    for index, entier, decimal in alloc:
        if n_sieges <= 0:
            break
        sieges[index] += 1
        n_sieges -= 1
    return sieges


# Exemples de test:
if not plus_fort_reste(5, [437, 478, 85]) == [2, 2, 1]:
    print("Exemple de la méthode de Hare a 5 sieges")
if not plus_fort_reste(11, [437, 478, 85]) == [5, 5, 1]:
    print("Exemple de la méthode de Hare a 11 sieges")
if not plus_fort_reste(17, [70, 182, 544]) == [1, 4, 12]:
    print("Exemple de la méthode de Hare a 11 sieges")