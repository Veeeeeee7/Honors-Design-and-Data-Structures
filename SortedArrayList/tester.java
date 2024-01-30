public class tester {
    public static void main(String[] args) {
        SortedArrayList<Integer> s = new SortedArrayList<Integer>();
        s.add(5);
        s.add(6);
        s.add(7);
        s.remove(5);
        s.remove(7);
        System.out.println(s);
    }
}
