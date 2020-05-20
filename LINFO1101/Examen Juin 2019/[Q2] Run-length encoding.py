def rle(lst):
    lst.append(None)
    cod, pelement, count = [], None, 1
    for element in lst:
        if pelement is None:
            pelement = element
        elif element == pelement:
            count += 1
        else:
            cod.append((count,pelement))
            count = 1
            pelement = element
    return cod


print(rle(['A','A','A','','b','b','!','t','t','T']))
