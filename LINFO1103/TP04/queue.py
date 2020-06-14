class Queue:
    def __init__(self):
        self.head = None
        self.tail = None
        self.items = []

    def __len__(self):
        """
        pre: -
        post: La longueur de la file
        """
        return len(self.items)

    def enqueue(self, item):
        """
        pre: -
        post: item est ajouté en fin de file
        """
        self.tail = item
        self.items.append(item)

    def dequeue(self):
        """
        pre: la file ne doit pas être vide
        post: le premier élément de la file est retiré et retourné
        """
        removed = None
        try:
            removed = self.items[0]
            self.items.pop(0)
            self.head = self.items[0]
        except IndexError:
            self.head = None
            self.tail = None
        return removed

    def is_empty(self):
        """
        pre: -
        post: True si la file est vide, False autrement
        """
        return len(self) == 0

    def __str__(self):
        return ', '.join(self.items)


# Exemples de tests:
file = Queue()
items = [i for i in range(1, 50)]

if not file.is_empty():
    print("Une nouvelle file devrait être vide après initialisation.")

for i in items:
    file.enqueue(i)
    if not len(file) == i:
        print("La taille de la file ({}) est incorrecte après ajout de l'élément : {}.".format(len(file), i))

for i in items:
    if not file.dequeue() == i:
        print("La suppression d'un élément ne renvoit pas le bon élément : {}.".format(i))
