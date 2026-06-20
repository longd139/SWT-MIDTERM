package linkedlist;

/**
 * Lớp SinglyLinkedList cài đặt danh sách liên kết đơn (Singly Linked List)
 * với các thao tác cơ bản: thêm, xóa, tìm kiếm, đếm, kiểm tra rỗng và in danh sách.
 *
 * <p>Danh sách sử dụng kiểu dữ liệu số nguyên (int) cho mỗi phần tử.</p>
 */
public class SinglyLinkedList {

    /** Nút đầu tiên của danh sách. */
    private Node head;

    /**
     * Khởi tạo danh sách liên kết rỗng.
     * head được gán bằng null.
     */
    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     * Thêm một phần tử vào đầu danh sách.
     * Tạo nút mới và đặt nó làm head hiện tại.
     *
     * @param data giá trị cần thêm vào đầu danh sách
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Thêm một phần tử vào cuối danh sách.
     * Duyệt đến nút cuối cùng rồi gán tham chiếu next của nút đó
     * đến nút mới. Nếu danh sách rỗng, nút mới sẽ trở thành head.
     *
     * @param data giá trị cần thêm vào cuối danh sách
     */
    public void addLast(int data) {
        Node newNode = new Node(data);

        // Trường hợp danh sách rỗng
        if (head == null) {
            head = newNode;
            return;
        }

        // Duyệt đến nút cuối cùng
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Xóa phần tử đầu tiên có giá trị bằng với data khỏi danh sách.
     * Nếu phần tử nằm ở đầu danh sách, head sẽ được cập nhật.
     *
     * @param data giá trị cần xóa khỏi danh sách
     * @return true nếu tìm thấy và xóa thành công, false nếu không tìm thấy
     */
    public boolean delete(int data) {
        // Trường hợp danh sách rỗng
        if (head == null) {
            return false;
        }

        // Trường hợp xóa phần tử đầu danh sách
        if (head.data == data) {
            head = head.next;
            return true;
        }

        // Duyệt tìm phần tử cần xóa
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        // Không tìm thấy phần tử
        return false;
    }

    /**
     * Tìm kiếm phần tử có giá trị cho trước trong danh sách.
     *
     * @param data giá trị cần tìm
     * @return true nếu tìm thấy, false nếu không tìm thấy
     */
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

    /**
     * Đếm số lượng phần tử hiện có trong danh sách.
     *
     * @return số lượng phần tử trong danh sách
     */
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Kiểm tra danh sách có rỗng hay không.
     *
     * @return true nếu danh sách rỗng (head == null), false nếu có phần tử
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * In toàn bộ danh sách ra màn hình theo định dạng:
     * data1 -> data2 -> ... -> dataN -> null
     */
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
