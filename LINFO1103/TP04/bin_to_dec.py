from Queue import Queue
from Stack import Stack


def bin_to_dec(n):
    """
    pre: `n` est une file renvoyant la représentation binaire
        d un nombre en commençant par le bit de poids fort
    post: renvoie la valeur de `n` dans sa forme décimale
        `n` est vide
    """
    bin_list, somme = [], 0

    for nb in range(len(n) - 1, -1, -1):
        somme += n.dequeue() * (2 ** nb)

    return somme


# Exemples de tests:
file = Queue()
for i in [1, 0, 1, 0, 1, 0]:
    file.enqueue(i)

if not bin_to_dec(file) == 42:
    print("La représentation décimale de [1>0>1>0>1>0] " \
          "(avec en indice 0 le bit de poids fort) devrait être 42.")
