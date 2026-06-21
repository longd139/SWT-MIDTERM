# Prompt

Bạn là một kỹ sư kiểm thử phần mềm.  
Hãy viết unit test cho đoạn code sau bằng JUnit 5.

Yêu cầu:
1. Sử dụng cấu trúc Arrange–Act–Assert.
2. Bao phủ trường hợp bình thường, trường hợp biên và trường hợp lỗi.
3. Đặt tên test case rõ ràng.
4. Không thay đổi logic của mã nguồn gốc.
5. Giải thích ngắn gọn các nhóm test đã viết.

Đây là mã nguồn cần test:

```java
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
        // Các giá trị trùng lặp sẽ bị bỏ qua
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
            // Node có 0 hoặc 1 con
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node có 2 con: tìm successor (nhỏ nhất cây con phải)
            root.key = minValue(root.right);

            // Xóa successor
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
```

---

# Claude-generated Unit Tests

```java
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
```

---

## Giải thích các nhóm test

**Trạng thái khởi tạo**
- Cây mới tạo: `isEmpty()` = true, `inorder()` = danh sách rỗng.
- `search()` và `delete()` trên cây rỗng hoạt động an toàn, không gây lỗi.

**Thêm node (insert)**
- Thêm node đầu tiên (root), thêm node trái, thêm node phải.
- Thêm nhiều node: cấu trúc cây đúng, inorder trả về dãy tăng dần.
- Thêm giá trị trùng lặp: bị bỏ qua.
- Giá trị âm: được lưu trữ đúng.

**Tìm kiếm (search)**
- Tìm thấy giá trị ở root, cây con trái, cây con phải.
- Không tìm thấy giá trị không tồn tại.

**Duyệt cây Inorder**
- Cây một node, cây lệch trái, cây lệch phải, cây cân bằng.
- Kết quả luôn là dãy tăng dần.

**Xóa node (delete)**
- Xóa node lá, node có một con trái, node có một con phải.
- Xóa node có hai con: dùng inorder successor thay thế.
- Xóa root, xóa giá trị không tồn tại.

**Trường hợp biên**
- `Integer.MIN_VALUE` và `Integer.MAX_VALUE`.
- Xóa tất cả node → cây rỗng.
- Thêm/xóa xen kẽ → cây vẫn đúng cấu trúc.
- Số lượng node lớn (50) → duy trì tính chất BST.
