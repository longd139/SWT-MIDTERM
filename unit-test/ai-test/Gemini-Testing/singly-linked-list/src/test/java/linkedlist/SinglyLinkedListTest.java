package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new SinglyLinkedList();
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ADDFIRST()
    // ==========================================

    @Test
    public void addFirst_WhenListIsEmpty_ShouldInsertNode() {
        // Arrange & Act
        list.addFirst(10);

        // Assert
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertTrue(list.search(10));
    }

    @Test
    public void addFirst_WhenListIsNotEmpty_ShouldInsertAtBeginning() {
        // Arrange
        list.addFirst(20);

        // Act
        list.addFirst(10);

        // Assert
        assertEquals(2, list.size());
        assertTrue(list.search(10));
        // Xác minh 10 nằm ở đầu bằng cách xóa nó và kiểm tra size
        assertTrue(list.delete(10));
        assertEquals(1, list.size());
        assertTrue(list.search(20));
    }

    @Test
    public void addFirst_AfterAdding_ShouldIncreaseSize() {
        // Arrange
        int initialSize = list.size();

        // Act
        list.addFirst(10);
        list.addFirst(20);

        // Assert
        assertEquals(initialSize + 2, list.size());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ADDLAST()
    // ==========================================

    @Test
    public void addLast_WhenListIsEmpty_ShouldInsertNode() {
        // Arrange & Act
        list.addLast(10);

        // Assert
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertTrue(list.search(10));
    }

    @Test
    public void addLast_WhenListHasOneElement_ShouldInsertAtEnd() {
        // Arrange
        list.addLast(10);

        // Act
        list.addLast(20);

        // Assert
        assertEquals(2, list.size());
        assertTrue(list.search(20));
    }

    @Test
    public void addLast_WhenListHasMultipleElements_ShouldInsertAtEnd() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        list.addLast(30);

        // Assert
        assertEquals(3, list.size());
        assertTrue(list.search(30));
    }

    @Test
    public void addLast_AfterAdding_ShouldIncreaseSize() {
        // Arrange & Act
        list.addLast(5);
        list.addLast(15);

        // Assert
        assertEquals(2, list.size());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC DELETE()
    // ==========================================

    @Test
    public void delete_WhenListIsEmpty_ShouldReturnFalse() {
        // Arrange (list is empty from setUp)
        // Act
        boolean result = list.delete(10);

        // Assert
        assertFalse(result);
    }

    @Test
    public void delete_WhenValueIsAtHead_ShouldRemoveHeadAndReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.delete(10);

        // Assert
        assertTrue(result);
        assertEquals(1, list.size());
        assertFalse(list.search(10));
    }

    @Test
    public void delete_WhenValueIsInMiddle_ShouldRemoveNodeAndReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.delete(20);

        // Assert
        assertTrue(result);
        assertEquals(2, list.size());
        assertFalse(list.search(20));
    }

    @Test
    public void delete_WhenValueIsAtTail_ShouldRemoveTailAndReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.delete(30);

        // Assert
        assertTrue(result);
        assertEquals(2, list.size());
        assertFalse(list.search(30));
    }

    @Test
    public void delete_WhenValueDoesNotExist_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.delete(50);

        // Assert
        assertFalse(result);
        assertEquals(2, list.size()); // Size should remain unchanged
    }

    @Test
    public void delete_WhenListHasOnlyOneElement_ShouldMakeListEmpty() {
        // Arrange
        list.addLast(10);

        // Act
        boolean result = list.delete(10);

        // Assert
        assertTrue(result);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC SEARCH()
    // ==========================================

    @Test
    public void search_WhenValueExists_ShouldReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.search(20);

        // Assert
        assertTrue(result);
    }

    @Test
    public void search_WhenValueDoesNotExist_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.search(50);

        // Assert
        assertFalse(result);
    }

    @Test
    public void search_WhenListIsEmpty_ShouldReturnFalse() {
        // Arrange (list is empty)
        // Act
        boolean result = list.search(10);

        // Assert
        assertFalse(result);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC SIZE()
    // ==========================================

    @Test
    public void size_WhenListIsEmpty_ShouldReturnZero() {
        // Arrange & Act
        int result = list.size();

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void size_WhenListHasOneElement_ShouldReturnOne() {
        // Arrange
        list.addLast(10);

        // Act
        int result = list.size();

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void size_WhenListHasMultipleElements_ShouldReturnCorrectCount() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        int result = list.size();

        // Assert
        assertEquals(3, result);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ISEMPTY()
    // ==========================================

    @Test
    public void isEmpty_WhenNewlyCreated_ShouldReturnTrue() {
        // Arrange & Act & Assert
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty_AfterAddingElement_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);

        // Act & Assert
        assertFalse(list.isEmpty());
    }

    @Test
    public void isEmpty_AfterDeletingAllElements_ShouldReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        list.delete(10);
        list.delete(20);

        // Assert
        assertTrue(list.isEmpty());
    }
}
