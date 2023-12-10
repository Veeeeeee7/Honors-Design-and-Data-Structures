import java.util.ArrayDeque;

public class tester {
    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.push(5);
        dq.push(10);
        for (int i : dq) {
            System.out.println(i);
        }
    }
}
