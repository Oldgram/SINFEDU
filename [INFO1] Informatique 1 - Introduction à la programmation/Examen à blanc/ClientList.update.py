if name is not None and self.last is not None:
    current_node = self.last
    if current_node.data.getUserName() == name:
        current_node.data.setPin(pin)
        return None
    while current_node.link is not None:
        current_node = current_node.link
        if current_node.data.getUserName() == name:
            current_node.data.setPin(pin)
            return None
    new_node = ClientList.Node(Client(name, pin), self.last)
    new_node.link = self.last
    self.last = new_node
elif self.last is None:
    new_node = ClientList.Node(Client(name, pin), self.last)
    self.last = new_node