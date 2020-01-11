class PositionList:

    def __init__(self, x_lim, y_lim):
        self.head = None
        self.x_lim = x_lim
        self.y_lim = y_lim

    def __str__(self):
        string = '['
        node = self.head
        while node is not None:
            string += node.__str__()
            node = node.next_node
        string += ']'
        return string

    def existe(self, x, y):
        if x > self.x_lim - 1 or y > self.y_lim - 1 or x < 0 or y < 0:
            return 'out-of-bounds'
        node = self.head
        while node is not None:
            if node.x == x and node.y == y:
                return node.val
            node = node.next_node
        return False


class PositionNode:

    def __init__(self, x, y, val, next_node=None):
        self.x = x
        self.y = y
        self.val = val
        self.next_node = next_node

    def __str__(self):
        return '(' + str(self.x) + ',' + str(self.y) + ',' + str(self.val) + ')'


matrix = PositionList(10, 10)
node5 = PositionNode(9, 9, 'e')
node4 = PositionNode(5, 5, 'w', node5)
node3 = PositionNode(5, 4, 'c', node4)
node2 = PositionNode(2, 7, 'b', node3)
node1 = PositionNode(1, 2, 'g', node2)
matrix.head = node1
print(matrix)
print(matrix.existe(0, 0))
print(matrix.existe(2, 7))
print(matrix.existe(0, 10))
