// Implements a singly-linked list.

public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(E[] values) {
		if (values.length == 0) {
			return;
		}
		head = new ListNode<>(values[0]);
		ListNode<E> currentNode = head;
		for (int i = 1; i < values.length - 1; i++) {
			currentNode.setNext(new ListNode<>(values[i]));
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(new ListNode<>(values[values.length - 1]));
		tail = currentNode.getNext();
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		return nodeCount <= 0;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		return indexOf(obj) > -1;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		ListNode<E> currentNode = head;
		int index = 0;
		while (currentNode != null) {
			if (currentNode.getValue().equals(obj)) {
				return index;
			}
			currentNode = currentNode.getNext();
			index++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> currentNode = new ListNode<>(obj);
		if (head == null) {
			head = currentNode;
			tail = currentNode;
		}

		tail.setNext(currentNode);
		tail = currentNode;
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		int index = indexOf(obj);
		if (index < 0) {
			return false;
		}

		return true;
	}

	// Returns the i-th element.
	// public E get(int i) {

	// }

	// // Replaces the i-th element with obj and returns the old value.
	// public E set(int i, E obj) {
	// }

	// // Inserts obj to become the i-th element. Increments the size
	// // of the list by one.
	// public void add(int i, E obj) {
	// }

	// // Removes the i-th element and returns its value.
	// // Decrements the size of the list by one.
	// public E remove(int i) {

	// }

	// Returns a string representation of this list exactly like that for
	// MyArrayList.
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		ListNode<E> node = head;
		while (node != null) {
			sb.append(node.getValue().toString() + ", ");
			node = node.getNext();
		}
		if (sb.length() > 1) {
			sb.delete(sb.length() - 2, sb.length());
		}
		sb.append("]");
		return sb.toString();
	}

}
