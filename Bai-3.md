# Chuẩn bị Bài 3: Cây nhị phân tìm kiếm (BST) cơ bản

Tài liệu này cung cấp mã nguồn Java chuẩn và checklist kiểm thử cho cấu trúc dữ liệu Cây nhị phân tìm kiếm (Binary Search Tree), phục vụ cho việc đánh giá và so sánh giữa viết Unit Test thủ công và sinh Unit Test bằng AI (JUnit 5).

---

## 1. Mã nguồn Java (Cần test)

Vui lòng tạo một file mang tên `BinarySearchTree.java` và sử dụng đoạn mã nguồn dưới đây. Mã nguồn này đã được thiết kế với đầy đủ các thao tác cơ bản và chứa đủ các nhánh logic (if-else) nhằm phục vụ việc kiểm thử độ bao phủ (coverage).

```java
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    
    // Lớp Node nội bộ
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

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

    // Duyệt cây theo thứ tự In-order (Trái - Gốc - Phải)..
    // Hỗ trợ assert thứ tự tăng dần của mảng trong Unit Test
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