package linkedlist;

/**
 * Lớp Main dùng để minh họa cách sử dụng các chức năng
 * của danh sách liên kết đơn (SinglyLinkedList).
 *
 * <p>Chương trình thực hiện tuần tự các thao tác: thêm, xóa,
 * tìm kiếm, đếm và in danh sách, qua đó kiểm chứng hoạt động
 * của từng phương thức trong lớp SinglyLinkedList.</p>
 */
public class Main {

    /**
     * Điểm bắt đầu thực thi chương trình.
     *
     * @param args tham số dòng lệnh (không sử dụng)
     */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // 1. Kiểm tra danh sách rỗng
        System.out.println("=== Kiem tra danh sach rỗng ===");
        System.out.println("Danh sach rỗng? " + list.isEmpty());
        list.display();
        System.out.println();

        // 2. Thêm phần tử vào đầu danh sách
        System.out.println("=== Them phan tu vao dau ===");
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.display();
        System.out.println("So luong phan tu: " + list.size());
        System.out.println();

        // 3. Thêm phần tử vào cuối danh sách
        System.out.println("=== Them phan tu vao cuoi ===");
        list.addLast(5);
        list.addLast(1);
        list.display();
        System.out.println("So luong phan tu: " + list.size());
        System.out.println();

        // 4. Tìm kiếm phần tử
        System.out.println("=== Tim kiem phan tu ===");
        System.out.println("Tim 20: " + list.search(20));
        System.out.println("Tim 100: " + list.search(100));
        System.out.println();

        // 5. Xóa phần tử
        System.out.println("=== Xoa phan tu ===");
        System.out.println("Xoa 30 (dau danh sach): " + list.delete(30));
        list.display();
        System.out.println("Xoa 5 (giua danh sach): " + list.delete(5));
        list.display();
        System.out.println("Xoa 1 (cuoi danh sach): " + list.delete(1));
        list.display();
        System.out.println("Xoa 999 (khong ton tai): " + list.delete(999));
        list.display();
        System.out.println();

        // 6. Kiểm tra trạng thái cuối
        System.out.println("=== Trang thai cuoi cung ===");
        System.out.println("Danh sach rỗng? " + list.isEmpty());
        System.out.println("So luong phan tu: " + list.size());
        list.display();
    }
}
