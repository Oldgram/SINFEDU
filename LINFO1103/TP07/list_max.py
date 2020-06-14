from List import List


def maximum(l):
    """
    Calcule le maximum d une liste à l aide d une boucle
    pre: `l` contient au moins un élément
    post: retourne l élément maximum de `l`
    """
    biggest, tail = l.head(), l.tail()

    while not tail.is_empty():
        if tail.head() > biggest:
            biggest = tail.head()
        tail = tail.tail()

    return biggest


# Exemple de test:
l = List()
l = l.concat(5)
l = l.concat(4)
l = l.concat(3)
l = l.concat(2)
l = l.concat(1)

if not maximum(l) == 5:
    print("Erreur : le maximum de la liste " + str(l) + " est 5.")
