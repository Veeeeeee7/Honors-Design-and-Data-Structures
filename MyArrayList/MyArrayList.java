/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

import java.util.Objects;

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E[] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	// O(1)
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[100];
		this.objectCount = 0;
	}

	/* Constructor with initial capacity */
	// O(1)
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
		this.objectCount = 0;
	}

	/* Return the number of active slots in the array list */
	// O(1)
	public int size() {
		/* ---- YOUR CODE HERE ---- */
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	// O(1)
	public boolean isEmpty() {
		/* ---- YOUR CODE HERE ---- */
		return objectCount == 0;
	}

	/* Get the index-th object in the list. */
	// O(1)
	public E get(int index) {
		/* ---- YOUR CODE HERE ---- */
		if (index < 0 || index >= objectCount) {
			throw new IndexOutOfBoundsException();
		}
		return internalArray[index];
	}

	/* Replace the object at index with obj. returns object that was replaced. */
	// O(1)
	public E set(int index, E obj) {
		/* ---- YOUR CODE HERE ---- */
		if (index < 0 || index >= objectCount) {
			throw new IndexOutOfBoundsException();
		}
		E original = internalArray[index];
		internalArray[index] = obj;
		return original;
	}

	/*
	 * Returns true if this list contains an element equal to obj;
	 * otherwise returns false.
	 */
	// O(n)
	public boolean contains(E obj) {
		/* ---- YOUR CODE HERE ---- */
		for (int i = 0; i < objectCount; i++) {
			if (Objects.equals(internalArray[i], obj)) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	// O(n)
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		/* ---- YOUR CODE HERE ---- */
		if (index < 0 || index > objectCount) {
			throw new IndexOutOfBoundsException();
		}
		if (objectCount == internalArray.length) {
			increaseCapacity(internalArray.length * 2);
		}
		for (int i = objectCount; i > index; i--) {
			internalArray[i] = internalArray[i - 1];
		}
		internalArray[index] = obj;
		objectCount++;
	}

	/* Add an object to the end of the list; returns true */
	// O(1) on average
	// Worst case O(n)
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		/* ---- YOUR CODE HERE ---- */
		if (objectCount == internalArray.length) {
			increaseCapacity(internalArray.length * 2);
		}
		internalArray[objectCount] = obj;
		objectCount++;
		return objectCount == internalArray.length;
	}

	// O(n)
	@SuppressWarnings("unchecked")
	private void increaseCapacity(int newCapacity) {
		E[] newArray = (E[]) new Object[newCapacity];
		for (int i = 0; i < objectCount; i++) {
			newArray[i] = internalArray[i];
		}
		internalArray = newArray;
	}

	/* Remove the object at index and shift. Returns removed object. */
	// O(n)
	public E remove(int index) {
		/* ---- YOUR CODE HERE ---- */
		if (index < 0 || index >= objectCount) {
			throw new IndexOutOfBoundsException();
		}
		E original = internalArray[index];
		for (int i = index; i < objectCount - 1; i++) {
			internalArray[i] = internalArray[i + 1];
		}
		objectCount--;
		return original;
	}

	/*
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present. If the list does not contain the element, it is
	 * unchanged.
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
	 * Returns true if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call).
	 */
	// O(n)
	public boolean remove(E obj) {
		/* ---- YOUR CODE HERE ---- */
		int index = indexOf(obj);
		if (index > -1) {
			remove(index);
		}
		return index > -1;
	}

	// O(n^2)
	public boolean removeLast(E obj) {
		for (int i = objectCount - 1; i >= 0; i--) {
			if (Objects.equals(internalArray[i], obj)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	// O(n^2)
	public boolean removeAll(MyArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			remove(list.get(i));
		}
		return true;
	}

	// O(n)
	public void removeRange(int start, int end) {
		for (int i = start; i < end; i++) {
			internalArray[i] = internalArray[i + (end - start)];
		}
		objectCount -= (end - start);
	}

	// This method will search list for all occurrences of obj and move them to the
	// end
	// of the list without disrupting the order of the other elements.
	// O(n^2)
	@SuppressWarnings("unchecked")
	public void moveToBack(E obj) {
		int count = 0;
		int index = 0;
		E[] list = (E[]) new Object[objectCount];
		for (int i = 0; i < objectCount; i++) {
			if (!Objects.equals(internalArray[i], obj)) {
				list[index] = internalArray[i];
				index++;
			} else {
				count++;
			}
		}

		for (int i = 0; i < count; i++) {
			list[index] = obj;
			index++;
		}
		internalArray = list;
	}

	// O(n)
	public int indexOf(E obj) {
		for (int i = 0; i < objectCount; i++) {
			if (Objects.equals(internalArray[i], obj)) {
				return i;
			}
		}
		return -1;
	}

	// O(n)
	public void clear() {
		for (int i = 0; i < objectCount; i++) {
			internalArray[i] = null;
		}
		objectCount = 0;
	}

	/*
	 * For testing; your string should output as "[X, X, X, X, ...]" where X, X, X,
	 * X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]". If there is one element, "[X]",
	 * etc.
	 * Elements are separated by a comma and a space.
	 */
	// O(n)
	public String toString() {
		/* ---- YOUR CODE HERE ---- */
		StringBuilder str = new StringBuilder();
		str.append("[");
		for (int i = 0; i < objectCount; i++) {
			if (internalArray[i] == null) {
				str.append("null");
				if (i < objectCount - 1) {
					str.append(", ");
				}
			} else {
				str.append(internalArray[i].toString());
				if (i < objectCount - 1) {
					str.append(", ");
				}
			}
		}
		str.append("]");
		return str.toString();
	}

}