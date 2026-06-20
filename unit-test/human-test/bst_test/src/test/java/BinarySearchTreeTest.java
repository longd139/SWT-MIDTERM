import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    // Test insert
    // 1. No input
    @Test
    void testInsert_IntoEmptyTree_ShouldCreateRoot() {
        bst.insert(50);
        
        assertNotNull(bst.root, "Error: Root must be created after the first insertion.");
        assertEquals(50, bst.root.key, "Error: The root's value must be 50.");
    }
    // 2. Normal input
    @Test
    void testInsert_NormalValues_ShouldInsertSuccessfully() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Assert that the values are correctly placed in the tree
        assertTrue(bst.search(50), "Error: Should find the inserted value 50.");
        assertTrue(bst.search(30), "Error: Should find the inserted value 30.");
        assertTrue(bst.search(70), "Error: Should find the inserted value 70.");
    }
    // 3. Wrong input
    @Test
    void testInsert_DuplicateValue_ShouldBeIgnored() {
        bst.insert(50);
        bst.insert(30);
        
        // Intentionally inserting a duplicate value
        bst.insert(50);

        // Run inorder traversal to get the list of elements.
        // If the code is correct, the duplicate is ignored, and the size remains 2.
        assertEquals(2, bst.inorder().size(), "Error: Tree should only have 2 elements; duplicate value must be ignored.");
    }  


    // Test search
    // 1. No input
    @Test
    void testSearch_EmptyTree_ShouldReturnFalse() {
        // Act: Try to search for any number before inserting anything
        boolean result = bst.search(50);

        // Assert: It should safely return false without throwing a NullPointerException
        assertFalse(result, "Error: Searching in an empty tree must return false.");
    }

    // 2. Normal input
    @Test
    void testSearch_ExistingKey_ShouldReturnTrue() {
        // Arrange: Insert some values into the tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act & Assert: Search for these exact values
        assertTrue(bst.search(50), "Error: Should find the root node (50).");
        assertTrue(bst.search(30), "Error: Should find the left child (30).");
        assertTrue(bst.search(70), "Error: Should find the right child (70).");
    }

    // 3. Wrong input
    @Test
    void testSearch_NonExistingKey_ShouldReturnFalse() {
        // Arrange: Insert some initial values
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act & Assert: Try to search for values that were never inserted
        assertFalse(bst.search(100), "Error: Should return false for a non-existing positive number (100).");
        assertFalse(bst.search(10), "Error: Should return false for a non-existing positive number (10).");
        assertFalse(bst.search(-5), "Error: Should return false for a non-existing negative number (-5).");
    }


    // Test delete
    //1. No input
    @Test
    void testDelete_EmptyTree_ShouldNotCrash() {
        // Act & Assert: Calling delete on an empty tree must safely return without NullPointerException
        assertDoesNotThrow(() -> bst.delete(50), "Error: Deleting from an empty tree threw an exception.");
        assertTrue(bst.isEmpty(), "Error: The tree should still be empty.");
    }

    // 2. Normal input (case 1 - 0 children)
    @Test
    void testDelete_ExistingKey_LeafNode_ShouldRemoveCorrectly() {
        // Arrange: Build tree
        bst.insert(50);
        bst.insert(30); // Leaf node
        bst.insert(70); // Leaf node

        // Act: Delete leaf node 30
        bst.delete(30);

        // Assert: 30 is gone, but 50 and 70 remain
        assertFalse(bst.search(30), "Error: Leaf node 30 should be deleted.");
        assertTrue(bst.search(50), "Error: Root node 50 should remain.");
        assertEquals(List.of(50, 70), bst.inorder(), "Error: Remaining tree structure is incorrect.");
    }

    // 2. Normal input (case 2 - 1 children)
    @Test
    void testDelete_ExistingKey_OneChild_ShouldReplaceWithChild() {
        // Arrange: Build tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(20); // 30 now has one left child (20)

        // Act: Delete node 30
        bst.delete(30);

        // Assert: 30 is deleted, and its child 20 connects directly to 50
        assertFalse(bst.search(30), "Error: Node 30 should be deleted.");
        assertTrue(bst.search(20), "Error: Child node 20 must not be lost.");
        assertEquals(List.of(20, 50), bst.inorder(), "Error: Tree structure is incorrect after deleting a node with 1 child.");
    }

    // 2. Normal input (case 3 - 2 children)
    @Test
    void testDelete_ExistingKey_TwoChildren_ShouldReplaceWithSuccessor() {
        // Arrange: Build tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80); // 70 now has two children (60 and 80)

        // Act: Delete node 70
        bst.delete(70);

        // Assert: 70 is deleted, replaced by in-order successor (80)
        assertFalse(bst.search(70), "Error: Node 70 should be deleted.");
        assertEquals(List.of(30, 50, 60, 80), bst.inorder(), "Error: Tree structure failed to update properly using the in-order successor.");
    }

    // 3. Wrong input
    @Test
    void testDelete_NonExistingKey_ShouldNotModifyTree() {
        // Arrange: Build tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Act: Try to delete 100, which is not in the tree
        bst.delete(100);

        // Assert: The tree remains exactly the same
        assertEquals(List.of(30, 50, 70), bst.inorder(), "Error: Deleting a non-existent key should not modify the tree.");
    }

    // tets inorder
    // 1. No input
    @Test
    void testInorder_EmptyTree_ShouldReturnEmptyList() {
        // Act: Call inorder on a newly created tree
        List<Integer> result = bst.inorder();

        // Assert: The result should be a valid, empty List, NOT a null object
        assertNotNull(result, "Error: The returned list should not be null, even if the tree is empty.");
        assertTrue(result.isEmpty(), "Error: An empty tree must return an empty list.");
    }

    // 2. Normal input
    @Test
    void testInorder_NormalTree_ShouldReturnSortedList() {
        // Arrange: Build a standard tree
        //       50
        //      /  \
        //    30    70
        //   /  \
        // 20    40
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        // Act & Assert: The returned list MUST be sorted in strictly ascending order (Left-Root-Right)
        List<Integer> expected = List.of(20, 30, 40, 50, 70);
        assertEquals(expected, bst.inorder(), "Error: The normal tree traversal did not return a sorted list.");
    }

    // 3. Wrong input
    @Test
    void testInorder_SkewedTree_ShouldStillReturnSortedList() {
        // Arrange: Insert elements in strictly increasing order
        // This creates a Right-Skewed Tree (no left branches at all)
        // 10
        //   \
        //    20
        //      \
        //       30
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);

        // Act & Assert: The recursive logic should not break and must still return sorted values
        List<Integer> expectedRightSkewed = List.of(10, 20, 30);
        assertEquals(expectedRightSkewed, bst.inorder(), "Error: Traversal failed on a Right-Skewed tree.");

        // Extra check for a Left-Skewed Tree
        BinarySearchTree leftSkewedTree = new BinarySearchTree();
        leftSkewedTree.insert(30);
        leftSkewedTree.insert(20);
        leftSkewedTree.insert(10);
        
        List<Integer> expectedLeftSkewed = List.of(10, 20, 30);
        assertEquals(expectedLeftSkewed, leftSkewedTree.inorder(), "Error: Traversal failed on a Left-Skewed tree.");
    }
}
