def mystere(n):
    """
    pre: `n` > 0
    post: ???
    """
    return (n ** 3 + 3 * n ** 2 + 2 * n) / 3


# Exemple de test:
if not(mystere(1)) == 2:
    print("La réponse attendue était 2 pour n=1")
if not(mystere(2)) == 8:
    print("La réponse attendue était 8 pour n=2")
if not(mystere(3)) == 20:
    print("La réponse attendue était 20 pour n=3")
