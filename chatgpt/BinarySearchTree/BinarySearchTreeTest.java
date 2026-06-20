import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        // Arrange
        bst = new BinarySearchTree();
    }

    // =====================================================
    // Constructor & isEmpty()
    // =====================================================

    @Test
    void testIsEmpty_WhenTreeIsNew_ShouldReturnTrue() {
        // Act
        boolean result = bst.isEmpty();

        // Assert
        assertTrue(result);
    }

    @Test
    void testInorder_WhenTreeIsEmpty_ShouldReturnEmptyList() {
        // Act
        var result = bst.inorder();

        // Assert
        assertEquals(Collections.emptyList(), result);
    }

    // =====================================================
    // insert() & search()
    // =====================================================

    @Test
    void testInsert_SingleNode_ShouldBeSearchable() {
        // Arrange
        bst.insert(50);

        // Act
        boolean result = bst.search(50);

        // Assert
        assertTrue(result);
    }

    @Test
    void testSearch_ExistingValue_ShouldReturnTrue() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act
        boolean result = bst.search(30);

        // Assert
        assertTrue(result);
    }

    @Test
    void testSearch_NonExistingValue_ShouldReturnFalse() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act
        boolean result = bst.search(99);

        // Assert
        assertFalse(result);
    }

    @Test
    void testInsert_DuplicateValue_ShouldBeIgnored() {
        // Arrange
        bst.insert(50);
        bst.insert(50);

        // Act
        var result = bst.inorder();

        // Assert
        assertEquals(Arrays.asList(50), result);
    }

    // =====================================================
    // inorder()
    // =====================================================

    @Test
    void testInorder_ShouldReturnSortedSequence() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Act
        var result = bst.inorder();

        // Assert
        assertEquals(
                Arrays.asList(20, 30, 40, 50, 60, 70, 80),
                result
        );
    }

    // =====================================================
    // delete() - leaf node
    // =====================================================

    @Test
    void testDelete_LeafNode_ShouldRemoveNode() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act
        bst.delete(30);

        // Assert
        assertFalse(bst.search(30));
        assertEquals(Arrays.asList(50, 70), bst.inorder());
    }

    // =====================================================
    // delete() - node with one child
    // =====================================================

    @Test
    void testDelete_NodeWithOneChild_ShouldRemoveNodeCorrectly() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);

        // Act
        bst.delete(30);

        // Assert
        assertFalse(bst.search(30));
        assertEquals(Arrays.asList(20, 50), bst.inorder());
    }

    // =====================================================
    // delete() - node with two children
    // =====================================================

    @Test
    void testDelete_NodeWithTwoChildren_ShouldReplaceWithSuccessor() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Act
        bst.delete(70);

        // Assert
        assertFalse(bst.search(70));
        assertEquals(
                Arrays.asList(30, 50, 60, 80),
                bst.inorder()
        );
    }

    // =====================================================
    // delete() root
    // =====================================================

    @Test
    void testDelete_RootNode_ShouldUpdateTreeCorrectly() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act
        bst.delete(50);

        // Assert
        assertFalse(bst.search(50));
        assertEquals(Arrays.asList(30, 70), bst.inorder());
    }

    // =====================================================
    // Boundary & Error Cases
    // =====================================================

    @Test
    void testDelete_NonExistingValue_ShouldNotChangeTree() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act
        bst.delete(999);

        // Assert
        assertEquals(
                Arrays.asList(30, 50, 70),
                bst.inorder()
        );
    }

    @Test
    void testDelete_OnEmptyTree_ShouldNotThrowException() {
        // Act & Assert
        assertDoesNotThrow(() -> bst.delete(10));
    }

    @Test
    void testSearch_OnEmptyTree_ShouldReturnFalse() {
        // Act
        boolean result = bst.search(10);

        // Assert
        assertFalse(result);
    }

    @Test
    void testInsert_NegativeValues_ShouldBeStoredCorrectly() {
        // Arrange
        bst.insert(-10);
        bst.insert(-20);
        bst.insert(-5);

        // Act
        var result = bst.inorder();

        // Assert
        assertEquals(
                Arrays.asList(-20, -10, -5),
                result
        );
    }
}
