package linkedlist;

/**
 * Demonstrates the usage of the {@link SinglyLinkedList} class.
 *
 * <p>The program performs a sequence of operations — add, delete,
 * search, count, and display — to verify the behavior of each
 * method in the {@code SinglyLinkedList} class.</p>
 */
public class Main {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // 1. Check empty list
        System.out.println("=== Check empty list ===");
        System.out.println("Empty list? " + list.isEmpty());
        list.display();
        System.out.println();

        // 2. Add elements to front
        System.out.println("=== Add element to front ===");
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.display();
        System.out.println("Number of elements: " + list.size());
        System.out.println();

        // 3. Add elements to end
        System.out.println("=== Add element to end ===");
        list.addLast(5);
        list.addLast(1);
        list.display();
        System.out.println("Number of elements: " + list.size());
        System.out.println();

        // 4. Search elements
        System.out.println("=== Search element ===");
        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 100: " + list.search(100));
        System.out.println();

        // 5. Delete elements
        System.out.println("=== Delete element ===");
        System.out.println("Delete 30 (front of list): " + list.delete(30));
        list.display();
        System.out.println("Delete 5 (middle of list): " + list.delete(5));
        list.display();
        System.out.println("Delete 1 (end of list): " + list.delete(1));
        list.display();
        System.out.println("Delete 999 (not found): " + list.delete(999));
        list.display();
        System.out.println();

        // 6. Check final state
        System.out.println("=== Final state ===");
        System.out.println("Empty list? " + list.isEmpty());
        System.out.println("Number of elements: " + list.size());
        list.display();
    }
}
