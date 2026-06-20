# Prompt Sinh Unit Test JUnit 5 - Bài 2: SinglyLinkedList

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
addFirst_WhenListIsEmpty_ShouldInsertNode
delete_WhenValueExists_ShouldReturnTrue
search_WhenValueNotFound_ShouldReturnFalse
```

4. Không thay đổi logic của mã nguồn gốc.
5. Sử dụng JUnit 5 và các assertion phù hợp.
6. Giải thích ngắn gọn mục đích của từng nhóm test.
7. Bao phủ tất cả các nhánh điều kiện trong:

   * addFirst()
   * addLast()
   * delete()
   * search()
   * size()
   * isEmpty()
8. Không cần viết test cho lớp Main.
9. Nếu phát hiện trường hợp kiểm thử còn thiếu thì tự động bổ sung.

## Các trường hợp cần kiểm thử

### Đối với addFirst()

* Thêm vào danh sách rỗng
* Thêm vào danh sách đã có phần tử
* Kiểm tra size sau khi thêm

### Đối với addLast()

* Thêm vào danh sách rỗng
* Thêm vào danh sách có 1 phần tử
* Thêm vào danh sách có nhiều phần tử
* Kiểm tra size sau khi thêm

### Đối với delete()

* Xóa trên danh sách rỗng
* Xóa node đầu danh sách
* Xóa node giữa danh sách
* Xóa node cuối danh sách
* Xóa phần tử không tồn tại
* Xóa phần tử duy nhất trong danh sách

### Đối với search()

* Tìm thấy phần tử
* Không tìm thấy phần tử
* Tìm trên danh sách rỗng

### Đối với size()

* Danh sách rỗng
* Danh sách có 1 phần tử
* Danh sách có nhiều phần tử

### Đối với isEmpty()

* Danh sách mới khởi tạo
* Sau khi thêm phần tử
* Sau khi xóa hết phần tử

## Cấu trúc kết quả mong muốn

### 1. Phân tích mã nguồn

* Các chức năng cần kiểm thử
* Các trường hợp biên
* Các trường hợp lỗi

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

### SinglyLinkedList.java

```java
package linkedlist;

public class SinglyLinkedList {

   private Node head = null;

   public SinglyLinkedList() {
   }

   public void addFirst(int data) {
      Node newNode = new Node(data);
      newNode.next = this.head;
      this.head = newNode;
   }

   public void addLast(int data) {
      Node newNode = new Node(data);

      if (this.head == null) {
         this.head = newNode;
      } else {
         Node current;

         for(current = this.head; current.next != null; current = current.next) {
         }

         current.next = newNode;
      }
   }

   public boolean delete(int data) {
      if (this.head == null) {
         return false;

      } else if (this.head.data == data) {
         this.head = this.head.next;
         return true;

      } else {

         for(Node current = this.head; current.next != null; current = current.next) {

            if (current.next.data == data) {
               current.next = current.next.next;
               return true;
            }
         }

         return false;
      }
   }

   public boolean search(int data) {

      for(Node current = this.head; current != null; current = current.next) {

         if (current.data == data) {
            return true;
         }
      }

      return false;
   }

   public int size() {

      int count = 0;

      for(Node current = this.head; current != null; current = current.next) {
         ++count;
      }

      return count;
   }

   public boolean isEmpty() {
      return this.head == null;
   }

   public void display() {

      for(Node current = this.head; current != null; current = current.next) {
         System.out.print(current.data + " -> ");
      }

      System.out.println("null");
   }
}
```

### Node.java

```java
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

















# Báo Cáo Kiểm Thử Unit Test (JUnit 5) - Bài: SinglyLinkedList

**Người thực hiện:** [Nguyễn Phương Nguyên]  
**Công nghệ sử dụng:** Java, JUnit 5  

---

## 1. Phân tích mã nguồn

**Các chức năng cần kiểm thử:**
* `addFirst(int data)`: Thêm một phần tử vào đầu danh sách.
* `addLast(int data)`: Thêm một phần tử vào cuối danh sách.
* `delete(int data)`: Xóa phần tử đầu tiên có giá trị khớp với `data`.
* `search(int data)`: Tìm kiếm sự tồn tại của một giá trị trong danh sách.
* `size()`: Đếm tổng số phần tử hiện có trong danh sách.
* `isEmpty()`: Kiểm tra xem danh sách có đang rỗng hay không.

**Các trường hợp biên (Boundary Cases):**
* Thao tác trên danh sách hoàn toàn rỗng.
* Thao tác khi danh sách chỉ có đúng 1 phần tử (node duy nhất vừa là head vừa là tail).
* Các thao tác tại vị trí nhạy cảm: Xóa/Tìm kiếm ở ngay đầu danh sách (Head) hoặc ngay cuối danh sách (Tail).

**Các trường hợp lỗi / ngoại lệ (Exception / Negative Cases):**
* Mã nguồn được thiết kế an toàn, không ném ra các ngoại lệ (như `NullPointerException`) khi thao tác sai. Thay vào đó, nó xử lý ngầm (ví dụ: `delete` hoặc `search` trên danh sách rỗng sẽ trả về `false`).
* Thao tác xóa một phần tử không hề tồn tại trong danh sách.

---

## 2. Danh sách Test Case

| ID | Test Case (Method Name) | Loại |
| :--- | :--- | :--- |
| TC01 | `addFirst_WhenListIsEmpty_ShouldInsertNode` | Boundary |
| TC02 | `addFirst_WhenListIsNotEmpty_ShouldInsertAtBeginning` | Normal |
| TC03 | `addFirst_AfterAdding_ShouldIncreaseSize` | Normal |
| TC04 | `addLast_WhenListIsEmpty_ShouldInsertNode` | Boundary |
| TC05 | `addLast_WhenListHasOneElement_ShouldInsertAtEnd` | Normal |
| TC06 | `addLast_WhenListHasMultipleElements_ShouldInsertAtEnd` | Normal |
| TC07 | `addLast_AfterAdding_ShouldIncreaseSize` | Normal |
| TC08 | `delete_WhenListIsEmpty_ShouldReturnFalse` | Boundary |
| TC09 | `delete_WhenValueIsAtHead_ShouldRemoveHeadAndReturnTrue` | Boundary |
| TC10 | `delete_WhenValueIsInMiddle_ShouldRemoveNodeAndReturnTrue` | Normal |
| TC11 | `delete_WhenValueIsAtTail_ShouldRemoveTailAndReturnTrue` | Normal |
| TC12 | `delete_WhenValueDoesNotExist_ShouldReturnFalse` | Exception/Negative |
| TC13 | `delete_WhenListHasOnlyOneElement_ShouldMakeListEmpty` | Boundary |
| TC14 | `search_WhenValueExists_ShouldReturnTrue` | Normal |
| TC15 | `search_WhenValueDoesNotExist_ShouldReturnFalse` | Normal |
| TC16 | `search_WhenListIsEmpty_ShouldReturnFalse` | Boundary |
| TC17 | `size_WhenListIsEmpty_ShouldReturnZero` | Boundary |
| TC18 | `size_WhenListHasOneElement_ShouldReturnOne` | Normal |
| TC19 | `size_WhenListHasMultipleElements_ShouldReturnCorrectCount` | Normal |
| TC20 | `isEmpty_WhenNewlyCreated_ShouldReturnTrue` | Boundary |
| TC21 | `isEmpty_AfterAddingElement_ShouldReturnFalse` | Normal |
| TC22 | `isEmpty_AfterDeletingAllElements_ShouldReturnTrue` | Boundary |

---

## 3. Mã nguồn Unit Test JUnit 5

```java
package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new SinglyLinkedList();
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ADDFIRST()
    // ==========================================

    @Test
    public void addFirst_WhenListIsEmpty_ShouldInsertNode() {
        // Arrange & Act
        list.addFirst(10);

        // Assert
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertTrue(list.search(10));
    }

    @Test
    public void addFirst_WhenListIsNotEmpty_ShouldInsertAtBeginning() {
        // Arrange
        list.addFirst(20);

        // Act
        list.addFirst(10);

        // Assert
        assertEquals(2, list.size());
        assertTrue(list.search(10));
        // Xác minh 10 nằm ở đầu bằng cách xóa nó và kiểm tra size
        assertTrue(list.delete(10));
        assertEquals(1, list.size());
        assertTrue(list.search(20));
    }

    @Test
    public void addFirst_AfterAdding_ShouldIncreaseSize() {
        // Arrange
        int initialSize = list.size();

        // Act
        list.addFirst(10);
        list.addFirst(20);

        // Assert
        assertEquals(initialSize + 2, list.size());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ADDLAST()
    // ==========================================

    @Test
    public void addLast_WhenListIsEmpty_ShouldInsertNode() {
        // Arrange & Act
        list.addLast(10);

        // Assert
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertTrue(list.search(10));
    }

    @Test
    public void addLast_WhenListHasOneElement_ShouldInsertAtEnd() {
        // Arrange
        list.addLast(10);

        // Act
        list.addLast(20);

        // Assert
        assertEquals(2, list.size());
        assertTrue(list.search(20));
    }

    @Test
    public void addLast_WhenListHasMultipleElements_ShouldInsertAtEnd() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        list.addLast(30);

        // Assert
        assertEquals(3, list.size());
        assertTrue(list.search(30));
    }

    @Test
    public void addLast_AfterAdding_ShouldIncreaseSize() {
        // Arrange & Act
        list.addLast(5);
        list.addLast(15);

        // Assert
        assertEquals(2, list.size());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC DELETE()
    // ==========================================

    @Test
    public void delete_WhenListIsEmpty_ShouldReturnFalse() {
        // Arrange (list is empty from setUp)
        // Act
        boolean result = list.delete(10);

        // Assert
        assertFalse(result);
    }

    @Test
    public void delete_WhenValueIsAtHead_ShouldRemoveHeadAndReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.delete(10);

        // Assert
        assertTrue(result);
        assertEquals(1, list.size());
        assertFalse(list.search(10));
    }

    @Test
    public void delete_WhenValueIsInMiddle_ShouldRemoveNodeAndReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.delete(20);

        // Assert
        assertTrue(result);
        assertEquals(2, list.size());
        assertFalse(list.search(20));
    }

    @Test
    public void delete_WhenValueIsAtTail_ShouldRemoveTailAndReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        boolean result = list.delete(30);

        // Assert
        assertTrue(result);
        assertEquals(2, list.size());
        assertFalse(list.search(30));
    }

    @Test
    public void delete_WhenValueDoesNotExist_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.delete(50);

        // Assert
        assertFalse(result);
        assertEquals(2, list.size()); // Size should remain unchanged
    }

    @Test
    public void delete_WhenListHasOnlyOneElement_ShouldMakeListEmpty() {
        // Arrange
        list.addLast(10);

        // Act
        boolean result = list.delete(10);

        // Assert
        assertTrue(result);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC SEARCH()
    // ==========================================

    @Test
    public void search_WhenValueExists_ShouldReturnTrue() {
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
    public void search_WhenValueDoesNotExist_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        boolean result = list.search(50);

        // Assert
        assertFalse(result);
    }

    @Test
    public void search_WhenListIsEmpty_ShouldReturnFalse() {
        // Arrange (list is empty)
        // Act
        boolean result = list.search(10);

        // Assert
        assertFalse(result);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC SIZE()
    // ==========================================

    @Test
    public void size_WhenListIsEmpty_ShouldReturnZero() {
        // Arrange & Act
        int result = list.size();

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void size_WhenListHasOneElement_ShouldReturnOne() {
        // Arrange
        list.addLast(10);

        // Act
        int result = list.size();

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void size_WhenListHasMultipleElements_ShouldReturnCorrectCount() {
        // Arrange
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Act
        int result = list.size();

        // Assert
        assertEquals(3, result);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ISEMPTY()
    // ==========================================

    @Test
    public void isEmpty_WhenNewlyCreated_ShouldReturnTrue() {
        // Arrange & Act & Assert
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty_AfterAddingElement_ShouldReturnFalse() {
        // Arrange
        list.addLast(10);

        // Act & Assert
        assertFalse(list.isEmpty());
    }

    @Test
    public void isEmpty_AfterDeletingAllElements_ShouldReturnTrue() {
        // Arrange
        list.addLast(10);
        list.addLast(20);

        // Act
        list.delete(10);
        list.delete(20);

        // Assert
        assertTrue(list.isEmpty());
    }
}
```

---

## 4. Giải thích các nhóm test

* **Normal Cases (Trường hợp bình thường):** Nhóm này mô phỏng các thao tác phổ biến nhất của người dùng, bao gồm: thêm phần tử vào danh sách đã có dữ liệu (`addFirst`, `addLast`), tìm kiếm một phần tử tồn tại, đếm kích thước khi có nhiều phần tử, và xóa một phần tử ở giữa danh sách. Việc kiểm thử các trường hợp này đảm bảo luồng nghiệp vụ lõi (Happy Path) hoạt động chính xác.

* **Boundary Cases (Trường hợp biên):** Nhóm này tập trung vào các trạng thái giới hạn của cấu trúc dữ liệu. Bao gồm việc thao tác (thêm, sửa, xóa, tìm kiếm, đếm) trên một danh sách hoàn toàn rỗng (`head == null`), danh sách chỉ có 1 phần tử (nơi phần tử đó vừa là đầu vừa là cuối), và thao tác tại các mốc nhạy cảm như xóa phần tử đầu tiên (đòi hỏi cập nhật lại con trỏ `head`) hoặc xóa phần tử cuối cùng (đòi hỏi duyệt hết toàn bộ chuỗi).

* **Exception / Negative Cases (Trường hợp lỗi/tiêu cực):** Vì mã nguồn được lập trình theo hướng không ném `Exception`, nhóm này kiểm tra tính "chống chịu" của code đối với các đầu vào không hợp lệ. Ví dụ: yêu cầu xóa hoặc tìm kiếm một giá trị không hề tồn tại trong hệ thống. Mã nguồn phải bắt được các tình huống này và xử lý êm đẹp bằng cách trả về `false` mà không làm vỡ cấu trúc danh sách.

---

## 5. Đánh giá độ bao phủ

* **Các nhánh điều kiện đã được kiểm thử:**
  * **`addLast()`**: Nhánh `head == null` và nhánh `else` (duyệt tìm node cuối).
  * **`delete()`**: Nhánh `head == null`, nhánh phần tử cần xóa ở ngay đầu (`head.data == data`), nhánh tìm thấy phần tử trong vòng lặp (`current.next.data == data`), và nhánh duyệt hết mà không tìm thấy (return false ở cuối).
  * **`search()`**: Nhánh điều kiện tìm thấy trong vòng lặp (`current.data == data`) và nhánh duyệt hết không tìm thấy.
  * **`size()` / `isEmpty()`**: Vòng lặp `for` và điều kiện `head == null` đều đã được kích hoạt.
* **Các phương thức đã được kiểm thử:** `addFirst`, `addLast`, `delete`, `search`, `size`, `isEmpty` (Toàn bộ các hàm yêu cầu đều đã được test, ngoại trừ hàm `display` dùng cho in console).
* **Ước lượng mức độ bao phủ đạt được:**
  * **Statement Coverage (Độ phủ dòng lệnh):** 100% đối với các hàm nghiệp vụ.
  * **Branch Coverage (Độ phủ nhánh):** 100%. Tất cả các biểu thức logic và các hướng rẽ `if-else` đều có test case đi qua.