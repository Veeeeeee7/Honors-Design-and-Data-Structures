public class tester {
    public static void main(String[] args) {
        MyBST<Integer> tree = new MyBST<>();
        tree.add(5);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(7);
        System.out.println(tree.contains(8));
    }
}
