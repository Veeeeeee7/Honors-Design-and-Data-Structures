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
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[100];
		this.objectCount = 0;
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
		this.objectCount = 0;
	}

	/* Return the number of active slots in the array list */
	public int size() {
		/* ---- YOUR CODE HERE ---- */
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		/* ---- YOUR CODE HERE ---- */
		return objectCount == 0;
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		/* ---- YOUR CODE HERE ---- */
		return internalArray[index];
	}

	/* Replace the object at index with obj. returns object that was replaced. */
	public E set(int index, E obj) {
		/* ---- YOUR CODE HERE ---- */
		E original = internalArray[index];
		internalArray[index] = obj;
		return original;
	}

	/*
	 * Returns true if this list contains an element equal to obj;
	 * otherwise returns false.
	 */
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
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		/* ---- YOUR CODE HERE ---- */
		for (int i = objectCount; i > index; i--) {
			internalArray[i] = internalArray[i - 1];
		}
		internalArray[index] = obj;
		objectCount++;
	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		/* ---- YOUR CODE HERE ---- */
		internalArray[objectCount] = obj;
		objectCount++;
		return objectCount == internalArray.length;
	}

	/* Remove the object at index and shift. Returns removed object. */
	public E remove(int index) {
		/* ---- YOUR CODE HERE ---- */
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
	public boolean remove(E obj) {
		/* ---- YOUR CODE HERE ---- */
		int index = indexOf(obj);
		remove(index);
		return index > -1;
	}

	// // This method will search list for all occurrences of obj and move them to
	// the
	// // end
	// // of the list without disrupting the order of the other elements.
	// public void moveToBack(E obj) {

	// }

	public int indexOf(E obj) {
		for (int i = 0; i < objectCount; i++) {
			if (Objects.equals(internalArray[i], obj)) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * For testing; your string should output as "[X, X, X, X, ...]" where X, X, X,
	 * X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]". If there is one element, "[X]",
	 * etc.
	 * Elements are separated by a comma and a space.
	 */
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