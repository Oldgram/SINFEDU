def ajouter_lampe(self, lampe):  # NE PAS SUPPRIMER CETTE LIGNE
    """
    ajoute un Node contenant la nouvelle lampe à la pièce dans la liste chaînée
    en cas d'ajout d'une lampe avec la même puissance d'une lampe déjà existante
    dans la liste, cette nouvelle lampe sera ajoutée avant la lampe existante
    la liste chaînée doit rester triée par ordre décroissant de puissance
    le nombre de lampes dans la pièce a été incrémenté de 1
    Note : 100%
    """
    lampe_node = self.Node(lampe, next=None)
    if self.__n_lampes > 0:  # On regarde s'il y a déjà au moins une lampe dans la pièce
        node = self.__pire_lampe
        if node.value().puissance_kWh() > lampe_node.value().puissance_kWh():  # On regarde si la nouvelle lampe
            # consomme plus que la première
            while node.next() is not None and node.next().value().puissance_kWh() > lampe_node.value().puissance_kWh():
                # Si non, on avance dans la liste en comparant la consommation de la prochaine lampe avant
                node = node.next()
            lampe_node.set_next(node.next())
            node.set_next(lampe_node)
            self.__n_lampes += 1
        else:  # Si oui, on remplace la pire lampe par la nouvelle, la précédente devenant la deuxième pire lampe
            lampe_node.set_next(node)
            self.__pire_lampe = lampe_node
            self.__n_lampes += 1
    else:  # S'il n'y a pas déjà de lampe dans la pièce, on ajoute la première
        self.__pire_lampe = lampe_node
        self.__n_lampes += 1
