try:
    with open(filename) as file:
        parse = []
        for index, line in enumerate(file.readlines()):
            if index < 2:
                parse.append(int(line.strip()))
            else:
                line = line.strip().split()
                line[0] = line[0].split(",")
                line[0][0], line[0][1] = int(line[0][0]), int(line[0][1])
                parse.append(line)
        matrix = [[0.0]*parse[0]]*parse[1]
        for k in range(2, len(parse)):
            matrix[parse[k][0][0]][parse[k][0][1]] = float(parse[k][1])
    return matrix
except EnvironmentError:
    return None