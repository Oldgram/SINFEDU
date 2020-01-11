def check_format(line):
    if line.rstrip().count(' ') == len(line.rstrip()):
        return True
    elif line.count(",") != 3:
        print('Error : ' + line)
        return False
    line = line.rstrip().split(",")
    for index, sequence in enumerate(line):
        if index == 0:
            if len(sequence) != 8 or not sequence.isdigit():
                print('Error : ' + str(line) + ' : ' + sequence)
                return False
        elif index == 1 or index == 2:
            if len(sequence) == 0 or sequence.count(" ") == len(sequence):
                print('Error : ' + str(line) + ' : ' + sequence)
                return False
        elif index == 3:
            if sequence.count("@") != 1:
                print('Error : ' + str(line) + ' : ' + sequence)
                return False
    return True


def est_correct(filename):
    try:
        with open(filename) as file:
            parse = file.readlines()
        for line in parse:
            if not check_format(line):
                return False
        return True
    except EnvironmentError:
        return False


with open('student_1.txt', 'w') as file1:
    file1.writelines(['  \n', '12345678,Name,Surname,email@mail.com\n', '12345678,Name,Surname,email@mail.com\n',
                      '12345678,Name,Surname,email@mail.com\n', '12345678,Name,Surname,email@mail.com\n',
                      '12345678,Name,Surname,email@mail.com\n', '12345678,Name,Surname,email@mail.com\n'])
with open('student_2.txt', 'w') as file2:
    file2.writelines(['12345678,Name,Surname,email@mail.com\n', '1235678, ,Surname,emailmail.com\n',
                      '12345678,Name,Surname,email@mail.com\n', '12345678,Name,Surname,email@mail.com\n',
                      '12345678,Name,Surname,email@mail.com\n', '12345678,Name,Surname,email@mail.com\n'])

print(est_correct('studenttxt'))
print(est_correct('student_1.txt'))
print(est_correct('student_2.txt'))
