def get_carre_valeurs(self, x, y):
    cell = self.carres[y][x].cells
    return cell[0] + cell[1]
    

def get_ligne(self, ligne):
    cell = []
    for carres in self.carres[ligne//2]:
        cell.append(carres.cells)
    ligne %= 2
    parse = []
    for line in cell:
        parse += line[ligne]
    return parse
        
        

def get_colonne(self, colonne):
    cell = []
    for i in range(len(self.carres)):
        carre = self.carres[i][colonne//2].cells
        for k in range(colonne%2, len(carre)):
            cell.append(carre[k])
    colonne %= 2
    parse = []
    for line in cell:
        parse.append(line[colonne])
    return parse