public class TestCase_SWT {

    public static TestCase.Node addToHead(TestCase.Node head, int value) {
        TestCase.Node newNode = new TestCase.Node(value);
        newNode.next = head;
        return newNode;
    }

    public static TestCase.Node addToTail(TestCase.Node head, int value) {
        TestCase.Node newNode = new TestCase.Node(value);
        if (head == null) {
            return newNode;
        }
        TestCase.Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    public static TestCase.Node addToIndex(TestCase.Node head, int value, int index) {
        if (index < 0) {
            return head;
        }
        if (index == 0) {
            TestCase.Node newNode = new TestCase.Node(value);
            newNode.next = head;
            return newNode;
        }
        TestCase.Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            if (curr == null) {
                return head;
            }
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }
        TestCase.Node newNode = new TestCase.Node(value);
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    public static TestCase.Node removeAtHead(TestCase.Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public static TestCase.Node removeAtTail(TestCase.Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        TestCase.Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static TestCase.Node removeAtIndex(TestCase.Node head, int index) {
        if (head == null || index < 0) {
            return null;
        }
        if (index == 0) {
            return head.next;
        }
        TestCase.Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            if (curr == null || curr.next == null) {
                return head;
            }
            curr = curr.next;
        }
        if (curr == null || curr.next == null) {
            return head;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static void printLinkedList(TestCase.Node head) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        TestCase.Node curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            if (curr.next != null) {
                System.out.println("->");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}
