import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        String[] l3 = { "BAB" };
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>(l3);
        assertEquals("[BAB]", list3.toString());
        String[] l4 = { "BAB", "BAB" };
        SinglyLinkedList<String> list4 = new SinglyLinkedList<>(l4);
        assertEquals("[BAB, BAB]", list4.toString());
    }

    @Test
    void testAdd() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("HI");
        list.add("BYE");
        assertEquals("add doesn't add the right string", "[HI, BYE]", list.toString());
        String[] l = { "EE" };
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>(l);
        list2.add("HI");
        assertEquals(2, list2.size());
        assertEquals("[EE, HI]", list2.toString());
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.add(null);
        assertEquals("[null]", list3.toString());
        SinglyLinkedList<String> list4 = new SinglyLinkedList<>();
        list4.add("FIRST");
        assertEquals("[FIRST]", list4.toString());
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
        list.add(list.size() - 1, "MINUS 1");
        assertEquals("corner case adding to the 2nd to end of the list",
                "[EL, BAB, BEB, EL, BIB, BOB, BUB, MINUS 1, EL]",
                list.toString());
        try {
            list.add(-1, "E");
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
        assertEquals(9, list.size());
        try {
            list.add(10, "E");
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
        SinglyLinkedList<String> emptyList = new SinglyLinkedList<>();
        emptyList.add(0, "FIRST ENTRY");
        assertEquals("object count", 1, emptyList.size());
        assertEquals("corner case adding to the first index of an empty list", "[FIRST ENTRY]", emptyList.toString());
        emptyList.add(1, "SECOND ENTRY");
        assertEquals("adding to the end index", "[FIRST ENTRY, SECOND ENTRY]", emptyList.toString());
        emptyList.add(0, "NEW FIRST ENTRY");
        assertEquals("adding to the end index", "[NEW FIRST ENTRY, FIRST ENTRY, SECOND ENTRY]", emptyList.toString());
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.add("A");
        list3.add("B");
        list3.add(0, null);
        assertEquals("[null, A, B]", list3.toString());
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
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        try {
            list2.get(0);
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
        list2.add("BAB");
        list2.add("BEB");
        list2.add("BIB");
        list2.add("BOB");
        list2.add("BUB");
        assertEquals("does not get the right value", "BEB", list2.get(1));
        try {
            list2.get(-2);
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
        try {
            list2.get(55);
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.add("A");
        list3.add(null);
        list3.add("B");
        assertEquals(list3.get(1), null);
        try {
            list3.get(3);
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
        assertEquals(0, list.indexOf("BAB"));
        assertEquals(4, list.indexOf("BUB"));
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        list2.add("BAB");
        list2.add("BEB");
        list2.add("BIB");
        list2.add("BOB");
        list2.add("BUB");
        assertEquals("indexOf can't find the right node", 2, list2.indexOf("BIB"));
        assertEquals("indexOf found a node that doesn't exist", -1, list2.indexOf(""));
        assertEquals(0, list2.indexOf("BAB"));
        assertEquals(4, list2.indexOf("BUB"));
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.add("HI");
        assertEquals(0, list3.indexOf("HI"));
        SinglyLinkedList<String> list4 = new SinglyLinkedList<>();
        list4.add("A");
        list4.add(null);
        list4.add("B");

        assertEquals(1, list4.indexOf(null));
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
        list.remove("BIB");
        assertEquals("[BEB]", list.toString());
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        assertTrue("remove returns false when empty list", !list2.remove("BOB"));
        list2.add("BOB");
        list2.add("HI");
        list2.add("BOB");
        list2.remove("BOB");
        assertEquals("removing first object", "[HI, BOB]", list2.toString());
        list2.remove("BOB");
        assertEquals("removing last object", "[HI]", list2.toString());
        list2.remove("HI");
        assertEquals("removing last object", "[]", list2.toString());
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.add("A");
        list3.add(null);
        list3.add("B");
        list3.remove(null);
        assertEquals("[A, B]", list3.toString());
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
        list.remove(1);
        assertEquals("removing last object", "[BEB]", list.toString());
        list.remove(0);
        assertEquals("removing the only object", "[]", list.toString());
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.add("A");
        list3.add(null);
        list3.add("B");
        list3.remove(1);
        assertEquals("[A, B]", list3.toString());
        try {
            list3.remove(2);
        } catch (Exception e) {
            assertEquals("not the right exception is thrown", e.toString(), "java.lang.IndexOutOfBoundsException");
        }
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
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        list2.set(0, "BOB");
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.add("A");
        list3.add(null);
        list3.add("B");
        assertEquals(list3.set(0, null), "A");
        assertEquals(list3.set(1, "A"), null);
        assertEquals("[null, A, B]", list3.toString());
        try {
            list3.get(3);
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
