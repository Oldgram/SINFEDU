import java.util.*;


/**
 * Question:
 *
 * You are asked to clean a increasing sorted linked List (see the TODO below)
 * Cleaning the linkedList means keeping only one occurrence of each value.
 *
 * For instance cleaning: 3,3,3,4,5,5,6,6,6,7,9,9,9,9,10,10
 * Gives: 3,4,5,6,7,9,10
 *
 * Your algorithm should execute in Theta(n)
 * where n are the number of elements in the original list
 *
 */
public class CleanLinkedList {

    Node first = null;
    Node last = null;

    public void add(int v) {
        if (first == null) {
            first = new Node(v, null);
            last = first;
        } else {
            Node node = first;
            while(v >= node.v) {
                if (node.next != null) {
                    node = node.next;
                } else {
                    node.next = new Node(v, null);
                    this.last = node.next;
                    break;
                }
            }

        }
    }

    public void add(int ... values) {
        for (int v: values) {
            add(v);
        }
    }


    /**
     * Given the increasingly sorted list, it removes the duplicates
     * @return an increasingly sorted list containing the same set
     *         of elements as list but without duplicates.
     */
    public CleanLinkedList clean() {
        if (this.first == null || this.first == this.last) { return this; }

        List existing = new ArrayList();
        Node node = first, pNode = null;

        existing.add(node.v);
        pNode = node; node = node.next;
        while(node.next != null) {
            if (existing.contains(node.v)) {
                node = node.next;
                pNode.next = node;
            } else {
                existing.add(node.v);
                pNode = node; node = node.next;
            }
        }

        if (this.last == node) {
            if (existing.contains(node.v)) {
                pNode.next = null;
                this.last = pNode;
            }
        }

        return this;
    }

    class Node {
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }


}

