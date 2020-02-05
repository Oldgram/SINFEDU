def load(filename, dictionnary):        # NE PAS EFFACER CETTE LIGNE
    """
    @pre    filename est le nom d'un fichier de texte,
            dictionnary est un dictionnaire avec :
                comme clés : des chaînes de caractères (les noms d'utilisateurs)
                comme valeurs : des entiers (un code pin associé à l'utilisateur)
    @post   Met à jour le dictionnaire à partir des clients repris dans le fichier de nom filename.
            Si une erreur se produit pendant la lecture du fichier, le dictionnaire n'est pas
            modifié.
            Retourne :
                True     si le fichier a été lu sans erreurs
                False    sinon
    Note : 90%
    """
    storage = []
    try:
        with open(filename) as file:
            parse = file.readlines()
        for line in parse:
            tmp_name, tmp_pin = line.strip().split("!")  # On sépare les lignes en deux (nom et pin)
            if " " in tmp_name or len(tmp_pin) != 4 or tmp_pin[0] == "0" or not tmp_pin.isdigit():  # On vérifie
                # chaque ligne (le nom et le code pin)
                raise EnvironmentError
            else:
                storage.append((tmp_name,tmp_pin))  # On ajoute à ne liste temporaire, qui ne sera ajouté au
                # dictionnaire que lorsque toute les lignes auront été vérifiées
        for name, pin in storage:
            dictionnary[name] = int(pin)
        return True
    except EnvironmentError:  # S'il y a une erreur dans la lecture du fichier (OSError, IOError, etc.),
        # EnvirnomentError sera levé, mais également si une des lignes est mal formatée (dans ce cas,
        # on lève l'erreur manuellement)
        return False
