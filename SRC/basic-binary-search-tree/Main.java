public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 1. Kiểm tra cây rỗng
        System.out.println("Cây rỗng không? " + bst.isEmpty());

        // 2. Thêm dữ liệu vào cây
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Đã thêm các node: 50, 30, 20, 40, 70, 60, 80");

        // 3. Duyệt cây (In-order)
        System.out.println("Duyệt cây In-order (tăng dần): " + bst.inorder());

        // 4. Tìm kiếm
        int searchKey = 40;
        System.out.println("Tìm node " + searchKey + " trên cây: " + bst.search(searchKey));

        // 5. Xóa node
        int deleteKey = 20;
        bst.delete(deleteKey);
        System.out.println("Sau khi xóa node " + deleteKey + ", In-order: " + bst.inorder());
    }
}