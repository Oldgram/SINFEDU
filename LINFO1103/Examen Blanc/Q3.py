def find_in_list(l, e, k):
    """
    pre: `l` est une `List`
    pre: `e` est un élément éventuellement présent dans la liste `l` et différent de `None`
    pre: `k` est un entier tel que `k` > 0
    post: renvoie la sous-liste de `l` débutant à la `k`-ième occurrence de `e`dans `l`.
          Si `e` apparaît moins de `k` fois dans la liste `l`, renvoie `None`
    """
    if l.is_empty():
        return None

    if l.head() == e:
        if k == 1:
            return l
        else:
            return find_in_list(l.tail(), e, k-1)
    else:
        return find_in_list(l.tail(), e, k)
