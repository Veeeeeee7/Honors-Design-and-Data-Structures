public class Tester {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println(list.contains(1));
        System.out.println(list.contains(3));
    }
}
