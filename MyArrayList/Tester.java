public class Tester {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            list.add(null);
        }
        System.out.println("Contains 1? " + list.contains(1));
        System.out.println("Contains 11? " + list.contains(11));
        System.out.println("At index 1: " + list.get(1));
        System.out.println("Size: " + list.size());
        list.set(1, 100);
        list.remove(3);
        list.remove(new Integer(3));
        System.out.println(list);
        list.remove(null);
        System.out.println(list);
        list.add(1, 200);
        System.out.println(list);

    }
}
