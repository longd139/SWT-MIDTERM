import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    // =====================================================
    // Trạng thái khởi tạo (isEmpty, inorder, search, delete)
    // =====================================================

    @Test
    void isEmpty_NewTree_ShouldReturnTrue() {
        // Arrange (done in setUp)

        // Act & Assert
        assertTrue(bst.isEmpty());
    }

    @Test
    void isEmpty_AfterInsert_ShouldReturnFalse() {
        // Arrange
        bst.insert(50);

        // Act & Assert
        assertFalse(bst.isEmpty());
    }

    @Test
    void inorder_EmptyTree_ShouldReturnEmptyList() {
        // Arrange (done in setUp)

        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void search_EmptyTree_ShouldReturnFalse() {
        // Arrange (done in setUp)

        // Act
        boolean result = bst.search(50);

        // Assert
        assertFalse(result);
    }

    @Test
    void delete_EmptyTree_ShouldNotThrowException() {
        // Arrange (done in setUp)

        // Act & Assert
        assertDoesNotThrow(() -> bst.delete(100));
    }

    // =====================================================
    // Thêm node (insert)
    // =====================================================

    @Test
    void insert_SingleNode_ShouldCreateRoot() {
        // Arrange & Act
        bst.insert(50);

        // Assert
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(50));
        assertEquals(Collections.singletonList(50), bst.inorder());
    }

    @Test
    void insert_SmallerValue_ShouldGoLeft() {
        // Arrange
        bst.insert(50);

        // Act
        bst.insert(30);

        // Assert
        assertEquals(Arrays.asList(30, 50), bst.inorder());
    }

    @Test
    void insert_LargerValue_ShouldGoRight() {
        // Arrange
        bst.insert(50);

        // Act
        bst.insert(70);

        // Assert
        assertEquals(Arrays.asList(50, 70), bst.inorder());
    }

    @Test
    void insert_MultipleNodes_ShouldBuildCorrectTree() {
        // Arrange & Act
        bst.insert(40);
        bst.insert(20);
        bst.insert(60);
        bst.insert(10);
        bst.insert(30);
        bst.insert(50);
        bst.insert(70);

        // Assert
        assertEquals(Arrays.asList(10, 20, 30, 40, 50, 60, 70), bst.inorder());
        assertTrue(bst.search(10));
        assertTrue(bst.search(70));
        assertTrue(bst.search(30));
    }

    @Test
    void insert_DuplicateValue_ShouldBeIgnored() {
        // Arrange & Act
        bst.insert(15);
        bst.insert(15);
        bst.insert(15);

        // Assert - chỉ có một phần tử 15
        assertEquals(Arrays.asList(15), bst.inorder());
    }

    @Test
    void insert_NegativeValues_ShouldBeStoredCorrectly() {
        // Arrange & Act
        bst.insert(0);
        bst.insert(-25);
        bst.insert(-50);
        bst.insert(25);

        // Assert
        assertEquals(Arrays.asList(-50, -25, 0, 25), bst.inorder());
    }

    // =====================================================
    // Tìm kiếm (search)
    // =====================================================

    @Test
    void search_RootValue_ShouldReturnTrue() {
        // Arrange
        bst.insert(50);

        // Act
        boolean result = bst.search(50);

        // Assert
        assertTrue(result);
    }

    @Test
    void search_LeftSubtreeValue_ShouldReturnTrue() {
        // Arrange
        bst.insert(50);
        bst.insert(30);

        // Act
        boolean result = bst.search(30);

        // Assert
        assertTrue(result);
    }

    @Test
    void search_RightSubtreeValue_ShouldReturnTrue() {
        // Arrange
        bst.insert(50);
        bst.insert(70);

        // Act
        boolean result = bst.search(70);

        // Assert
        assertTrue(result);
    }

    @Test
    void search_NonExistingValue_ShouldReturnFalse() {
        // Arrange
        bst.insert(25);
        bst.insert(75);

        // Act
        boolean result = bst.search(50);

        // Assert
        assertFalse(result);
    }

    // =====================================================
    // Duyệt cây Inorder
    // =====================================================

    @Test
    void inorder_SingleNode_ShouldReturnSingleElementList() {
        // Arrange
        bst.insert(77);

        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertEquals(Collections.singletonList(77), result);
    }

    @Test
    void inorder_LeftSkewedTree_ShouldReturnSortedAscending() {
        // Arrange
        bst.insert(100);
        bst.insert(90);
        bst.insert(80);
        bst.insert(70);
        bst.insert(60);

        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertEquals(Arrays.asList(60, 70, 80, 90, 100), result);
    }

    @Test
    void inorder_RightSkewedTree_ShouldReturnSortedAscending() {
        // Arrange
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);

        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertEquals(Arrays.asList(10, 20, 30, 40, 50), result);
    }

    @Test
    void inorder_BalancedTree_ShouldReturnFullSortedSequence() {
        // Arrange
        int[] values = {45, 25, 75, 15, 35, 65, 85, 5, 95};
        for (int v : values) {
            bst.insert(v);
        }

        // Act
        List<Integer> result = bst.inorder();

        // Assert
        assertEquals(Arrays.asList(5, 15, 25, 35, 45, 65, 75, 85, 95), result);
    }

    // =====================================================
    // Xóa node (delete)
    // =====================================================

    @Test
    void delete_LeafNode_ShouldRemoveCorrectly() {
        // Arrange
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);

        // Act
        bst.delete(20); // node lá

        // Assert
        assertFalse(bst.search(20));
        assertTrue(bst.search(30));
        assertTrue(bst.search(40));
        assertEquals(Arrays.asList(30, 40), bst.inorder());
    }

    @Test
    void delete_NodeWithLeftChildOnly_ShouldReplaceWithChild() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(20); // 30 có con trái là 20

        // Act
        bst.delete(30);

        // Assert
        assertFalse(bst.search(30));
        assertTrue(bst.search(20));
        assertTrue(bst.search(50));
        assertEquals(Arrays.asList(20, 50), bst.inorder());
    }

    @Test
    void delete_NodeWithRightChildOnly_ShouldReplaceWithChild() {
        // Arrange
        bst.insert(50);
        bst.insert(30);
        bst.insert(40); // 30 có con phải là 40

        // Act
        bst.delete(30);

        // Assert
        assertFalse(bst.search(30));
        assertTrue(bst.search(40));
        assertEquals(Arrays.asList(40, 50), bst.inorder());
    }

    @Test
    void delete_NodeWithTwoChildren_ShouldReplaceWithSuccessor() {
        // Arrange
        bst.insert(60);
        bst.insert(40);
        bst.insert(100);
        bst.insert(30);
        bst.insert(50);
        bst.insert(80);
        bst.insert(120);

        // Act
        bst.delete(100);

        // Assert
        assertFalse(bst.search(100));
        // Successor của 100 là 120 (nhỏ nhất cây con phải)
        assertEquals(Arrays.asList(30, 40, 50, 60, 80, 120), bst.inorder());
    }

    @Test
    void delete_RootNode_ShouldReorganizeTree() {
        // Arrange
        bst.insert(42);
        bst.insert(21);
        bst.insert(63);
        bst.insert(10);
        bst.insert(35);

        // Act
        bst.delete(42);

        // Assert
        assertFalse(bst.search(42));
        assertEquals(4, bst.inorder().size());
        assertTrue(bst.search(21));
        assertTrue(bst.search(63));
    }

    @Test
    void delete_NonExistingValue_ShouldNotChangeTree() {
        // Arrange
        bst.insert(15);
        bst.insert(5);
        bst.insert(25);

        List<Integer> before = bst.inorder();

        // Act
        bst.delete(999);

        // Assert
        assertEquals(before, bst.inorder());
    }

    // =====================================================
    // Trường hợp biên
    // =====================================================

    @Test
    void insert_MinAndMaxInteger_ShouldHandleCorrectly() {
        // Arrange & Act
        bst.insert(Integer.MAX_VALUE);
        bst.insert(0);
        bst.insert(Integer.MIN_VALUE);

        // Assert
        assertTrue(bst.search(Integer.MIN_VALUE));
        assertTrue(bst.search(0));
        assertTrue(bst.search(Integer.MAX_VALUE));
        assertEquals(3, bst.inorder().size());
    }

    @Test
    void delete_AllNodesOneByOne_ShouldBecomeEmpty() {
        // Arrange
        bst.insert(33);
        bst.insert(11);
        bst.insert(55);

        // Act
        bst.delete(11);
        bst.delete(55);
        bst.delete(33);

        // Assert
        assertTrue(bst.isEmpty());
        assertEquals(Collections.emptyList(), bst.inorder());
    }

    @Test
    void interleavedInsertAndDelete_ShouldStayConsistent() {
        // Arrange & Act
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.delete(3);
        bst.insert(1);
        bst.insert(9);
        bst.delete(7);

        // Assert
        assertEquals(Arrays.asList(1, 5, 9), bst.inorder());
    }

    @Test
    void insert_LargeNumberOfNodes_ShouldMaintainBSTProperty() {
        // Arrange & Act - Thêm 50 node
        for (int i = 1; i <= 50; i++) {
            bst.insert(i);
        }

        // Assert
        List<Integer> result = bst.inorder();
        assertEquals(50, result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(i + 1, result.get(i));
        }
    }
}
