import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
    @Test
    void testConstructor() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        assertEquals("constructor with array of objects doesn't add correctly", list.toString(),
                "[BAB, BEB, BIB, BOB, BUB]");

        SinglyLinkedList<String> list2 = new SinglyLinkedList<>(new String[0]);
        assertEquals("corner case with length 0 array fails", list2.toString(), "[]");
    }

    @Test
    void testAdd() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("HI");
        list.add("BYE");
        assertEquals("add doesn't add the right string", list.toString(), "[HI, BYE]");
    }

    @Test
    void testAddAtIndex() {

    }

    @Test
    void testContains() {

    }

    @Test
    void testGet() {

    }

    @Test
    void testIndexOf() {

    }

    @Test
    void testRemove() {

    }

    @Test
    void testRemoveAtIndex() {

    }

    @Test
    void testSet() {

    }

    @Test
    void testToString() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("HI");
        list.add("BYE");
        assertEquals("toString doesn't return the right string", list.toString(), "[HI, BYE]");
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        assertEquals("corner case with empty linked list", list2.toString(), "[]");
    }
}
