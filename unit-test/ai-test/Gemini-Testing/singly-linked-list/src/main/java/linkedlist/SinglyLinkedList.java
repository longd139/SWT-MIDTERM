package linkedlist;

public class SinglyLinkedList {

    private Node head = null;

    public SinglyLinkedList() {
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current;

            for (current = this.head; current.next != null; current = current.next) {
            }

            current.next = newNode;
        }
    }

    public boolean delete(int data) {
        if (this.head == null) {
            return false;

        } else if (this.head.data == data) {
            this.head = this.head.next;
            return true;

        } else {

            for (Node current = this.head; current.next != null; current = current.next) {

                if (current.next.data == data) {
                    current.next = current.next.next;
                    return true;
                }
            }

            return false;
        }
    }

    public boolean search(int data) {

        for (Node current = this.head; current != null; current = current.next) {

            if (current.data == data) {
                return true;
            }
        }

        return false;
    }

    public int size() {

        int count = 0;

        for (Node current = this.head; current != null; current = current.next) {
            ++count;
        }

        return count;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void display() {

        for (Node current = this.head; current != null; current = current.next) {
            System.out.print(current.data + " -> ");
        }

        System.out.println("null");
    }
}
