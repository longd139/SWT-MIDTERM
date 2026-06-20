package linkedlist;

/**
 * Represents a single node in a Singly Linked List.
 * Each node stores an integer value and a reference to the next node.
 */
public class Node {

    /** The integer data value stored in this node. */
    int data;

    /** Reference to the next node in the list. */
    Node next;

    /**
     * Constructs a new node with the given data value.
     * The {@code next} reference defaults to {@code null}.
     *
     * @param data the integer value to store in this node
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
