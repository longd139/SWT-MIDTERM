# Prompt
Bạn là một kỹ sư kiểm thử phần mềm. Hãy viết unit test cho đoạn code sau bằng JUnit 5. Yêu cầu: 1. Sử dụng cấu trúc Arrange–Act–Assert. 2. Bao phủ trường hợp bình thường, trường hợp biên và trường hợp lỗi. 3. Đặt tên test case rõ ràng. 4. Không thay đổi logic của mã nguồn gốc. 5. Giải thích ngắn gọn các nhóm test đã viết. Đây là mã nguồn cần test:package linkedlist;

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

# src code unittest
```java
package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @BeforeEach
    void setUp() {
        // Arrange
        list = new SinglyLinkedList();
    }

    // =====================================================
    // Constructor & isEmpty()
    // =====================================================

    @Test
    void testIsEmpty_WhenListIsNew_ShouldReturnTrue() {
        // Act
        boolean result = list.isEmpty();

        // Assert
        assertTrue(result);
    }

    @Test
    void testSize_WhenListIsNew_ShouldReturnZero() {
        // Act
        int result = list.size();

        // Assert
        assertEquals(0, result);
    }

    // =====================================================
    // addFirst()
    // =====================================================

    @Test
    void testAddFirst_WhenAddingOneElement_ShouldIncreaseSize() {
        // Arrange
        list.addFirst(10);

        // Act
        int result = list.size();

        // Assert
        assertEquals(1, result);
    }

    @Test
    void testAddFirst_WhenAddingElement_ShouldBeSearchable() {
        // Arrange
        list.addFirst(10);

        // Act
        boolean result = list.search(10);

        // Assert
        assertTrue(result);
    }

    // =====================================================
    // addLast()
    // =====================================================

    @Test
    void testAddLast_OnEmptyList_ShouldAddElement() {
        // Arrange
        list.addLast(5);

        // Act
        boolean result = list.search(5);

        // Assert
        assertTrue(result);
    }

    @Test
    void testAddLast_WhenAddingMultipleElements_ShouldIncreaseSizeCorrectly() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        int result = list.size();

        // Assert
        assertEquals(3, result);
    }

    // =====================================================
    // search()
    // =====================================================

    @Test
    void testSearch_WhenElementExists_ShouldReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.search(20);

        // Assert
        assertTrue(result);
    }

    @Test
    void testSearch_WhenElementDoesNotExist_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.search(99);

        // Assert
        assertFalse(result);
    }

    @Test
    void testSearch_OnEmptyList_ShouldReturnFalse() {
        // Act
        boolean result = list.search(1);

        // Assert
        assertFalse(result);
    }

    // =====================================================
    // delete()
    // =====================================================

    @Test
    void testDelete_OnEmptyList_ShouldReturnFalse() {
        // Act
        boolean result = list.delete(10);

        // Assert
        assertFalse(result);
    }

    @Test
    void testDelete_WhenDeletingHeadNode_ShouldReturnTrueAndRemoveElement() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.delete(10);

        // Assert
        assertTrue(result);
        assertFalse(list.search(10));
        assertEquals(1, list.size());
    }

    @Test
    void testDelete_WhenDeletingMiddleNode_ShouldReturnTrueAndRemoveElement() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.delete(20);

        // Assert
        assertTrue(result);
        assertFalse(list.search(20));
        assertEquals(2, list.size());
    }

    @Test
    void testDelete_WhenDeletingLastNode_ShouldReturnTrueAndRemoveElement() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.delete(20);

        // Assert
        assertTrue(result);
        assertFalse(list.search(20));
        assertEquals(1, list.size());
    }

    @Test
    void testDelete_WhenElementDoesNotExist_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.delete(99);

        // Assert
        assertFalse(result);
        assertEquals(2, list.size());
    }

    // =====================================================
    // Boundary Cases
    // =====================================================

    @Test
    void testAddNegativeValue_ShouldStoreSuccessfully() {
        // Arrange
        list.addLast(-10);

        // Act
        boolean result = list.search(-10);

        // Assert
        assertTrue(result);
    }

    @Test
    void testAddDuplicateValues_ShouldAllowDuplicates() {
        // Arrange
        list.addLast(10);
        list.addLast(10);

        // Act
        int result = list.size();

        // Assert
        assertEquals(2, result);
        assertTrue(list.search(10));
    }

    @Test
    void testDelete_OnlyElementInList_ShouldMakeListEmpty() {
        // Arrange
        list.addLast(100);

        // Act
        boolean deleted = list.delete(100);

        // Assert
        assertTrue(deleted);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
}
```
