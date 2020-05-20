def check_seq(string):
    count = 0
    if string == 'OXO':
        count += 1
    return count


def check_hori(grille):
    score = 0
    for lst in grille:
        string = ''.join(lst)
        string = [string[i:i + 3] for i in range(0, len(string)-2)]
        for hseq in string:
            score += check_seq(hseq)
    return score


def check_vert(grille):
    score = 0
    for col in range(len(grille[0])):
        for line in range(len(grille)-2):
            vseq = grille[line][col] + grille[line+1][col] + grille[line+2][col]
            score += check_seq(vseq)
    return score


def check_diag(grille):
    score = 0
    for col in range(len(grille[0])-2):
        for line in range(len(grille)-2):
            dseq = grille[line][col] + grille[line+1][col+1] + grille[line+2][col+2]
            score += check_seq(dseq)
    for col in range(1, len(grille[0])-1):
        for line in range(1, len(grille)-1):
            dseq = grille[-line][-col] + grille[-line-1][-col-1] + grille[-line-2][-col-2]
            score += check_seq(dseq)
    return score


def oxo(grille):
    if not grille:
        return 0
    total_score = check_hori(grille) + check_vert(grille) + check_diag(grille)
    return total_score


matrix = [['O', ' ', 'O'],
          ['X', 'X', 'X'],
          ['O', ' ', 'O'],
          ['O', 'X', 'O']]
print(oxo(matrix))
