import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree();
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ISEMPTY()
    // ==========================================

    @Test
    public void isEmpty_WhenTreeIsNewlyCreated_ShouldReturnTrue() {
        // Arrange (done in setUp)
        // Act & Assert
        assertTrue(bst.isEmpty());
    }

    @Test
    public void isEmpty_AfterInsertingNode_ShouldReturnFalse() {
        // Arrange
        bst.insert(50);

        // Act & Assert
        assertFalse(bst.isEmpty());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC INSERT()
    // ==========================================

    @Test
    public void insert_WhenTreeIsEmpty_ShouldCreateRootNode() {
        // Arrange & Act
        bst.insert(50);

        // Assert
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(50));
        assertEquals(Collections.singletonList(50), bst.inorder());
    }

    @Test
    public void insert_WhenKeyIsSmaller_ShouldInsertLeft() {
        // Arrange
        bst.insert(50);

        // Act
        bst.insert(30);

        // Assert
        assertEquals(Arrays.asList(30, 50), bst.inorder());
    }

    @Test
    public void insert_WhenKeyIsLarger_ShouldInsertRight() {
        // Arrange
        bst.insert(50);

        // Act
        bst.insert(70);

        // Assert
        assertEquals(Arrays.asList(50, 70), bst.inorder());
    }

    @Test
    public void insert_MultipleNodes_ShouldBuildCorrectTree() {
        // Arrange & Act
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        // Assert
        assertEquals(Arrays.asList(20, 30, 40, 50, 70), bst.inorder());
    }

    @Test
    public void insert_WhenKeyIsDuplicate_ShouldIgnoreDuplicate() {
        // Arrange
        bst.insert(50);
        bst.insert(30);

        // Act
        bst.insert(50); // Duplicate value

        // Assert
        assertEquals(Arrays.asList(30, 50), bst.inorder());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC SEARCH()
    // ==========================================

    @Test
    public void search_WhenKeyIsRoot_ShouldReturnTrue() {
        // Arrange
        bst.insert(50);

        // Act
        boolean result = bst.search(50);

        // Assert
        assertTrue(result);
    }

    @Test
    public void search_WhenKeyIsInLeftSubtree_ShouldReturnTrue() {
        // Arrange
        bst.insert(50);
        bst.insert(30);

        // Act
        boolean result = bst.search(30);

        // Assert
        assertTrue(result);
    }

    @Test
    public void search_WhenKeyIsInRightSubtree_ShouldReturnTrue() {
        // Arrange
        bst.insert(50);
        bst.insert(70);

        // Act
        boolean result = bst.search(70);

        // Assert
        assertTrue(result);
    }

    @Test
    public void search_WhenKeyDoesNotExist_ShouldReturnFalse() {
        // Arrange
        bst.insert(50);
        bst.insert(30);

        // Act
        boolean result = bst.search(90);

        // Assert
        assertFalse(result);
    }

    @Test
    public void search_WhenTreeIsEmpty_ShouldReturnFalse() {
        // Arrange (Tree is empty)
        // Act
        boolean result = bst.search(50);

        // Assert
        assertFalse(result);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC DELETE()
    // ==========================================

    @Test
    public void delete_WhenTreeIsEmpty_ShouldDoNothing() {
        // Arrange (Tree is empty)
        // Act
        bst.delete(50);

        // Assert
        assertTrue(bst.isEmpty());
    }

    @Test
    public void delete_WhenNodeIsLeaf_ShouldRemoveNode() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act
        bst.delete(30); // 30 is a leaf node

        // Assert
        assertEquals(Arrays.asList(50, 70), bst.inorder());
        assertFalse(bst.search(30));
    }

    @Test
    public void delete_WhenNodeHasOnlyLeftChild_ShouldReplaceWithLeftChild() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(20); // 30 now has only a left child (20)

        // Act
        bst.delete(30);

        // Assert
        assertEquals(Arrays.asList(20, 50), bst.inorder());
    }

    @Test
    public void delete_WhenNodeHasOnlyRightChild_ShouldReplaceWithRightChild() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(40); // 30 now has only a right child (40)

        // Act
        bst.delete(30);

        // Assert
        assertEquals(Arrays.asList(40, 50), bst.inorder());
    }

    @Test
    public void delete_WhenNodeHasTwoChildren_ShouldReplaceWithInorderSuccessor() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40); // 30 has two children (20 and 40)

        // Act
        bst.delete(30);

        // Assert
        // Inorder successor of 30 is 40. 40 replaces 30.
        assertEquals(Arrays.asList(20, 40, 50), bst.inorder());
    }

    @Test
    public void delete_WhenNodeIsRoot_ShouldUpdateRoot() {
        // Arrange
        bst.insert(50); // Root
        bst.insert(30);
        bst.insert(70);

        // Act
        bst.delete(50);

        // Assert
        // Successor of 50 is 70.
        assertEquals(Arrays.asList(30, 70), bst.inorder());
        assertFalse(bst.search(50));
    }

    @Test
    public void delete_WhenKeyDoesNotExist_ShouldDoNothing() {
        // Arrange
        bst.insert(50);
        bst.insert(30);

        // Act
        bst.delete(90); // 90 is not in the tree

        // Assert
        assertEquals(Arrays.asList(30, 50), bst.inorder());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC INORDER()
    // ==========================================

    @Test
    public void inorder_WhenTreeIsEmpty_ShouldReturnEmptyList() {
        // Arrange (Tree is empty)
        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void inorder_WhenTreeHasOneNode_ShouldReturnListWithOneElement() {
        // Arrange
        bst.insert(50);

        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertEquals(Collections.singletonList(50), result);
    }

    @Test
    public void inorder_WhenTreeHasMultipleNodes_ShouldReturnSortedList() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertEquals(Arrays.asList(20, 30, 40, 50, 60, 70, 80), result);
    }
}
