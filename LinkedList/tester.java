public class tester {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("HI");
        list.add("HII");
        list.add("HIII");
        list.remove("HI");
        list.remove("HIII");
        System.out.println(list);
    }
}
