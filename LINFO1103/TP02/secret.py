def secret(n):
    """
    pre: `n` > 0
    post: ???
    """
    return n * 2 ** n


# Exemple de test:
if not (secret(3)) == 24:
    print("La réponse attendue était 24 pour n=3")
