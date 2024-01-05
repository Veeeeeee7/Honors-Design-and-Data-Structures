public class tester {
    public static void main(String[] args) {
        HeapPQ<Integer> h = new HeapPQ<>();
        h.add(5);
        h.add(11);
        h.add(30);
        h.add(15);
        h.add(13);
        h.add(40);
        h.add(50);
        h.add(20);
        h.add(45);
        h.add(21);
        h.add(31);
        // h.add(100);
        h.removeMin();
        // h.print();
    }
}
