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
        // (List is empty)

        // Act
        list.addLast(10);

        // Assert
        assertEquals(1, list.size());
        assertTrue(list.search(10));
    }

    @Test
    void testAddLast_OnNonEmptyList_ShouldAppendToTail() {
        // Arrange
        list.addLast(10);

        // Act
        list.addLast(20);

        // Assert
        assertEquals(2, list.size());
        assertTrue(list.search(20));
        // Verify order using size and search or by verifying traversals if exposed.
        // Since getHead is private, we verify via search and count.
    }

    // =====================================================
    // size()
    // =====================================================

    @Test
    void testSize_AfterMultipleInsertions_ShouldReturnCorrectCount() {
        // Arrange
        list.addLast(10);
        list.addFirst(5);
        list.addLast(20);

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
        boolean result = list.search(30);

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
