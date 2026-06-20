# Checklist for Basic Binary Search Tree

## 1. Node Class (`Node.java`)

- [ ] **1.1** Class is declared as `public` with proper fields:
  - `int key` — stores the node's value.
  - `Node left` — reference to the left child.
  - `Node right` — reference to the right child.
- [ ] **1.2** Constructor `Node(int item)` correctly initializes:
  - `key = item`
  - `left = right = null`

---

## 2. BinarySearchTree Class (`BinarySearchTree.java`)

### 2.1 Fields & Constructor

- [ ] **2.1.1** Field `Node root` is declared to hold the tree's root node.
- [ ] **2.1.2** Constructor `BinarySearchTree()` initializes `root = null` (empty tree).

### 2.2 isEmpty

- [ ] **2.2.1** Method `isEmpty()` returns `true` when `root == null`.
- [ ] **2.2.2** Method `isEmpty()` returns `false` after at least one node is inserted.

### 2.3 Insert

- [ ] **2.3.1** Method `insert(int key)` is public and delegates to `insertRec(root, key)`.
- [ ] **2.3.2** `insertRec` handles the base case: if `root == null`, creates a new `Node(key)` and returns it.
- [ ] **2.3.3** If `key < root.key`, the method recurses into the left subtree.
- [ ] **2.3.4** If `key > root.key`, the method recurses into the right subtree.
- [ ] **2.3.5** If `key == root.key`, the duplicate is **ignored** (not inserted).
- [ ] **2.3.6** After insertion, the tree maintains BST property: all left descendants < node < all right descendants.

### 2.4 Search

- [ ] **2.4.1** Method `search(int key)` returns `true` if the key exists, `false` otherwise.
- [ ] **2.4.2** `searchRec` base case: returns `null` when `root == null` (key not found).
- [ ] **2.4.3** `searchRec` base case: returns the node when `root.key == key`.
- [ ] **2.4.4** If `key < root.key`, search recurses into the left subtree.
- [ ] **2.4.5** If `key > root.key`, search recurses into the right subtree.

### 2.5 Delete

- [ ] **2.5.1** Method `delete(int key)` is public and delegates to `deleteRec(root, key)`.
- [ ] **2.5.2** Base case: if `root == null`, returns `null` (key not found, no change).
- [ ] **2.5.3** If `key < root.key`, recurse into the left subtree.
- [ ] **2.5.4** If `key > root.key`, recurse into the right subtree.
- [ ] **2.5.5** **Case 1 – Leaf node (no children):** If the target node has no left and no right child, it is removed by returning `null`.
- [ ] **2.5.6** **Case 2 – One child:** If the target node has only a left child, the left child replaces it. If it has only a right child, the right child replaces it.
- [ ] **2.5.7** **Case 3 – Two children:** Finds the **in-order successor** (minimum value in the right subtree) via `minValue()`, copies its key to the target node, then recursively deletes the in-order successor from the right subtree.
- [ ] **2.5.8** `minValue(Node root)` correctly finds the minimum value by traversing the leftmost path.
- [ ] **2.5.9** After deletion, BST property is preserved.

### 2.6 In-order Traversal

- [ ] **2.6.1** Method `inorder()` returns a `List<Integer>`.
- [ ] **2.6.2** `inorderRec` traverses in **Left → Root → Right** order.
- [ ] **2.6.3** For an empty tree, `inorder()` returns an empty list (not null).
- [ ] **2.6.4** The returned list is sorted in **ascending order** (BST property ensures this).

---

## 3. Main Class (`Main.java`) – Test Scenarios

- [ ] **3.1** Creates a `BinarySearchTree` instance (`bst`).
- [ ] **3.2** Verifies `isEmpty()` returns `true` for a newly created tree.
- [ ] **3.3** Inserts the following keys: `50, 30, 20, 40, 70, 60, 80`.
- [ ] **3.4** Calls `inorder()` and prints the result — expected output: `[20, 30, 40, 50, 60, 70, 80]`.
- [ ] **3.5** Searches for key `40` using `search(40)` — expected: `true`.
- [ ] **3.6** Deletes node `20` (leaf node case).
- [ ] **3.7** Calls `inorder()` after deletion — expected output: `[30, 40, 50, 60, 70, 80]`.
- [ ] **3.8** _(Suggested additional test)_ Delete a node with one child.
- [ ] **3.9** _(Suggested additional test)_ Delete a node with two children (e.g., `50`).
- [ ] **3.10** _(Suggested additional test)_ Search for a non-existent key — expected: `false`.
- [ ] **3.11** _(Suggested additional test)_ Insert a duplicate value and verify it is ignored.

---

## 4. Edge Cases & Robustness

- [ ] **4.1** Insert into an empty tree works correctly (root becomes the new node).
- [ ] **4.2** Delete from an empty tree does not throw an exception.
- [ ] **4.3** Delete a key that does not exist in the tree does not modify the tree.
- [ ] **4.4** Search in an empty tree returns `false`.
- [ ] **4.5** In-order traversal of an empty tree returns `[]`.
- [ ] **4.6** Tree with a single node: insert, search, delete all work correctly.
- [ ] **4.7** Tree with only left children (degenerate/skewed left): insert, search, delete, inorder all work.
- [ ] **4.8** Tree with only right children (degenerate/skewed right): insert, search, delete, inorder all work.

### 4.2 Extreme & Invalid Input Values

- [ ] **4.9** Insert `Integer.MAX_VALUE` and `Integer.MIN_VALUE` — both are stored and retrieved correctly.
- [ ] **4.10** Search for `Integer.MAX_VALUE` / `Integer.MIN_VALUE` returns correct result.
- [ ] **4.11** Delete `Integer.MAX_VALUE` / `Integer.MIN_VALUE` preserves BST property.
- [ ] **4.12** Negative values are inserted, searched, deleted, and appear in correct sorted order during inorder traversal.
- [ ] **4.13** Mix of negative, zero, and positive values maintains correct BST property and inorder sort order.

### 4.3 Exception Handling & Safety

- [ ] **4.14** Calling `inorder()` on an empty tree returns an empty list — never throws `NullPointerException`.
- [ ] **4.15** Calling `isEmpty()` on an empty tree returns `true` — never throws `NullPointerException`.
- [ ] **4.16** Calling `search(int key)` on an empty tree returns `false` — never throws `NullPointerException`.
- [ ] **4.17** Calling `delete(int key)` on an empty tree returns without throwing any exception.
- [ ] **4.18** Calling `insert(int key)` on an empty tree initializes root correctly — no `NullPointerException`.
- [ ] **4.19** Deleting a non-existent key from a non-empty tree does not modify the tree and does not throw an exception.
- [ ] **4.20** Searching for a key after all nodes have been deleted returns `false` without throwing any exception.

---

## 5. Integration & Mixed Operations

- [ ] **5.1** Insert multiple nodes → delete some → insert again → verify BST property and inorder output.
- [ ] **5.2** Build tree → search for existing key → delete that key → search again (expect `false`).
- [ ] **5.3** Perform a sequence: insert → insert → delete leaf → delete one-child → delete two-children → verify inorder at each step.
- [ ] **5.4** Chain operations without re-initializing: each operation on the persistent tree yields correct state.
- [ ] **5.5** Stress sequence: insert 20 random values → delete 10 (mix of leaf, one-child, two-child) → insert 5 more → verify BST property holds throughout.
- [ ] **5.6** Rapid alternating insert/delete of the same key: insert `42` → delete `42` → insert `42` → delete `42` → tree state is consistent.

---

## 6. Recommended JUnit Tests (35+ minimum)

### 6.1 Node & Constructor (2 tests)

1. `testNodeConstructor_ShouldInitializeKeyAndNullChildren`
2. `testBSTConstructor_ShouldInitializeRootToNull`

### 6.2 isEmpty (3 tests)

3. `testIsEmpty_WhenTreeEmpty_ShouldReturnTrue`
4. `testIsEmpty_AfterInsert_ShouldReturnFalse`
5. `testIsEmpty_AfterDeleteAllNodes_ShouldReturnTrue`

### 6.3 Insert (6 tests)

6. `testInsert_IntoEmptyTree_ShouldSetRoot`
7. `testInsert_MultipleValues_ShouldMaintainBSTProperty`
8. `testInsert_DuplicateValue_ShouldBeIgnored`
9. `testInsert_NegativeValues_ShouldBeStoredCorrectly`
10. `testInsert_ExtremeValues_MaxAndMinInteger_ShouldWork`
11. `testInsert_MixedNegativeZeroPositive_ShouldSortCorrectly`

### 6.4 Search (5 tests)

12. `testSearch_ExistingKey_ShouldReturnTrue`
13. `testSearch_NonExistingKey_ShouldReturnFalse`
14. `testSearch_InEmptyTree_ShouldReturnFalse`
15. `testSearch_AfterInsertAndDelete_ShouldReflectCurrentState`
16. `testSearch_ExtremeValues_ShouldFindMaxAndMinInteger`

### 6.5 Delete (8 tests)

17. `testDelete_LeafNode_ShouldRemoveAndPreserveBST`
18. `testDelete_NodeWithOneChild_ShouldReplaceWithChild`
19. `testDelete_NodeWithTwoChildren_ShouldReplaceWithInorderSuccessor`
20. `testDelete_RootNode_TwoChildren_ShouldUpdateRoot`
21. `testDelete_FromEmptyTree_ShouldNotThrowException`
22. `testDelete_NonExistentKey_ShouldNotModifyTree`
23. `testDelete_SingleNodeTree_ShouldBecomeEmpty`
24. `testDelete_AllNodesOneByOne_ShouldEmptyTree`

### 6.6 Inorder Traversal (4 tests)

25. `testInorder_EmptyTree_ShouldReturnEmptyList`
26. `testInorder_AfterInsert_ShouldReturnSortedList`
27. `testInorder_AfterDelete_ShouldReflectRemainingNodes`
28. `testInorder_SkewedTree_ShouldStillReturnSorted`

### 6.7 Integration (7 tests)

29. `testIntegration_InsertSearchDelete_SingleSequence`
30. `testIntegration_BuildTreeDeleteMixedCases_VerifyEachStep`
31. `testIntegration_InsertDeleteSameKeyRepeatedly`
32. `testIntegration_ComplexSequence_Insert20Delete10Insert5`
33. `testIntegration_StressEmptyTreeOperations_NoExceptions`
34. `testIntegration_MultipleOperations_ConsistentState`
35. `testIntegration_NegativeAndPositiveMixed_AlwaysSortedInorder`

**Total: 35 essential tests**

---

## 7. Coverage Goals

| Target          | Minimum    |
| --------------- | ---------- |
| Methods tested  | 5/5 = 100% |
| Test cases      | 35+ tests  |
| Line coverage   | 95%+       |
| Branch coverage | 90%+       |

---

## 8. Code Quality & Documentation

- [ ] **8.1** All classes and public methods have Javadoc or inline comments explaining their purpose.
- [ ] **8.2** Variable names follow Java naming conventions (camelCase).
- [ ] **8.3** Proper encapsulation: helper methods (`insertRec`, `searchRec`, `deleteRec`, `inorderRec`, `minValue`) are `private`.
- [ ] **8.4** No unused imports or dead code.
- [ ] **8.5** The `ReadMe.md` file documents the project structure and usage instructions.
