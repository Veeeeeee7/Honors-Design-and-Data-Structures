public class tester {
    public static void main(String[] args) {
        // MyBST<Integer> tree = new MyBST<>();
        // tree.add(5);
        // tree.add(7);
        // tree.add(6);
        // tree.add(8);
        // tree.add(1);
        // tree.add(0);
        // tree.add(-1);
        // tree.add(2);
        // tree.remove(5);
        // System.out.println(tree);

        MyBST<String> tree2 = new MyBST<>();
        System.out.println(tree2.add("BOB"));
        System.out.println(tree2.add("COD"));
        System.out.println(tree2.add("DOG"));
        System.out.println(tree2.add("APPLE"));
        System.out.println(tree2.add("ADAM"));
        System.out.println(tree2.add("ADAM"));

        tree2.remove("ADAM");
        System.out.println(tree2);
    }
}
