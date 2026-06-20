# Singly Linked List - Testing Checklist

**Project:** Custom Singly Linked List (SLL) Implementation  
**Framework:** JUnit 5  
**Methods to Test:** 7 core methods

---

## 1. Methods to Test

| Method   | Signature                  | Description              |
| -------- | -------------------------- | ------------------------ |
| addFirst | `void addFirst(int data)`  | Add element at beginning |
| addLast  | `void addLast(int data)`   | Add element at end       |
| delete   | `boolean delete(int data)` | Remove first occurrence  |
| search   | `boolean search(int data)` | Check if value exists    |
| size     | `int size()`               | Count elements           |
| isEmpty  | `boolean isEmpty()`        | Check if empty           |
| display  | `void display()`           | Print list               |

---

## 2. Test Cases by Method

### addFirst()

- [ ] Add to empty list → verify head updated
- [ ] Add to non-empty list → verify new head
- [ ] Add multiple elements → verify order
- [ ] Add negative/zero/large values → accept all

### addLast()

- [ ] Add to empty list → become head
- [ ] Add to non-empty list → append to tail
- [ ] Add multiple elements → verify tail is null
- [ ] Verify last node.next is always null

### delete()

- [ ] Delete from empty list → return false
- [ ] Delete non-existing value → return false, no change
- [ ] Delete head → update head to next
- [ ] Delete middle → link nodes correctly
- [ ] Delete tail → previous.next becomes null
- [ ] Delete only element → list becomes empty
- [ ] Delete with duplicates → only first removed

### search()

- [ ] Search empty list → false
- [ ] Search existing value → true
- [ ] Search non-existing → false
- [ ] Search at head/middle/tail → all true
- [ ] Search duplicates → return true

### size()

- [ ] Empty list → 0
- [ ] After each add → increment
- [ ] After each delete → decrement
- [ ] Consistency check → size matches actual count

### isEmpty()

- [ ] New list → true
- [ ] After add → false
- [ ] After delete all → true
- [ ] Single element → false

### display()

- [ ] Empty list → show null
- [ ] Single element → show "data -> null"
- [ ] Multiple elements → correct order and format
- [ ] Format: "data -> data -> ... -> null"

---

## 3. Critical Edge Cases

| Edge Case             | Test Action               | Expected Result          |
| --------------------- | ------------------------- | ------------------------ |
| Empty list operations | All methods on empty list | No crash, correct result |
| Single element        | All operations            | Correct behavior         |
| Head deletion         | delete first node         | head = head.next         |
| Duplicate values      | [10,20,10] delete(10)     | [20,10] - only first     |
| Zero/negative values  | add/search 0, -5          | Accepted normally        |
| Extreme integer values | add/search/delete Integer.MAX_VALUE / Integer.MIN_VALUE | Handled correctly, no overflow |

### 3.1 Exception Handling & Safety

| Exception Scenario        | Test Action                         | Expected Result                        |
| ------------------------- | ----------------------------------- | -------------------------------------- |
| Delete from empty list    | `list.delete(5)` on empty list      | Returns `false`, no `NullPointerException` |
| Search in empty list      | `list.search(5)` on empty list      | Returns `false`, no `NullPointerException` |
| Display empty list        | `list.display()` on empty list      | Prints `"null"`, no `NullPointerException` |
| Size on empty list        | `list.size()` on empty list         | Returns `0`, no `NullPointerException` |
| isEmpty on empty list     | `list.isEmpty()` on empty list      | Returns `true`, no `NullPointerException` |
| Add null/invalid data     | If method signature allows          | Handled gracefully or documented as unsupported |
| Add then delete all       | Delete all nodes one by one         | All operations succeed, list returns to empty state safely |
| Rapid add/delete cycling  | Alternate addFirst/delete repeatedly | No memory leak, no stale references, no `NullPointerException` |
| Delete after clearing     | Clear list → delete any value       | Returns `false`, no exception |

---

## 4. State Transitions (Key Scenarios)

```
Empty → addFirst(10) → [10]
        ↓
        addFirst(20) → [20,10]
        ↓
        addLast(5) → [20,10,5]
        ↓
        delete(20) → [10,5]
        ↓
        delete(10) → [5]
        ↓
        delete(5) → Empty
```

---

## 5. Boundary Cases

| Boundary          | Action            | Verify           |
| ----------------- | ----------------- | ---------------- |
| Empty list        | All operations    | Safe, no NPE     |
| Single node       | add/delete/search | Correct          |
| Large numbers     | INT.MAX / MIN   | Handled          |
| Negative values   | add/search -1, -100 | Handled          |
| Zero values       | add/search/delete 0 | Handled          |
| Middle operations | delete(middle)    | Links maintained |
| Rapid cycling     | addFirst + delete 100x | No memory leak, consistent state |

---

## 6. Recommended JUnit 5 Tests (51 minimum)

### addFirst (6 tests)

1. `testAddFirst_WhenEmpty_ShouldBeHead`
2. `testAddFirst_WhenNotEmpty_ShouldUpdateHead`
3. `testAddFirst_Multiple_ShouldMaintainOrder`
4. `testAddFirst_WithDuplicates_ShouldAccept`
5. `testAddFirst_WithNegativeZero_ShouldAccept`
6. `testAddFirst_SizeIncrementsCorrectly`

### addLast (6 tests)

1. `testAddLast_WhenEmpty_ShouldBeHead`
2. `testAddLast_WhenNotEmpty_ShouldAppend`
3. `testAddLast_Multiple_ShouldMaintainOrder`
4. `testAddLast_LastNodeNextIsNull`
5. `testAddLast_WithDuplicates_ShouldAccept`
6. `testAddLast_SizeIncrementsCorrectly`

### delete (8 tests)

1. `testDelete_WhenEmpty_ShouldReturnFalse`
2. `testDelete_WhenNotFound_ShouldReturnFalse`
3. `testDelete_Head_ShouldUpdateHead`
4. `testDelete_Middle_ShouldLinkCorrectly`
5. `testDelete_Tail_ShouldUpdateTail`
6. `testDelete_OnlyElement_ShouldBeEmpty`
7. `testDelete_WithDuplicates_OnlyFirstRemoved`
8. `testDelete_SizeDecrementsCorrectly`

### search (5 tests)

1. `testSearch_WhenEmpty_ShouldReturnFalse`
2. `testSearch_Existing_ShouldReturnTrue`
3. `testSearch_NotExisting_ShouldReturnFalse`
4. `testSearch_Head_ShouldReturnTrue`
5. `testSearch_DoesNotModifyList`

### size (4 tests)

1. `testSize_WhenEmpty_ShouldReturnZero`
2. `testSize_AfterAdd_ShouldIncrement`
3. `testSize_AfterDelete_ShouldDecrement`
4. `testSize_ConsistencyAfterOperations`

### isEmpty (3 tests)

1. `testIsEmpty_WhenNew_ShouldReturnTrue`
2. `testIsEmpty_AfterAdd_ShouldReturnFalse`
3. `testIsEmpty_AfterDeleteAll_ShouldReturnTrue`

### display (3 tests)

1. `testDisplay_WhenEmpty_ShouldPrintNull`
2. `testDisplay_CorrectOrder`
3. `testDisplay_CorrectFormat`

### Exception Safety (6 tests)

1. `testDelete_WhenEmpty_ShouldNotThrowNullPointerException`
2. `testSearch_WhenEmpty_ShouldNotThrowNullPointerException`
3. `testDisplay_WhenEmpty_ShouldNotThrowNullPointerException`
4. `testSize_WhenEmpty_ShouldNotThrowNullPointerException`
5. `testIsEmpty_WhenEmpty_ShouldNotThrowNullPointerException`
6. `testRapidAddDelete_ShouldNotLeakMemoryOrThrowException`

### Integration (4 tests)

1. `testIntegration_AddFirstThenDelete`
2. `testIntegration_AddLastThenSearch`
3. `testIntegration_MixedOperations`
4. `testIntegration_BuildAndClear`

**Total: 51 essential tests**

---

## 7. Key Testing Risks

| Risk                       | Level       | Mitigation                |
| -------------------------- | ----------- | ------------------------- |
| Head not updated in delete | 🔴 CRITICAL | Test all delete scenarios |
| addLast fails on empty     | 🔴 CRITICAL | Test empty list edge case |
| Duplicates handled wrong   | 🟠 HIGH     | Test with [10,20,10]      |
| Search in empty crashes    | 🟠 HIGH     | Test empty list           |
| Size becomes inconsistent  | 🟠 HIGH     | Verify after each op      |
| NullPointerException in empty list | 🔴 CRITICAL | Test all methods on empty list explicitly |
| Memory leak on rapid add/delete | 🟠 HIGH     | Stress test with repeated operations |

---

## 8. Coverage Goals

| Target          | Minimum    |
| --------------- | ---------- |
| Methods tested  | 7/7 = 100% |
| Test cases      | 51+ tests  |
| Line coverage   | 95%+       |
| Branch coverage | 90%+       |

---

## 9. Test Execution Checklist

- [ ] Create `SinglyLinkedListTest.java`
- [ ] Set up @BeforeEach fixture
- [ ] Implement 51 test methods
- [ ] Run tests → all pass
- [ ] Generate coverage report
- [ ] Verify 95%+ line coverage
- [ ] Document results

---

**Status:** Ready for JUnit 5 Implementation  
**Last Updated:** 2026-06-19
