# Checklist for Basic Binary Search Tree

This checklist is used to evaluate whether the test suite for the **Basic Binary Search Tree** assignment is sufficiently complete.

---

## 1. Normal Cases

- [ ] **1.1** Insert several nodes and verify the tree maintains correct BST structure.
- [ ] **1.2** Search for an existing key → returns `true`.
- [ ] **1.3** Search for a non-existing key → returns `false`.
- [ ] **1.4** Delete a leaf node → the remaining tree is still a valid BST.
- [ ] **1.5** Delete a node with one child → the child replaces it correctly.
- [ ] **1.6** Delete a node with two children → the inorder successor replaces it correctly.
- [ ] **1.7** Inorder traversal returns a list sorted in ascending order.

## 2. Edge Cases

- [ ] **2.1** Insert `Integer.MAX_VALUE` and `Integer.MIN_VALUE` → no errors, BST remains valid.
- [ ] **2.2** Search for `Integer.MAX_VALUE` / `Integer.MIN_VALUE` → correct result.
- [ ] **2.3** Delete `Integer.MAX_VALUE` / `Integer.MIN_VALUE` → BST remains valid.
- [ ] **2.4** Tree with a single node: search, then delete it → tree becomes empty.
- [ ] **2.5** Degenerate tree (all left children only or all right children only) → inorder is still correct.

## 3. Invalid Input

- [ ] **3.1** Insert a duplicate value → ignored, tree remains unchanged.
- [ ] **3.2** Delete a key that does not exist in the tree → tree remains unchanged.
- [ ] **3.3** Insert negative values, zero, and positive values → all handled correctly, inorder is sorted correctly.

## 4. Exceptions & Special Errors

- [ ] **4.1** Insert into an empty tree → does not throw `NullPointerException`, root is set correctly.
- [ ] **4.2** Delete from an empty tree → does not throw any exception, exits normally.
- [ ] **4.3** Search in an empty tree → returns `false`, does not throw any exception.
- [ ] **4.4** Inorder on an empty tree → returns an empty list `[]`, does not throw any exception.
- [ ] **4.5** Delete a non-existing key from a non-empty tree → does not throw any exception.

## 5. Empty Data Structure

- [ ] **5.1** `isEmpty()` on a newly created tree → `true`.
- [ ] **5.2** `isEmpty()` after inserting at least one node → `false`.
- [ ] **5.3** `isEmpty()` after deleting all nodes → `true`.
- [ ] **5.4** Inorder on an empty tree → `[]` (not `null`).
- [ ] **5.5** Search on an empty tree → `false`.

## 6. Multiple Consecutive Operations

- [ ] **6.1** Insert → Delete → Insert the same key repeatedly → tree state is consistent.
- [ ] **6.2** Mixed operation sequence: insert multiple nodes → delete leaf → delete one-child → delete two-children → inorder is correct at each step.
- [ ] **6.3** Build tree → search for an existing key → delete that key → search again (must return `false`).
- [ ] **6.4** Insert ~10 values → delete half of them → insert a few more → BST property is preserved.

## 7. Expected Output Correctness

- [ ] **7.1** Inorder output is always **ascending**, matching the current set of nodes in the tree.
- [ ] **7.2** Search returns `true`/`false` accurately reflecting the actual tree state.
- [ ] **7.3** Delete removes only the specified node; all other nodes remain unaffected.
- [ ] **7.4** `isEmpty()` correctly reflects whether the tree has elements or not.
- [ ] **7.5** After each operation, verify via inorder that the BST structure is not broken.

---

## 8. Additional Checks

- [ ] **8.1** Insert ascending values (1, 2, 3, ...) → right-skewed tree, inorder is still correct.
- [ ] **8.2** Insert descending values (10, 9, 8, ...) → left-skewed tree, inorder is still correct.
- [ ] **8.3** Delete the root node → the new root is assigned correctly.
