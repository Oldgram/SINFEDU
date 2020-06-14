from Queue import Queue
from Stack import Stack


def dec_to_bin(n):
    """
    pre: `n` > 0
    post: renvoie la représentation binaire de `n`.
        Le premier élément de la file renvoyée est le bit de poids fort.
        Le nombre de bits renvoyé est le plus petit possible.
    """
    bin_stack, bin_queue, i, somme = Stack(), Queue(), 0, 0

    while somme != n:
        bi = (n // (2 ** i)) % 2
        bin_stack.push(bi)
        somme += bi * (2 ** i)
        i += 1

    while not bin_stack.is_empty():
        bin_queue.enqueue(bin_stack.pop())

    return bin_queue


# Exemples de tests:
file = dec_to_bin(42)

if not len(file) == 6:
    print("La représentation binaire de 42 comprend 6 bits.")
else:
    for bit in [1, 0, 1, 0, 1, 0]:
        if not file.dequeue() == bit:
            print("La représentation binaire de 42 est incorrecte. Attention aux spécifications.")
