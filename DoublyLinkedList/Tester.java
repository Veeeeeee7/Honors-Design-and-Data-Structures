public class Tester {
    public static void main(String[] args) {
        ListNode<Integer> a = new ListNode<>(5);
        ListNode<Integer> b = new ListNode<>(3, a);
        ListNode<Integer> c = new ListNode<>(7, b);
        ListNode<Integer> d = new ListNode<>(1, c);
        a.setNext(c);
        System.out.println(LinkedListOps.hasLoop(d));
    }
}
