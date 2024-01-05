import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        MyPQ<Integer> pq = new MyPQ<Integer>();
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(7);
        sortedList.add(8);
        sortedList.add(9);
        sortedList.add(10);
        sortedList.add(11);
        pq.add(10);
        System.out.println(pq);
        pq.add(6);
        System.out.println(pq);
        pq.add(11);
        System.out.println(pq);
        pq.add(8);
        System.out.println(pq);
        pq.add(9);
        System.out.println(pq);
        pq.add(5);
        System.out.println(pq);
        pq.add(7);
        System.out.println(pq);

        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i) + " " + pq.removeMin());
        }
    }
}
