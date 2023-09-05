public class Tester {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            list.add(null);
        }
        System.out.println(list);
        System.out.println("Contains 1? " + list.contains(1));
        System.out.println("Contains 11? " + list.contains(11));
        System.out.println("At index 0: " + list.get(0));
        System.out.println("Size: " + list.size());
        list.set(0, 100);

    }
}
