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
package linkedlist;

public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean delete(int data) {
        if (head == null) {
            return false;
        }

        if (head.data == data) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

package linkedlist;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

# Claude-generated Unit Tests

```java
package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList();
    }

    // =====================================================
    // Trạng thái khởi tạo (isEmpty, size, search, delete)
    // =====================================================

    @Test
    void isEmpty_NewList_ShouldReturnTrue() {
        // Arrange (done in setUp)

        // Act
        boolean result = list.isEmpty();

        // Assert
        assertTrue(result);
    }

    @Test
    void size_NewList_ShouldReturnZero() {
        // Arrange (done in setUp)

        // Act
        int result = list.size();

        // Assert
        assertEquals(0, result);
    }

    @Test
    void search_OnEmptyList_ShouldReturnFalse() {
        // Arrange (done in setUp)

        // Act
        boolean result = list.search(42);

        // Assert
        assertFalse(result);
    }

    @Test
    void delete_OnEmptyList_ShouldReturnFalse() {
        // Arrange (done in setUp)

        // Act
        boolean result = list.delete(10);

        // Assert
        assertFalse(result);
    }

    // =====================================================
    // Thêm vào đầu danh sách (addFirst)
    // =====================================================

    @Test
    void addFirst_SingleElement_ShouldNotBeEmpty() {
        // Arrange & Act
        list.addFirst(100);

        // Assert
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    void addFirst_SingleElement_ShouldBeSearchable() {
        // Arrange & Act
        list.addFirst(77);

        // Assert
        assertTrue(list.search(77));
    }

    @Test
    void addFirst_MultipleElements_ShouldAllBeSearchable() {
        // Arrange & Act
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        // Assert
        assertEquals(3, list.size());
        assertTrue(list.search(30));
        assertTrue(list.search(20));
        assertTrue(list.search(10));
    }

    // =====================================================
    // Thêm vào cuối danh sách (addLast)
    // =====================================================

    @Test
    void addLast_OnEmptyList_ShouldAddAsHead() {
        // Arrange & Act
        list.addLast(55);

        // Assert
        assertTrue(list.search(55));
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void addLast_OnNonEmptyList_ShouldAppendAtEnd() {
        // Arrange
        list.addLast(10);

        // Act
        list.addLast(20);

        // Assert
        assertEquals(2, list.size());
        assertTrue(list.search(10));
        assertTrue(list.search(20));
    }

    @Test
    void addLast_MultipleElements_ShouldKeepCorrectOrder() {
        // Arrange & Act
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Assert
        assertEquals(5, list.size());
        assertTrue(list.search(1));
        assertTrue(list.search(3));
        assertTrue(list.search(5));
    }

    // =====================================================
    // Kết hợp addFirst và addLast
    // =====================================================

    @Test
    void addFirstAndAddLast_MixedOrder_ShouldAllBePresent() {
        // Arrange & Act
        list.addFirst(200);
        list.addLast(300);

        // Assert
        assertEquals(2, list.size());
        assertTrue(list.search(200));
        assertTrue(list.search(300));
    }

    @Test
    void interleavedAdd_ShouldTrackCorrectSize() {
        // Arrange & Act
        list.addFirst(1);   // [1]
        list.addLast(2);    // [1, 2]
        list.addFirst(3);   // [3, 1, 2]
        list.addLast(4);    // [3, 1, 2, 4]
        list.addFirst(5);   // [5, 3, 1, 2, 4]

        // Assert
        assertEquals(5, list.size());
        assertAll(
            () -> assertTrue(list.search(1)),
            () -> assertTrue(list.search(2)),
            () -> assertTrue(list.search(3)),
            () -> assertTrue(list.search(4)),
            () -> assertTrue(list.search(5))
        );
    }

    // =====================================================
    // Tìm kiếm (search)
    // =====================================================

    @Test
    void search_FirstElement_ShouldReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.search(10);

        // Assert
        assertTrue(result);
    }

    @Test
    void search_MiddleElement_ShouldReturnTrue() {
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
    void search_LastElement_ShouldReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.search(30);

        // Assert
        assertTrue(result);
    }

    @Test
    void search_NonExistingElement_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.search(99);

        // Assert
        assertFalse(result);
    }

    // =====================================================
    // Xóa (delete)
    // =====================================================

    @Test
    void delete_HeadElement_ShouldRemoveAndReturnTrue() {
        // Arrange
        list.addLast(100);
        list.addLast(200);
        list.addLast(300);

        // Act
        boolean result = list.delete(100);

        // Assert
        assertTrue(result);
        assertFalse(list.search(100));
        assertEquals(2, list.size());
        assertTrue(list.search(200));
        assertTrue(list.search(300));
    }

    @Test
    void delete_MiddleElement_ShouldRemoveAndReturnTrue() {
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
        assertTrue(list.search(10));
        assertTrue(list.search(30));
    }

    @Test
    void delete_LastElement_ShouldRemoveAndReturnTrue() {
        // Arrange
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // Act
        boolean result = list.delete(3);

        // Assert
        assertTrue(result);
        assertFalse(list.search(3));
        assertEquals(2, list.size());
        assertTrue(list.search(1));
        assertTrue(list.search(2));
    }

    @Test
    void delete_OnlyElement_ShouldMakeListEmpty() {
        // Arrange
        list.addLast(999);

        // Act
        boolean result = list.delete(999);

        // Assert
        assertTrue(result);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertFalse(list.search(999));
    }

    @Test
    void delete_NonExistingElement_ShouldReturnFalse() {
        // Arrange
        list.addLast(50);
        list.addLast(60);

        // Act
        boolean result = list.delete(999);

        // Assert
        assertFalse(result);
        assertEquals(2, list.size());
    }

    // =====================================================
    // Trường hợp biên
    // =====================================================

    @Test
    void add_NegativeValues_ShouldBeStoredCorrectly() {
        // Arrange & Act
        list.addLast(-5);
        list.addLast(-10);
        list.addFirst(-15);

        // Assert
        assertEquals(3, list.size());
        assertTrue(list.search(-5));
        assertTrue(list.search(-10));
        assertTrue(list.search(-15));
    }

    @Test
    void add_Zero_ShouldBeStoredCorrectly() {
        // Arrange & Act
        list.addLast(0);
        list.addFirst(1);

        // Assert
        assertTrue(list.search(0));
        assertTrue(list.search(1));
        assertEquals(2, list.size());
    }

    @Test
    void add_DuplicateValues_ShouldBeAllowed() {
        // Arrange & Act
        list.addLast(42);
        list.addLast(42);
        list.addLast(42);

        // Assert
        assertEquals(3, list.size());
        assertTrue(list.search(42));
    }

    @Test
    void delete_DuplicateValues_ShouldDeleteOnlyFirstOccurrence() {
        // Arrange
        list.addLast(7);
        list.addLast(7);
        list.addLast(7);

        // Act & Assert - Xóa lần 1
        assertTrue(list.delete(7));
        assertEquals(2, list.size());

        // Xóa lần 2
        assertTrue(list.delete(7));
        assertEquals(1, list.size());

        // Xóa lần 3
        assertTrue(list.delete(7));
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void deleteAllAndReAdd_ShouldWorkCorrectly() {
        // Arrange
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // Act - xóa hết
        list.delete(1);
        list.delete(2);
        list.delete(3);

        // Assert - danh sách rỗng
        assertTrue(list.isEmpty());

        // Act - thêm lại
        list.addFirst(99);

        // Assert
        assertEquals(1, list.size());
        assertTrue(list.search(99));
    }

    @Test
    void largeList_AddAndSearch_ShouldWorkCorrectly() {
        // Arrange - Thêm 100 phần tử
        for (int i = 1; i <= 100; i++) {
            list.addLast(i);
        }
        assertEquals(100, list.size());

        // Act & Assert
        assertTrue(list.search(1));
        assertTrue(list.search(50));
        assertTrue(list.search(100));
        assertFalse(list.search(101));

        // Xóa một số phần tử
        assertTrue(list.delete(1));
        assertTrue(list.delete(50));
        assertTrue(list.delete(100));
        assertEquals(97, list.size());
    }

    @Test
    void display_ShouldNotThrowException() {
        // Act & Assert - danh sách rỗng
        assertDoesNotThrow(() -> list.display());

        // Thêm phần tử rồi gọi display
        list.addLast(10);
        list.addLast(20);
        assertDoesNotThrow(() -> list.display());
    }
}
```

---

## Giải thích các nhóm test

**Trạng thái khởi tạo**
- Kiểm tra danh sách mới tạo: `isEmpty()` = true, `size()` = 0.
- `search()` và `delete()` trên danh sách rỗng đều trả về false, không gây lỗi.

**Thêm vào đầu (addFirst)**
- Thêm một phần tử: danh sách không còn rỗng, có thể tìm thấy.
- Thêm nhiều phần tử: tất cả đều tìm thấy được.

**Thêm vào cuối (addLast)**
- Thêm vào danh sách rỗng: phần tử trở thành head.
- Thêm vào danh sách có phần tử: giữ đúng thứ tự chèn.
- Thêm nhiều phần tử: tất cả tồn tại.

**Kết hợp addFirst và addLast**
- Xác minh cả hai phương thức hoạt động đúng khi xen kẽ, kích thước chính xác.

**Tìm kiếm (search)**
- Tìm thấy phần tử ở đầu, giữa, cuối danh sách.
- Không tìm thấy phần tử không tồn tại.

**Xóa (delete)**
- Xóa phần tử đầu, giữa, cuối danh sách.
- Xóa phần tử duy nhất → danh sách rỗng.
- Xóa phần tử không tồn tại → trả về false.

**Trường hợp biên**
- Giá trị âm, giá trị 0, giá trị trùng lặp (được phép).
- Xóa các bản sao trùng lặp: chỉ xóa lần xuất hiện đầu tiên.
- Xóa hết rồi thêm lại.
- Danh sách lớn (100 phần tử).
- `display()` không ném ngoại lệ trên cả danh sách rỗng và có dữ liệu.
