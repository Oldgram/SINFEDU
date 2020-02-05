class Couloir(Piece):

    def __init__(self, longueur):
        reste, nb = longueur, 0
        while reste > 0.0:
            reste -= 5.0
            nb += 1
        self.longueur = longueur
        self.nb_lampes = nb
        self.lampes = [TubeFluorescent()] * nb
        super().__init__("couloir", self.lampes, 2)
