from List import List


def cum_sum(l):
    """
    Calcule la liste des sommes cumulées des éléments de `l`
    par itération
    pre: -
    post: retourne une liste dont le `i`^ième élément est la somme
        des `i` premiers éléments de `l`
    """
    cm_lst, sum_lst = List(), 0
    while not l.is_empty():
        sum_lst += l.head()
        cm_lst = cm_lst.concat(sum_lst)
        l = l.tail()
    out = List()
    while not cm_lst.is_empty():
        out = out.concat(cm_lst.head())
        cm_lst = cm_lst.tail()
    return out


# Exemple de test:
l = List()
l = l.concat(5)
l = l.concat(4)
l = l.concat(3)
l = l.concat(2)
l = l.concat(1)
cm = cum_sum(l)
if not isinstance(cm, List):
    print("Erreur avec cum_sum : doit renvoyer une List")
elif cm.is_empty():
    print("Erreur avec cum_sum : la List ne devrait pas être vide")
else:
    if not cm.head() == 1:
        print("Erreur avec cum_sum. Le premier élement devrait être 1.")
    if not cm.tail().head() == 3:
        print("Erreur avec cum_sum. Le second élément devrait être 3.")
