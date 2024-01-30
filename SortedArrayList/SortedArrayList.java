import java.util.ArrayList;
import java.util.Collections;

public class SortedArrayList<E extends Comparable<E>> {

	private ArrayList<E> list;

	public SortedArrayList() {
		list = new ArrayList<E>();
	}

	public int size() {
		return list.size();
	}

	public boolean contains(E obj) {
		return Collections.binarySearch(list, obj) >= 0;
	}

	// May not contain more than one of the same object
	public boolean add(E obj) {
		int index = -Collections.binarySearch(list, obj);
		if (index < 0) {
			return false;
		}
		list.add(index - 1, obj);
		return true;
	}

	public boolean remove(E obj) {
		int index = Collections.binarySearch(list, obj);
		if (index < 0) {
			return false;
		}
		list.remove(index);
		return true;
	}

	public E min() {
		return list.get(0);
	}

	public E max() {
		return list.get(list.size() - 1);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Object o : list) {
			sb.append(o.toString() + "\n");
		}
		return sb.toString();
	}
}
