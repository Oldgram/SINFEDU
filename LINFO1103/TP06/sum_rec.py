def compute_rec(n):
    """
    Approche récursive
    pre: `n` est un entier >= 0
    post: retourne la somme des entiers de 0 à `n` compris
    """
    if n == 0:
        return n

    return n + compute_rec(n - 1)


# Exemple de test:
if not compute_rec(3) == 6:
    print("Erreur: 0 + 1+ 2 + 3 = 6")
