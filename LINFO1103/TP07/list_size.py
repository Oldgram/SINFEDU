from List import List


def length(l):
    """
    Calcule la taille d une liste à l aide d une boucle
    pre: -
    post: retourne la taille de la liste `l`
    """
    if l.is_empty():
        return 0
    tail, size = l.tail(), 1
    while not tail.is_empty():
        size += 1
        tail = tail.tail()
    return size


# Exemple de test:
l = List()
l = l.concat(5)
l = l.concat(4)
l = l.concat(3)
l = l.concat(2)
l = l.concat(1)

if not length(l) == 5:
    print("Erreur : liste " + str(l) + " est de longueur 5.")
