from stats import insertion_sort


def median(values):
    """
    pre: `values` est un tableau (list) d objets comparables
    post: renvoie la mesure médiane du tableau `values` sans changer l'ordre du tableau
    """
    values, length = insertion_sort(values), len(values)

    if length % 2 == 0:
        med = (values[length // 2 - 1] + values[length // 2]) / 2
    else:
        med = values[length // 2]

    return med


############
# Exemple de test:
if not median([2019, 2, 0, 1, 9]) == 2:
    print("Erreur de médiane")
