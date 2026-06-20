package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList();
    }

    /**
     * Helper method dùng Reflection để lấy head.
     */
    private Node getHead(SinglyLinkedList list) throws Exception {
        Field field = SinglyLinkedList.class.getDeclaredField("head");
        field.setAccessible(true);
        return (Node) field.get(list);
    }

    // =========================
    // addFirst()
    // =========================

    @Test
    void testAddFirst_WhenEmpty_ShouldBecomeHead() throws Exception {
        list.addFirst(10);

        Node head = getHead(list);

        assertEquals(10, head.data);
        assertNull(head.next);
    }

    @Test
    void testAddFirst_WhenNotEmpty_ShouldInsertAtFront() throws Exception {
        list.addFirst(10);
        list.addFirst(20);

        Node head = getHead(list);

        assertEquals(20, head.data);
        assertEquals(10, head.next.data);
    }

    @Test
    void testAddFirst_Multiple_ShouldMaintainOrder() throws Exception {
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        Node head = getHead(list);

        assertEquals(30, head.data);
        assertEquals(20, head.next.data);
        assertEquals(10, head.next.next.data);
    }

    // =========================
    // addLast()
    // =========================

    @Test
    void testAddLast_WhenEmpty_ShouldBecomeHead() throws Exception {
        list.addLast(5);

        Node head = getHead(list);

        assertEquals(5, head.data);
        assertNull(head.next);
    }

    @Test
    void testAddLast_WhenNotEmpty_ShouldAppendToEnd() throws Exception {
        list.addLast(10);
        list.addLast(20);

        Node head = getHead(list);

        assertEquals(10, head.data);
        assertEquals(20, head.next.data);
        assertNull(head.next.next);
    }

    // =========================
    // delete()
    // =========================

    @Test
    void testDelete_WhenEmpty_ShouldReturnFalse() {
        assertFalse(list.delete(10));
    }

    @Test
    void testDelete_WhenValueNotFound_ShouldReturnFalse() {
        list.addFirst(10);
        list.addFirst(20);

        assertFalse(list.delete(999));
    }

    @Test
    void testDelete_Head_ShouldUpdateHead() throws Exception {
        list.addFirst(10);
        list.addFirst(20);

        assertTrue(list.delete(20));

        Node head = getHead(list);

        assertEquals(10, head.data);
    }

    @Test
    void testDelete_Middle_ShouldMaintainLinks() throws Exception {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertTrue(list.delete(20));

        Node head = getHead(list);

        assertEquals(10, head.data);
        assertEquals(30, head.next.data);
    }

    @Test
    void testDelete_Tail_ShouldRemoveLastNode() throws Exception {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertTrue(list.delete(30));

        Node head = getHead(list);

        assertEquals(10, head.data);
        assertEquals(20, head.next.data);
        assertNull(head.next.next);
    }

    @Test
    void testDelete_OnlyElement_ShouldBecomeEmpty() {
        list.addFirst(10);

        assertTrue(list.delete(10));
        assertTrue(list.isEmpty());
    }

    @Test
    void testDelete_DuplicateValues_ShouldRemoveOnlyFirstOccurrence() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(10);

        assertTrue(list.delete(10));

        assertFalse(list.search(999));
        assertEquals(2, list.size());
    }

    // =========================
    // search()
    // =========================

    @Test
    void testSearch_WhenEmpty_ShouldReturnFalse() {
        assertFalse(list.search(10));
    }

    @Test
    void testSearch_WhenValueExists_ShouldReturnTrue() {
        list.addLast(10);
        list.addLast(20);

        assertTrue(list.search(20));
    }

    @Test
    void testSearch_WhenValueNotExists_ShouldReturnFalse() {
        list.addLast(10);
        list.addLast(20);

        assertFalse(list.search(999));
    }

    // =========================
    // size()
    // =========================

    @Test
    void testSize_WhenEmpty_ShouldReturnZero() {
        assertEquals(0, list.size());
    }

    @Test
    void testSize_AfterAddingElements_ShouldReturnCorrectCount() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(3, list.size());
    }

    @Test
    void testSize_AfterDeletingElement_ShouldDecrease() {
        list.addLast(10);
        list.addLast(20);

        list.delete(20);

        assertEquals(1, list.size());
    }

    // =========================
    // isEmpty()
    // =========================

    @Test
    void testIsEmpty_NewList_ShouldReturnTrue() {
        assertTrue(list.isEmpty());
    }

    @Test
    void testIsEmpty_AfterAddingElement_ShouldReturnFalse() {
        list.addFirst(10);

        assertFalse(list.isEmpty());
    }

    @Test
    void testIsEmpty_AfterDeletingAllElements_ShouldReturnTrue() {
        list.addFirst(10);

        list.delete(10);

        assertTrue(list.isEmpty());
    }

    // =========================
    // display()
    // =========================

    @Test
    void testDisplay_WhenEmpty_ShouldPrintNull() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        list.display();

        assertEquals("null\r\n", output.toString());
    }

    @Test
    void testDisplay_WithElements_ShouldPrintCorrectFormat() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        list.addLast(10);
        list.addLast(20);

        list.display();

        assertEquals("10 -> 20 -> null\r\n", output.toString());
    }

    // =========================
    // Integration Tests
    // =========================

    @Test
    void testIntegration_AddSearchDelete() {
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);

        assertTrue(list.search(20));

        assertTrue(list.delete(20));

        assertFalse(list.search(20));

        assertEquals(2, list.size());
    }

    @Test
    void testIntegration_BuildAndClearList() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.delete(1);
        list.delete(2);
        list.delete(3);

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
}