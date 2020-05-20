def common_path_at_end(route1, route2):  # NE PAS EFFACER CETTE LIGNE
    """
    @pre:   route1 et route2 sont deux listes de strings
    @post:  retourne une liste reprenant le plus grand suffixe
            commun entre route1 et route2. Autrement dit la plus longue sous-séquence
            en partant de la fin qui contient les mêmes éléments.
            route1 et route2 n'ont pas été modifiées.
    Note : 45%
    """
    common_end = []
    if len(route1) > len(route2):  # On compare la taille des deux listes pour ne garde que la taille de la plus
        # courte, afin d'éviter des erreurs d'indexes
        shortest = len(route2)
    else:
        shortest = len(route1)
    for index in range(1, shortest):  # On parcours les deux listes en sens inverse, si les deux éléments sont
        # identiques, on l'ajoute à la lise commune, sinon on casse la boucle
        if route1[-index] == route2[-index]:
            common_end.insert(0, route1[-index])  # On utilise la méthode insert car on veut ajouter au début de la
            # liste et non à la fin de cette dernière
        else:
            break
    return common_end
