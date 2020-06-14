from List import List


def maximum_rec(l):
    """
    Calcule le maximum d une liste par récursion
    pre: `l` contient au moins un élément
    post: retourne l élément maximum de `l`
    """
    if l.tail().is_empty():
        return l.head()
    else:
        return max(l.head(), maximum_rec(l.tail()))


# Exemple de test:
l = List()
l = l.concat(5)
l = l.concat(4)
l = l.concat(3)
l = l.concat(2)
l = l.concat(1)

if not maximum_rec(l) == 5:
    print("Erreur : le maximum de la liste " + str(l) + " est 5.")
