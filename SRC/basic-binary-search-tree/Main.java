public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 1. Check if the tree is empty
        System.out.println("Is the tree empty? " + bst.isEmpty());

        // 2. Insert data into the tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inserted nodes: 50, 30, 20, 40, 70, 60, 80");

        // 3. Traverse the tree (In-order)
        System.out.println("In-order traversal (ascending): " + bst.inorder());

        // 4. Search
        int searchKey = 40;
        System.out.println("Search for node " + searchKey + " in the tree: " + bst.search(searchKey));

        // 5. Delete a node
        int deleteKey = 20;
        bst.delete(deleteKey);
        System.out.println("After deleting node " + deleteKey + ", In-order: " + bst.inorder());
    }
}