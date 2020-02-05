def approx_pi(i):  # NE PAS EFFACER CETTE LIGNE
    """
    @pre:   i est un entier tel que i >= 0
    @post:  retourne une estimation de pi en sommant
            les i + 1 premiers termes de la série de Gregory-Leibniz
    Note : 100%
    """
    pi = 0
    if i >= 0:  # On vérifie que i soit bien supérieur à 0
        for n in range(0, i + 1):  # On fait la somme selon la série de Gregory-Leibniz
            pi += ((-1) ** n) / (2 * n + 1)
        pi *= 4  # Sans oublier de multiplier par 4
    return pi
