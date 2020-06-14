def puiss_rec(x, n):
    """
    Exponentiation rapide par récursion
    pre: `n` >= 0
    post: retourne `x`^`n`
    """
    if n == 0:
        return 1
    elif n % 2 == 0:
        return puiss_rec(x * x, n // 2)
    else:
        return x * puiss_rec(x * x, (n - 1) // 2)


# Exemple de test:
if not puiss_rec(10, 0) == 1:
    print("Erreur: 10 puissance 0 = 1")
