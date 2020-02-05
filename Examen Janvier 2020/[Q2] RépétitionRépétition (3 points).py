def repetition(string):  # NE PAS EFFACER CETTE LIGNE
    """
    @pre:  s est une chaîne de caractères non-vide composée seulement de lettres.
    @post: Retourne la longueur de la plus longue séquence consécutive de lettres répétées
           dans la chaîne de caractères s, sans tenir compte de la casse des lettres.
    Note : 100%
    """
    count, highest = 1, 0
    if string.isalpha() and string != "":  # On vérifie que la chaine de caractères ne contienne bien que des
        # lettres, et qu'elle ne soit pas nulle
        string = string.upper() + "!"
        pcarac, highest = string[0], 1
        for carac in string[1:]:  # On parcours la chaine de caractères en comptant les séquences et en gardant la
            # taille de la plus longue à chaque fois
            if carac == pcarac:
                count += 1
            else:
                if count > highest:
                    highest = count
                pcarac = carac
                count = 1
    return highest
