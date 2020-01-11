def plus_frequent(lst):
    occ = {}
    most_frequent_value, most_frequent_index, most_frequent_word = 0, 0, 'Default'
    for index, element in enumerate(lst):
        if element in occ:
            occ[element][0] += 1
        else:
            occ[element] = [1, index]
    for element, sub_list in occ.items():
        if sub_list[0] > most_frequent_value or (sub_list[0] == most_frequent_value and sub_list[1] == most_frequent_index):
            most_frequent_value = sub_list[0]
            most_frequent_index = sub_list[1]
            most_frequent_word = element
    return most_frequent_word