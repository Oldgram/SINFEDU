class Node:
    def __init__(self, elem=None, next=None):
        """
        pre: -
        post: matrix new Node object has been initialised.
        matrix node can contain an element and a reference to a next node.
        If none of these are given, a node with an empty elem (None)
        and no reference (None) is created.
            """
        self.elem = elem
        self.next = next

    def value(self):
        """
        pre: -
        post: returns the value of the element contained in this Node.
        """
        return self.elem

    def getnext(self):
        """
        pre: -
        post: returns the next Node from the current Node,
        None if there is no such Node.
        """
        return self.next

    def __str__(self):
        return str(self.value())
