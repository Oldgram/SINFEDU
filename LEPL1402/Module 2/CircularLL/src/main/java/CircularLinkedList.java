import org.w3c.dom.Node;

class ListNode<Item> {

    private Item item;
    private ListNode<Item> next;

    public ListNode(Item item){
        this.item = item;
        this.next = null;
    }

    public ListNode(Item item, ListNode<Item> next) {
        this.item = item;
        this.next = next;
    }

    /**
     * Return the item of the node
     *
     * @return The item contained in the node
     */
    public Item getItem() {
        return item;
    }

    /**
     * Get the next node in the list
     *
     * @return the next node in the list
     */
    public ListNode<Item> getNext() {
        return this.next;
    }

    /**
     * Set the followers of this node in the list
     *
     * @param next The node to put after this one
     */
    public void setNext(ListNode<Item> next) {
        this.next = next;
    }
}

public class CircularLinkedList<Item> {

    private int size;
    private ListNode<Item> first;
    private ListNode<Item> last;

    public CircularLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Add an element to the list
     *
     * @param item The element to add at the end of the list
     */
    public void enqueue(Item item) {
        ListNode<Item> Node = new ListNode<>(item);
        if (first == null) {
            Node.setNext(Node);
            first = Node;
        } else {
            last.setNext(Node);
            Node.setNext(first);
        }
        last = Node;
        size += 1;
    }

    /**
     * Remove an element of the list
     *
     * @param index The index of the element to remove
     * @throws IndexOutOfBoundsException if the index is
     *         less than 0 or greater to the size
     *         of the list
     */
    public Item remove(int index) {
        if (0 > index || index > size || size == 0) {
            throw new IndexOutOfBoundsException("The index provided is less than 0 or greater to the size of the list");
        } else if (size == 1) {
            ListNode<Item> item = first;
            first = null;
            last = null;
            size = 0;
            return item.getItem();
        }
        ListNode<Item> pNode = last; ListNode<Item> cNode = first;
        for (int i = 0; i < index; i++) {
            pNode = cNode;
            cNode = pNode.getNext();
        }
        if (cNode == first) {
            first = cNode.getNext();
        } else if (cNode == last) {
            last = pNode;
        }
        pNode.setNext(cNode.getNext());
        size -= 1;
        return cNode.getItem();
    }

    /**
     * The size of the list
     *
     * @return The size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Is the list empty
     *
     * @return true if there is no element in the list
     *         and false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the first element of the list
     *
     * @return The first ListNode in the list
     */
    public ListNode<Item> getFirst() {
        return this.first;
    }

    /**
     * Get the last element of the list
     *
     * @return The last ListNode in the list
     */
    public ListNode<Item> getLast() {
        return this.last;
    }

}
