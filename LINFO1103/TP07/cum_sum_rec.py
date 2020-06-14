from List import List


def cum_sum_rec(l):
    """
    Calcule la liste des sommes cumulées des éléments de `l`
    par récursion
    pre: -
    post: retourne une liste dont le `i`^ième élément est la somme
        des `i` premiers éléments de `l`
    """
    def cum_sum_calc(l, sum):
        if l.is_empty():
            return List()
        sum += l.head()
        return cum_sum_calc(l.tail(), sum).concat(sum)

    return cum_sum_calc(l, 0)


# Exemple de test:
l = List()
l = l.concat(5)
l = l.concat(4)
l = l.concat(3)
l = l.concat(2)
l = l.concat(1)
cm = cum_sum_rec(l)
if not isinstance(cm, List):
    print("Erreur avec cum_sum : doit renvoyer une List")
elif cm.is_empty():
    print("Erreur avec cum_cum : la List ne devrait pas être vide")
else:
    if not cm.head() == 1:
        print("Erreur avec cum_sum. Le premier élement devrait être 1.")
    if not cm.tail().head() == 3:
        print("Erreur avec cum_sum. Le second élément devrait être 3.")
