public class Tester {
    public static void main(String[] args) {
        // Nucleotide[] n = { Nucleotide.T, Nucleotide.T, Nucleotide.T, Nucleotide.A };
        // DoublyLinkedList list = new DoublyLinkedList(n);
        // Nucleotide[] n2 = { Nucleotide.A, Nucleotide.T, Nucleotide.T, Nucleotide.T };
        // Nucleotide[] n3 = new Nucleotide[16];
        // for (int i = 0; i < 16; i++) {
        // n3[i] = Nucleotide.C;
        // }
        // DoublyLinkedList list2 = new DoublyLinkedList(n2);
        // DoublyLinkedList list3 = new DoublyLinkedList(n3);
        // list.addSegmentToEnd(list3);
        // list.addSegmentToEnd(list2);
        // list.removeCCCCCCCCGGGGGGGG(new ListNode2<Nucleotide>(Nucleotide.A));
        // list.deleteLastThree();

        Nucleotide[] n = { Nucleotide.T, Nucleotide.A, Nucleotide.A, Nucleotide.A };
        DoublyLinkedList list = new DoublyLinkedList(n);
        Nucleotide[] n2 = { Nucleotide.T, Nucleotide.A, Nucleotide.C };
        DoublyLinkedList list2 = new DoublyLinkedList(n2);
        list.replaceEveryAWithTAC();
        System.out.println(list);
        list.deleteSegment(list2);
        System.out.println(list);
    }
}
