public class tester {
    public static void main(String[] args) {
        HeapPQ<Integer> h = new HeapPQ<>();
        h.add(5);
        // h.add(4);
        h.removeMin();
        h.removeMin();
        System.out.println(h);
    }
}
