# Prompt

Bạn là một kỹ sư kiểm thử phần mềm. Hãy viết unit test cho đoạn code sau bằng JUnit 5. Yêu cầu: 1. Sử dụng cấu trúc Arrange–Act–Assert. 2. Bao phủ trường hợp bình thường, trường hợp biên và trường hợp lỗi. 3. Đặt tên test case rõ ràng. 4. Không thay đổi logic của mã nguồn gốc. 5. Giải thích ngắn gọn các nhóm test đã viết. Đây là mã nguồn cần test :
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    
    Node root;

    // Khởi tạo cây rỗng
    public BinarySearchTree() {
        root = null;
    }

    // Kiểm tra cây rỗng
    public boolean isEmpty() {
        return root == null;
    }

    // Thêm một node mới
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // Lưu ý: Các giá trị trùng lặp sẽ bị bỏ qua, không được thêm vào
        return root;
    }

    // Tìm kiếm một giá trị
    public boolean search(int key) {
        return searchRec(root, key) != null;
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    // Xóa một node
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Trường hợp node cần xóa có 1 con hoặc không có con
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Trường hợp node cần xóa có 2 con:
            // Tìm node kế nhiệm (nhỏ nhất ở cây con phải)
            root.key = minValue(root.right);

            // Xóa node kế nhiệm
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Duyệt cây theo thứ tự In-order (Trái - Gốc - Phải)
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }

    private void inorderRec(Node root, List<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.key);
            inorderRec(root.right, result);
        }
    }
}

public class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

# src code unittest
```java
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
```
