import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
    @Test
    void testConstructor() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        assertEquals("constructor with array of objects doesn't add correctly",
                "[BAB, BEB, BIB, BOB, BUB]", list.toString());

        SinglyLinkedList<String> list2 = new SinglyLinkedList<>(new String[0]);
        assertEquals("corner case with length 0 array fails", "[]", list2.toString());
    }

    @Test
    void testAdd() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("HI");
        list.add("BYE");
        assertEquals("add doesn't add the right string", "[HI, BYE]", list.toString());
    }

    @Test
    void testAddAtIndex() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        list.add(2, "EL");
        assertEquals("add doesn't add at the right index", "[BAB, BEB, EL, BIB, BOB, BUB]", list.toString());
        list.add(0, "EL");
        assertEquals("corner case adding to the beginning of the list", "[EL, BAB, BEB, EL, BIB, BOB, BUB]",
                list.toString());
        list.add(list.size(), "EL");
        assertEquals("corner case adding to the end of the list", "[EL, BAB, BEB, EL, BIB, BOB, BUB, EL]",
                list.toString());
        assertEquals("object count", 8, list.size());
        try {
            list.add(-2, "E");
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
        SinglyLinkedList<String> emptyList = new SinglyLinkedList<>();
        emptyList.add(0, "FIRST ENTRY");
        assertEquals("object count", 1, emptyList.size());
        assertEquals("corner case adding to the first index of an empty list", "[FIRST ENTRY]", emptyList.toString());
    }

    @Test
    void testGet() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        assertEquals("does not get the right value", "BEB", list.get(1));
        try {
            list.get(-2);
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
        try {
            list.get(55);
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
    }

    @Test
    void testIndexOf() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        assertEquals("constructor with array of objects doesn't add correctly",
                "[BAB, BEB, BIB, BOB, BUB]", list.toString());

        assertEquals("indexOf can't find the right node", 2, list.indexOf("BIB"));
        assertEquals("indexOf found a node that doesn't exist", -1, list.indexOf(""));
    }

    @Test
    void testRemove() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        list.remove("BOB");
        assertEquals("remove doesn't remove the right object", "[BAB, BEB, BIB, BUB]", list.toString());
        list.remove("BAB");
        assertEquals("corner case removing the first object", "[BEB, BIB, BUB]", list.toString());
        list.remove("BUB");
        assertEquals("corner case remove the second object", "[BEB, BIB]", list.toString());
        assertEquals("corner case removing wrong object", false, list.remove("E"));
        assertEquals("object count", 2, list.size());
    }

    @Test
    void testRemoveAtIndex() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        String value = list.remove(3);
        assertEquals("remove doesn't remove the right object", "[BAB, BEB, BIB, BUB]", list.toString());
        assertEquals("doesnt return the right value", "BOB", value);
        list.remove(0);
        assertEquals("corner case removing the first object", "[BEB, BIB, BUB]", list.toString());
        list.remove(2);
        assertEquals("corner case remove the second object", "[BEB, BIB]", list.toString());
        assertEquals("object count", 2, list.size());
    }

    @Test
    void testSet() {
        String[] l = { "BAB", "BEB", "BIB", "BOB", "BUB" };
        SinglyLinkedList<String> list = new SinglyLinkedList<>(l);
        String value = list.set(2, "BAD");
        assertEquals("doesnt the new value to the right index", "[BAB, BEB, BAD, BOB, BUB]", list.toString());
        assertEquals("doesnt return the right value", "BIB", value);
        list.set(4, "BAD");
        assertEquals("corner case set the last value", "[BAB, BEB, BAD, BOB, BAD]", list.toString());
        list.set(0, "BAD");
        assertEquals("corner case set the first value", "[BAD, BEB, BAD, BOB, BAD]", list.toString());
        try {
            list.set(55, "BAD");
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
    }

    @Test
    void testToString() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("HI");
        list.add("BYE");
        assertEquals("toString doesn't return the right string", "[HI, BYE]", list.toString());
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        assertEquals("corner case with empty linked list", "[]", list2.toString());
    }
}
