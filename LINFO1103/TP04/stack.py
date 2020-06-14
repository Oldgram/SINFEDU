from node import Node


class Stack:

    def __init__(self):
        self.head = None
        self.length = 0

    def is_empty(self):
        """
        pre: -
        post: return a boolean True if the stack is empty, False otherwise
        """
        return self.head is None

    def push(self, item):
        """
        pre: -
        post: add a new item on top of the stack
        """
        self.head = Node(elem=item, next=self.head)
        self.length += 1

    def pop(self):
        """
        pre: the stack is not empty
        post: remove and return the item on top of the stack
        """
        if not self.is_empty():
            item = self.head.value()
            self.head = self.head.getnext()
            self.length -= 1
            return item
        else:
            raise RuntimeError('Cannot pop from an empty Stack')
