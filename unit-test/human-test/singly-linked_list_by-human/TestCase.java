
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class TestCase {

    private TestCase.Node head;

    @BeforeEach
    void setUp() {
        head = null;
    }

    @Test
    void testAddToHead_WhenEmpty_ShouldBeHead() {
        head = TestCase_SWT.addToHead(head, 10);
        assertNotNull(head);
        assertEquals(10, head.value);
        assertNull(head.next);
    }

    @Test
    void testAddToHead_WhenNotEmpty_ShouldUpdateHead() {
        head = TestCase_SWT.addToHead(head, 10);
        head = TestCase_SWT.addToHead(head, 20);
        assertEquals(20, head.value);
        assertEquals(10, head.next.value);
    }

    @Test
    void testAddToHead_Multiple_ShouldMaintainOrder() {
        head = TestCase_SWT.addToHead(head, 10);
        head = TestCase_SWT.addToHead(head, 20);
        head = TestCase_SWT.addToHead(head, 30);
        assertEquals(30, head.value);
        assertEquals(20, head.next.value);
        assertEquals(10, head.next.next.value);
    }

    @Test
    void testAddToHead_WithDuplicates_ShouldAccept() {
        head = TestCase_SWT.addToHead(head, 10);
        head = TestCase_SWT.addToHead(head, 10);
        assertEquals(10, head.value);
        assertEquals(10, head.next.value);
    }

    @Test
    void testAddToHead_WithNegativeZero_ShouldAccept() {
        head = TestCase_SWT.addToHead(head, 0);
        head = TestCase_SWT.addToHead(head, -5);
        assertEquals(-5, head.value);
        assertEquals(0, head.next.value);
    }

    @Test
    void testAddToTail_WhenEmpty_ShouldBeHead() {
        head = TestCase_SWT.addToTail(head, 5);
        assertNotNull(head);
        assertEquals(5, head.value);
        assertNull(head.next);
    }

    @Test
    void testAddToTail_WhenNotEmpty_ShouldAppend() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        assertEquals(10, head.value);
        assertEquals(20, head.next.value);
    }

    @Test
    void testAddToTail_Multiple_ShouldMaintainOrder() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.addToTail(head, 30);
        assertEquals(10, head.value);
        assertEquals(20, head.next.value);
        assertEquals(30, head.next.next.value);
    }

    @Test
    void testAddToTail_LastNodeNextIsNull() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        assertNull(head.next.next);
    }

    @Test
    void testAddToTail_WithDuplicates_ShouldAccept() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 10);
        assertEquals(10, head.value);
        assertEquals(10, head.next.value);
    }

    @Test
    void testAddToIndex_AtZeroWhenEmpty() {
        head = TestCase_SWT.addToIndex(head, 10, 0);
        assertEquals(10, head.value);
    }

    @Test
    void testAddToIndex_AtZeroWhenNotEmpty() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToIndex(head, 20, 0);
        assertEquals(20, head.value);
        assertEquals(10, head.next.value);
    }

    @Test
    void testAddToIndex_Middle_ShouldLinkCorrectly() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 30);
        head = TestCase_SWT.addToIndex(head, 20, 1);
        assertEquals(10, head.value);
        assertEquals(20, head.next.value);
        assertEquals(30, head.next.next.value);
    }

    @Test
    void testAddToIndex_InvalidIndex_ShouldNotChange() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToIndex(head, 20, 5);
        assertEquals(10, head.value);
        assertNull(head.next);
    }

    @Test
    void testRemoveAtHead_WhenEmpty_ShouldReturnNull() {
        head = TestCase_SWT.removeAtHead(head);
        assertNull(head);
    }

    @Test
    void testRemoveAtHead_OnlyElement_ShouldBeEmpty() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.removeAtHead(head);
        assertNull(head);
    }

    @Test
    void testRemoveAtHead_Multiple_ShouldUpdateHead() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.removeAtHead(head);
        assertEquals(20, head.value);
    }

    @Test
    void testRemoveAtTail_WhenEmpty_ShouldReturnNull() {
        head = TestCase_SWT.removeAtTail(head);
        assertNull(head);
    }

    @Test
    void testRemoveAtTail_OnlyElement_ShouldBeEmpty() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.removeAtTail(head);
        assertNull(head);
    }

    @Test
    void testRemoveAtTail_Multiple_ShouldUpdateTail() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.addToTail(head, 30);
        head = TestCase_SWT.removeAtTail(head);
        assertEquals(10, head.value);
        assertEquals(20, head.next.value);
        assertNull(head.next.next);
    }

    @Test
    void testRemoveAtIndex_WhenEmpty_ShouldReturnNull() {
        head = TestCase_SWT.removeAtIndex(head, 0);
        assertNull(head);
    }

    @Test
    void testRemoveAtIndex_NegativeIndex_ShouldReturnNull() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.removeAtIndex(head, -1);
        assertNull(head);
    }

    @Test
    void testRemoveAtIndex_Zero_ShouldRemoveHead() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.removeAtIndex(head, 0);
        assertEquals(20, head.value);
    }

    @Test
    void testRemoveAtIndex_Middle_ShouldLinkCorrectly() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.addToTail(head, 30);
        head = TestCase_SWT.removeAtIndex(head, 1);
        assertEquals(10, head.value);
        assertEquals(30, head.next.value);
    }

    @Test
    void testRemoveAtIndex_Tail_ShouldUpdateTail() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.removeAtIndex(head, 1);
        assertEquals(10, head.value);
        assertNull(head.next);
    }

    @Test
    void testRemoveAtIndex_NotFound_ShouldNotChange() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.removeAtIndex(head, 5);
        assertEquals(10, head.value);
        assertEquals(20, head.next.value);
    }

    @Test
    void testPrintLinkedList_WhenEmpty_ShouldPrintEmptyMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        TestCase_SWT.printLinkedList(head);
        assertEquals("List is empty!\r\n", output.toString());
    }

    @Test
    void testPrintLinkedList_SingleElement_ShouldPrintCorrectFormat() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        head = TestCase_SWT.addToTail(head, 10);
        TestCase_SWT.printLinkedList(head);
        String expected = "10\r\n\r\n";
        assertEquals(expected, output.toString());
    }

    @Test
    void testPrintLinkedList_MultipleElements_ShouldPrintCorrectFormat() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        TestCase_SWT.printLinkedList(head);
        String expected = "10\r\n->\r\n20\r\n\r\n";
        assertEquals(expected, output.toString());
    }

    @Test
    void testIntegration_AddFirstThenDelete() {
        head = TestCase_SWT.addToHead(head, 10);
        head = TestCase_SWT.addToHead(head, 20);
        head = TestCase_SWT.removeAtHead(head);
        assertEquals(10, head.value);
        assertNull(head.next);
    }

    @Test
    void testIntegration_AddTailThenRemoveTail() {
        head = TestCase_SWT.addToTail(head, 10);
        head = TestCase_SWT.addToTail(head, 20);
        head = TestCase_SWT.removeAtTail(head);
        assertEquals(10, head.value);
        assertNull(head.next);
    }

    @Test
    void testIntegration_MixedOperations() {
        head = TestCase_SWT.addToHead(head, 10);
        head = TestCase_SWT.addToTail(head, 30);
        head = TestCase_SWT.addToIndex(head, 20, 1);
        head = TestCase_SWT.removeAtIndex(head, 1);
        assertEquals(10, head.value);
        assertEquals(30, head.next.value);
    }

    @Test
    void testIntegration_BuildAndClear() {
        head = TestCase_SWT.addToTail(head, 1);
        head = TestCase_SWT.addToTail(head, 2);
        head = TestCase_SWT.removeAtHead(head);
        head = TestCase_SWT.removeAtTail(head);
        assertNull(head);
    }
}