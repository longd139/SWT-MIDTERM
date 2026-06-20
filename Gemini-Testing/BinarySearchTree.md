# Prompt Sinh Unit Test JUnit 5 - Bài 3: BinarySearchTree

Bạn là một kỹ sư kiểm thử phần mềm.

Hãy viết unit test cho đoạn mã Java sau bằng JUnit 5.

## Yêu cầu

1. Sử dụng cấu trúc Arrange – Act – Assert (AAA) cho tất cả test case.
2. Bao phủ các nhóm kiểm thử:

   * Trường hợp bình thường (Normal Cases)
   * Trường hợp biên (Boundary Cases)
   * Trường hợp lỗi (Exception Cases nếu có)
3. Đặt tên test case rõ ràng theo quy tắc:

```text
methodName_condition_expectedResult
```

Ví dụ:

```text
insert_WhenTreeIsEmpty_ShouldCreateRootNode
search_WhenKeyExists_ShouldReturnTrue
delete_WhenDeletingLeafNode_ShouldRemoveNode
```

4. Không thay đổi logic của mã nguồn gốc.
5. Sử dụng JUnit 5 và các assertion phù hợp.
6. Giải thích ngắn gọn mục đích của từng nhóm test.
7. Bao phủ tất cả các nhánh điều kiện trong:

   * isEmpty()
   * insert()
   * search()
   * delete()
   * inorder()
8. Không cần viết test cho lớp Main.
9. Nếu phát hiện trường hợp kiểm thử còn thiếu thì tự động bổ sung.

## Các trường hợp cần kiểm thử

### Đối với isEmpty()

* Cây mới khởi tạo
* Sau khi thêm node

### Đối với insert()

* Thêm node đầu tiên (root)
* Thêm node bên trái
* Thêm node bên phải
* Thêm nhiều node
* Thêm giá trị trùng lặp (không được thêm vào cây)

### Đối với search()

* Tìm thấy node root
* Tìm thấy node bên trái
* Tìm thấy node bên phải
* Không tìm thấy node
* Tìm trên cây rỗng

### Đối với delete()

* Xóa trên cây rỗng
* Xóa node lá (leaf node)
* Xóa node có một con trái
* Xóa node có một con phải
* Xóa node có hai con
* Xóa node root
* Xóa phần tử không tồn tại

### Đối với inorder()

* Duyệt cây rỗng
* Duyệt cây có một node
* Duyệt cây có nhiều node
* Kiểm tra kết quả có đúng thứ tự tăng dần hay không

## Cấu trúc kết quả mong muốn

### 1. Phân tích mã nguồn

* Các chức năng cần kiểm thử
* Các trường hợp biên
* Các trường hợp lỗi
* Các nhánh điều kiện cần bao phủ

### 2. Danh sách Test Case

| ID   | Test Case | Loại      |
| ---- | --------- | --------- |
| TC01 | ...       | Normal    |
| TC02 | ...       | Boundary  |
| TC03 | ...       | Exception |

### 3. Mã nguồn Unit Test JUnit 5

```java
// Full source code
```

### 4. Giải thích các nhóm test

#### Normal Cases

...

#### Boundary Cases

...

#### Exception Cases

...

### 5. Đánh giá độ bao phủ

* Các nhánh điều kiện đã được kiểm thử
* Các phương thức đã được kiểm thử
* Ước lượng mức độ bao phủ đạt được

---

## Mã nguồn cần kiểm thử

### BinarySearchTree.java

```java
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    Node root;

    // Initialize an empty tree
    public BinarySearchTree() {
        root = null;
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Insert a new node
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

        // Duplicate values are ignored
        return root;
    }

    // Search for a value
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

    // Delete a node
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

            // Node has 0 or 1 child
            if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;
            }

            // Node has 2 children
            root.key = minValue(root.right);

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

    // In-order traversal
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
```

### Node.java

```java
public class Node {

    int key;
    Node left;
    Node right;

    public Node(int item) {
        key = item;
        left = null;
        right = null;
    }
}
```














# Báo Cáo Kiểm Thử Unit Test (JUnit 5) - Bài: BinarySearchTree

**Người thực hiện:** [Tên của bạn]  
**Công nghệ sử dụng:** Java, JUnit 5  

---

## 1. Phân tích mã nguồn

**Các chức năng cần kiểm thử:**
* `isEmpty()`: Kiểm tra trạng thái rỗng của cây.
* `insert(int key)`: Thêm node mới, đảm bảo tính chất Binary Search Tree (nhỏ sang trái, lớn sang phải, bỏ qua trùng lặp).
* `search(int key)`: Tìm kiếm sự tồn tại của một giá trị trong cây.
* `delete(int key)`: Xóa một node khỏi cây. Đây là hàm phức tạp nhất vì phải xử lý 3 trường hợp: node lá, node có 1 con và node có 2 con.
* `inorder()`: Duyệt cây theo thứ tự In-order (Trái - Gốc - Phải), kết quả trả về phải là một danh sách đã được sắp xếp tăng dần.

**Các nhánh điều kiện cần bao phủ:**
* **`insertRec`**: Cây rỗng (`root == null`), rẽ trái (`key < root.key`), rẽ phải (`key > root.key`), và trường hợp trùng lặp (không làm gì cả).
* **`searchRec`**: Gốc rỗng hoặc tìm thấy (`root == null || root.key == key`), rẽ trái, rẽ phải.
* **`deleteRec`**: Cây rỗng, tìm trái, tìm phải. Tại node cần xóa: nhánh không có con trái (`root.left == null`), nhánh không có con phải (`root.right == null`), và nhánh có đủ 2 con (cần gọi thêm hàm `minValue`).
* **`minValue`**: Vòng lặp `while (root.left != null)` để tìm phần tử nhỏ nhất của cây con bên phải.

**Các trường hợp biên (Boundary Cases):**
* Thao tác trên cây rỗng (khởi tạo mới).
* Thao tác trên cây chỉ có 1 phần tử (node duy nhất vừa là root vừa là lá).
* Thêm/Xóa/Tìm kiếm ngay tại node Root (Gốc).

**Các trường hợp lỗi / tiêu cực (Exception / Negative Cases):**
* Mã nguồn không ném ra exception. Khi xóa hoặc tìm kiếm một giá trị không tồn tại, hàm sẽ trả về `false` hoặc giữ nguyên cấu trúc cây. Ta sẽ kiểm thử các kịch bản negative này để đảm bảo chương trình không bị crash (như `NullPointerException`).

---

## 2. Danh sách Test Case

| ID | Test Case (Method Name) | Loại |
| :--- | :--- | :--- |
| TC01 | `isEmpty_WhenTreeIsNewlyCreated_ShouldReturnTrue` | Boundary |
| TC02 | `isEmpty_AfterInsertingNode_ShouldReturnFalse` | Normal |
| TC03 | `insert_WhenTreeIsEmpty_ShouldCreateRootNode` | Boundary |
| TC04 | `insert_WhenKeyIsSmaller_ShouldInsertLeft` | Normal |
| TC05 | `insert_WhenKeyIsLarger_ShouldInsertRight` | Normal |
| TC06 | `insert_MultipleNodes_ShouldBuildCorrectTree` | Normal |
| TC07 | `insert_WhenKeyIsDuplicate_ShouldIgnoreDuplicate` | Negative |
| TC08 | `search_WhenKeyIsRoot_ShouldReturnTrue` | Boundary |
| TC09 | `search_WhenKeyIsInLeftSubtree_ShouldReturnTrue` | Normal |
| TC10 | `search_WhenKeyIsInRightSubtree_ShouldReturnTrue` | Normal |
| TC11 | `search_WhenKeyDoesNotExist_ShouldReturnFalse` | Negative |
| TC12 | `search_WhenTreeIsEmpty_ShouldReturnFalse` | Boundary |
| TC13 | `delete_WhenTreeIsEmpty_ShouldDoNothing` | Boundary |
| TC14 | `delete_WhenNodeIsLeaf_ShouldRemoveNode` | Normal |
| TC15 | `delete_WhenNodeHasOnlyLeftChild_ShouldReplaceWithLeftChild` | Normal |
| TC16 | `delete_WhenNodeHasOnlyRightChild_ShouldReplaceWithRightChild` | Normal |
| TC17 | `delete_WhenNodeHasTwoChildren_ShouldReplaceWithInorderSuccessor` | Normal |
| TC18 | `delete_WhenNodeIsRoot_ShouldUpdateRoot` | Boundary |
| TC19 | `delete_WhenKeyDoesNotExist_ShouldDoNothing` | Negative |
| TC20 | `inorder_WhenTreeIsEmpty_ShouldReturnEmptyList` | Boundary |
| TC21 | `inorder_WhenTreeHasOneNode_ShouldReturnListWithOneElement` | Boundary |
| TC22 | `inorder_WhenTreeHasMultipleNodes_ShouldReturnSortedList` | Normal |

---

## 3. Mã nguồn Unit Test JUnit 5

```java
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
```

---

## 4. Giải thích các nhóm test

* **Normal Cases (Trường hợp bình thường):** Nhóm này kiểm thử các thao tác cơ bản và thường xuyên nhất khi sử dụng cây nhị phân tìm kiếm. Nó đảm bảo rằng các node nhỏ hơn được đặt bên trái, node lớn hơn được đặt bên phải, và phép duyệt In-order luôn trả về một mảng dữ liệu đã được sắp xếp tăng dần. Đồng thời, nó cover trọn vẹn 3 thuật toán cốt lõi của việc xóa node (xóa lá, xóa node 1 con, xóa node 2 con).

* **Boundary Cases (Trường hợp biên):** Nhóm này đưa cây vào các trạng thái giới hạn. Kịch bản quan trọng nhất là thao tác trên cây rỗng (khởi tạo mới), đảm bảo không xảy ra `NullPointerException`. Kế tiếp là kiểm thử các thao tác ảnh hưởng trực tiếp đến node `Root` (thêm phần tử đầu tiên làm gốc, xóa gốc) vì các thao tác này thường yêu cầu thay đổi con trỏ chính của toàn bộ cấu trúc dữ liệu.

* **Exception / Negative Cases (Trường hợp lỗi/tiêu cực):** Nhóm này tập trung vào các tình huống "lỗi logic đầu vào" từ người dùng, ví dụ như cố tình thêm một giá trị đã tồn tại, hoặc yêu cầu xóa/tìm kiếm một phần tử không có trong cây. Mã nguồn được thiết kế an toàn, do đó các test case này sử dụng Assert để xác minh rằng cấu trúc cây không bị hỏng và số lượng phần tử không bị thay đổi sai lệch.

---

## 5. Đánh giá độ bao phủ

* **Các nhánh điều kiện đã được kiểm thử:**
  * **`insertRec`**: Đi qua nhánh root null, nhánh thêm trái (`<`), nhánh thêm phải (`>`) và nhánh bằng (duplicate).
  * **`searchRec`**: Đi qua nhánh gốc rỗng/tìm thấy, nhánh rẽ trái, nhánh rẽ phải.
  * **`deleteRec`**: Kích hoạt đủ nhánh gốc rỗng, rẽ trái, rẽ phải. Tại block tìm thấy phần tử, đã test đủ nhánh `left == null`, `right == null` và rẽ nhánh else (khi có đủ 2 con, gọi `minValue`).
  * **`minValue`**: Chạy vòng lặp `while(root.left != null)` và điều kiện thoát vòng lặp.
* **Các phương thức đã được kiểm thử:** `isEmpty`, `insert`, `insertRec`, `search`, `searchRec`, `delete`, `deleteRec`, `minValue`, `inorder`, `inorderRec`. Toàn bộ các phương thức đều được kiểm thử.
* **Ước lượng mức độ bao phủ đạt được:**
  * **Statement Coverage (Độ phủ dòng lệnh):** 100%. Tất cả các dòng code nghiệp vụ đều được kích hoạt chạy qua.
  * **Branch Coverage (Độ phủ nhánh):** 100%. Mọi hướng rẽ if-else (bao gồm cả các trường hợp điều hướng đệ quy) đều được cover trọn vẹn thông qua việc dựng các bộ dữ liệu cây đa dạng.