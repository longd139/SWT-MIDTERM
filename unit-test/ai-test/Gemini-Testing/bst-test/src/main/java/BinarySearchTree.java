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
