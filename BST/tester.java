public class tester {
    public static void main(String[] args) {
        MyBST<Integer> tree = new MyBST<>();
        tree.add(5);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        tree.add(1);
        tree.add(0);
        tree.add(-1);
        tree.add(2);
        tree.remove(2);
        System.out.println(tree);
    }
}
