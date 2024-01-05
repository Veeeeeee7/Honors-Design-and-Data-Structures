import java.util.LinkedList;

public class MyPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {
    private LinkedList<E> list;

    public MyPQ() {
        list = new LinkedList<E>();
    }

    // Adds obj to the Priority Queue
    public void add(E obj) {
        // if (list.size() == 0) {
        // list.add(obj);
        // return;
        // }
        // for (int i = 0; i < list.size(); i++) {
        // if (obj.compareTo(list.get(i)) > 0) {
        // list.add(i, obj);
        // return;
        // }
        // }
        // list.addLast(obj);

        list.add(obj);
    }

    // Removes and returns the MINIMUM element from the Priority Queue
    public E removeMin() {
        // return list.removeLast();

        int min = Integer.MAX_VALUE;
        E minValue = list.getFirst();
        int index = 0;
        int forIndex = 0;
        for (E object : list) {
            if (object.compareTo(minValue) < min) {
                index = forIndex;
                minValue = object;
                min = object.compareTo(minValue);
            }
            forIndex++;
        }

        return list.remove(index);
    }

    // Returns the MINIMUM element from the Priority Queue without removing it
    public E peek() {
        // return list.getLast();

        int min = Integer.MAX_VALUE;
        E minValue = list.getFirst();
        int index = 0;
        int forIndex = 0;
        for (E object : list) {
            if (object.compareTo(minValue) < min) {
                index = forIndex;
                minValue = object;
                min = object.compareTo(minValue);
            }
            forIndex++;
        }

        return list.get(index);
    }

    // Returns true if the priority queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E object : list) {
            sb.append(object + " ");
        }
        return sb.toString();
    }

}
