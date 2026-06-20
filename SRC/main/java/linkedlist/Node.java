package linkedlist;

/**
 * Lớp Node biểu diễn một nút trong danh sách liên kết đơn (Singly Linked List).
 * Mỗi nút chứa một giá trị số nguyên và tham chiếu đến nút kế tiếp.
 */
public class Node {

    /** Giá trị dữ liệu được lưu trong nút. */
    int data;

    /** Tham chiếu đến nút kế tiếp trong danh sách. */
    Node next;

    /**
     * Khởi tạo một nút mới với giá trị cho trước.
     * Tham chiếu next mặc định là null.
     *
     * @param data giá trị số nguyên cần lưu trong nút
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
