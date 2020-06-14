from stats import insertion_sort


def mode(values):
    """
    pre: `values` est un tableau (list) d objets comparables
    post: renvoie le mode du tableau (ou le mode de plus petite valeur si plusieurs modes)

    Cet algorithme s'exécute en Theta(n)
    """
    occurences, maxOcc, lmode = {}, -1, []

    for value in values:
        occurences[value] = occurences.get(value, 0) + 1

    for key in occurences:
        if occurences[key] > maxOcc:
            maxOcc = occurences[key]
    for key in occurences:
        if occurences[key] > maxOcc:
            maxOcc = occurences[key]
    for key in occurences:
        if occurences[key] == maxOcc:
            lmode.append(key)

    minMode = float("inf")
    for element in lmode:
        if element < minMode:
            minMode = element

    return minMode


############
# Exemple de test:
if not mode([1, 2, 2, 3, 3, 3, 4, 4, 4, 4]) == 4:
    print("Erreur de mode")
