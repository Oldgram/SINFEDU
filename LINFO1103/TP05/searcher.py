class book:
    """
    Classe représentant un livre, correspondant à une paire nom-année d'édition
    """

    def __init__(self, name, year):
        """Constructuer de la classe Book"""
        self.name = name
        self.year = year

    def __lt__(self, other):
        """Permet de comparer deux éléments. Correspond à l'opérateur <"""
        if isinstance(other, book):  # Test si l'autre élément est également un objet de type book
            return self.year < other.year  # Si c'est le cas, renvoie le résultat de la comparaison des dates d'edition
        else:
            return NotImplemented  # Sinon, indique que la comparaison n'est pas implémentée

    def __le__(self, other):
        """Permet de comparer deux éléments. Correspond à l'opérateur <="""
        if isinstance(other, book):
            return self.year <= other.year
        else:
            return NotImplemented

    def __eq__(self, other):
        """Permet de comparer deux éléments. Correspond à l'opérateur =="""
        if isinstance(other, book):
            return self.year == other.year
        else:
            return NotImplemented

    def __str__(self):
        return '{date}: {name}'.format(date=self.year, name=self.name)


def selection_sort_stable(books):
    """
    pre: `books` est un tableau (list) de `book`
    post: tri par sélection STABLE du tableau passé en paramètre.
        Les éléments sont triés en place
    On notera que book.sort() fonctionne également
    """
    for index, element in enumerate(books):
        lowest = index
        for j in range(index + 1, len(books)):
            if books[j] < books[lowest]:
                lowest = j
        if lowest != index:
            books.insert(index, books.pop(lowest))


############
# Exemple de test:

# Crée une liste de livres
library = [
    book('The Dream Quest of Unknown Kadath', 1927),
    book('The Shadow over Innsmouth', 1932),
    book('The Colour out of Space', 1927),
    book('The Dreams in the Witch-House', 1932),
    book('The Call of Cthulhu', 1926)
    ]

# Trie en place les libres de la bibliothèque
selection_sort_stable(library)
