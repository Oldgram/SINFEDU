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

    def insert(self, x, y, val):
        if x > self.x_lim - 1 or y > self.y_lim - 1 or x < 0 or y < 0:
            return 'out-of-bounds'
        pnode, node = None, self.head
        while node.next_node is not None:
            if x < node.x:
                new_node = PositionNode(x, y, val, node)
                if node == self.head:
                    self.head = new_node
                else:
                    pnode.next_node = new_node
                return True
            elif x == node.x and y < node.y:
                new_node = PositionNode(x, y, val, node)
                if node == self.head:
                    self.head = new_node
                else:
                    pnode.next_node = new_node
                return True
            elif x == node.x and y > node.y and not(x == node.next_node.x and y == node.next_node.y):
                new_node = PositionNode(x, y, val, node.next_node)
                node.next_node = new_node
                return True
            elif x == node.x and y == node.y:
                node.val = val
                return True
            pnode = node
            node = node.next_node

        if pnode is None and node is None:
            new_node = PositionNode(x, y, val)
            self.head = new_node
        elif pnode is None and node is not None:
            if x < node.x:
                new_node = PositionNode(x, y, val, node)
                self.head = new_node
                return True
            elif x == node.x and y < node.y:
                new_node = PositionNode(x, y, val, node)
                self.head = new_node
                return True
            elif x == node.x and y > node.y:
                new_node = PositionNode(x, y, val)
                node.next_node = new_node
                return True
            elif x == node.x and y == node.y:
                node.val = val
                return True
        else:
            if x < node.x:
                new_node = PositionNode(x, y, val, node)
                if node == self.head:
                    self.head = new_node
                else:
                    pnode.next_node = new_node
                return True
            elif x == node.x and y < node.y:
                new_node = PositionNode(x, y, val, node)
                if node == self.head:
                    self.head = new_node
                else:
                    pnode.next_node = new_node
                return True
            elif x == node.x and y > node.y:
                new_node = PositionNode(x, y, val)
                node.next_node = new_node
                return True
            elif x == node.x and y == node.y:
                node.val = val
                return True


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
print(matrix.insert(10, 10, 'e'))
print(matrix.insert(3, 1, 't'))
print(matrix.insert(5, 5,'t'))
print(matrix.insert(9, 9,'eee'))
print(matrix)
