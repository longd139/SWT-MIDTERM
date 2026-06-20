package linkedlist;

/**
 * Implements a Singly Linked List with basic operations:
 * add, delete, search, count, check empty, and display.
 *
 * <p>The list stores integer ({@code int}) values for each element.</p>
 */
public class SinglyLinkedList {

    /** The first node of the list. */
    private Node head;

    /**
     * Constructs an empty linked list.
     * The {@code head} is initialized to {@code null}.
     */
    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     * Adds an element to the front of the list.
     * Creates a new node and sets it as the current head.
     *
     * @param data the value to add at the front of the list
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Adds an element to the end of the list.
     * Traverses to the last node, then links its {@code next} reference
     * to the new node. If the list is empty, the new node becomes the head.
     *
     * @param data the value to add at the end of the list
     */
    public void addLast(int data) {
        Node newNode = new Node(data);

        // Empty list case
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Deletes the first occurrence of an element with the given value.
     * If the element is at the head, the head reference is updated.
     *
     * @param data the value to delete from the list
     * @return {@code true} if the element was found and deleted,
     *         {@code false} if the element was not found
     */
    public boolean delete(int data) {
        // Empty list case
        if (head == null) {
            return false;
        }

        // Delete head element
        if (head.data == data) {
            head = head.next;
            return true;
        }

        // Traverse to find the element to delete
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        // Element not found
        return false;
    }

    /**
     * Searches for an element with the given value in the list.
     *
     * @param data the value to search for
     * @return {@code true} if the value is found, {@code false} otherwise
     */
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Counts the number of elements currently in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return {@code true} if the list is empty ({@code head == null}),
     *         {@code false} if it contains elements
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Prints the entire list to the console in the format:
     * {@code data1 -> data2 -> ... -> dataN -> null}
     */
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
