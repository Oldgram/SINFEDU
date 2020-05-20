def acrostiche(file_name):
    acr = ""
    try:
        with open(file_name) as file:
            parse = file.readlines()
        for line in parse:
            line = line.strip()
            for i in line:
                if i.isalpha() and i != "":
                    acr += i
                    break
        return acr
    except EnvironmentError:
        return -1