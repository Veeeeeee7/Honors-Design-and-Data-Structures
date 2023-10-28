import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
    @Test
    void testAddObj() {
        Nucleotide[] n = { Nucleotide.G, Nucleotide.G, Nucleotide.G, Nucleotide.G };
        DoublyLinkedList list = new DoublyLinkedList(n);
        list.add(Nucleotide.A);
        list.add(Nucleotide.A);
        list.add(Nucleotide.A);
        list.add(Nucleotide.A);
        assertEquals("[G, G, G, G, A, A, A, A]", list.toString());
    }

    @Test
    void testAddAtIndex() {
        Nucleotide[] n = { Nucleotide.G, Nucleotide.G, Nucleotide.G, Nucleotide.G };
        DoublyLinkedList list = new DoublyLinkedList(n);
        list.add(0, Nucleotide.A);
        list.add(2, Nucleotide.A);
        list.add(6, Nucleotide.A);
        list.add(0, Nucleotide.T);
        assertEquals("[T, A, G, A, G, G, G, A]", list.toString());
        assertEquals("[A, G, G, G, A, G, A, T]", list.backwardsToString());
    }

    @Test
    void testAddSegmentToEnd() {

    }

    @Test
    void testContains() {

    }

    @Test
    void testDeleteLastThree() {

    }

    @Test
    void testDeleteSegment() {

    }

    @Test
    void testGet() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(Nucleotide.A);
        list.add(Nucleotide.A);
        list.add(Nucleotide.T);
        assertEquals(Nucleotide.A, list.get(0));
        assertEquals(Nucleotide.T, list.get(2));
    }

    @Test
    void testIndexOf() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(Nucleotide.A);
        list.add(Nucleotide.A);
        list.add(Nucleotide.T);
        assertEquals("[A, A, T]", list.toString());
        assertEquals(0, list.indexOf(Nucleotide.A));
        assertEquals(3, list.size());
        assertEquals(-1, list.indexOf(Nucleotide.G));
    }

    @Test
    void testRemoveObj() {
        Nucleotide[] n = { Nucleotide.G, Nucleotide.T, Nucleotide.G, Nucleotide.G };
        DoublyLinkedList list = new DoublyLinkedList(n);
        list.remove(Nucleotide.G);
        assertTrue(!list.remove(Nucleotide.A));
        assertEquals("[T, G, G]", list.toString());
        list.remove(Nucleotide.G);
        list.remove(Nucleotide.G);
        assertEquals("[T]", list.toString());
        list.remove(Nucleotide.T);
        assertEquals("[]", list.toString());
    }

    @Test
    void testRemoveAtIndex() {
        Nucleotide[] n = { Nucleotide.G, Nucleotide.T, Nucleotide.G, Nucleotide.G };
        DoublyLinkedList list = new DoublyLinkedList(n);
        list.remove(2);
        assertEquals("[G, T, G]", list.toString());
        list.remove(0);
        assertEquals("[T, G]", list.toString());
        list.remove(1);
        list.remove(0);
        assertEquals("[]", list.toString());
    }

    @Test
    void testRemoveCCCCCCCCGGGGGGGG() {

    }

    @Test
    void testReplaceEveryAWithTAC() {

    }

    @Test
    void testSet() {

    }
}
