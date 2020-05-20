def est_correct(self):
    n, is_correct = self.dimension, None
    for i in range(n):
        for k in range(n):
            if is_correct is None or is_correct:
                is_correct = self.check_list(self.get_carre_valeurs(i, k))
    for l in range(n*n):
        if is_correct:
            is_correct = self.check_list(self.get_ligne(l))
            if is_correct:
                is_correct = self.check_list(self.get_colonne(l))
    return is_correct
        

def check_list(self, lst):
    pelement, n_n = None, self.dimension*self.dimension
    for element in sorted(lst):
        if pelement is None:
            pelement = element
        elif pelement == element:
            return False
        elif element > n_n:
            return False
        pelement = element
    return True