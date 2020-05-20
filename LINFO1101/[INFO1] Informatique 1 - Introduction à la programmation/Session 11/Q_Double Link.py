class Node:
    def __init__(self, cargo, previous=None, next=None):
        self.__cargo = cargo
        self.previous = previous
        self.next = next

    def get_text(self):
        return self.__cargo

    def set_text(self, string):
        self.__cargo = string