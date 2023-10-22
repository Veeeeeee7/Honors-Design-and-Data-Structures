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
		nodeCount += values.length;
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
		ListNode<E> currentNode = head;
		if (head.getValue().equals(obj)) {
			head = head.getNext();
			nodeCount--;
			return true;
		}
		while (currentNode.getNext() != null) {
			if (currentNode.getNext().getValue().equals(obj)) {
				ListNode<E> nextNode = currentNode.getNext();
				currentNode.setNext(nextNode.getNext());
				nodeCount--;
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}

	// Returns the i-th element.
	public E get(int i) {
		if (checkBadIndex(i)) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> currentNode = head;
		while (i > 0) {
			currentNode = currentNode.getNext();
			i--;
		}
		return currentNode.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, E obj) {
		E oldValue = get(i);
		remove(oldValue);
		add(i, obj);
		return oldValue;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
		if (checkBadIndex(i)) {
			throw new IndexOutOfBoundsException();

		}
		if (i == 0) {
			ListNode<E> newNode = new ListNode<>(obj);
			newNode.setNext(head);
			head = newNode;
			nodeCount++;
			return;
		}
		ListNode<E> currentNode = head;
		for (int index = 1; index < i; index++) {
			currentNode = currentNode.getNext();
		}
		ListNode<E> currentNext = currentNode.getNext();
		currentNode.setNext(new ListNode<>(obj));
		currentNode.getNext().setNext(currentNext);
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if (checkBadIndex(i)) {
			throw new IndexOutOfBoundsException();

		}
		if (i == 0) {
			ListNode<E> oldHead = head;
			head = head.getNext();
			nodeCount--;
			return oldHead.getValue();
		}
		ListNode<E> currentNode = head;
		for (int index = 0; index < i - 1; index++) {
			currentNode = currentNode.getNext();
		}
		ListNode<E> nextNode = currentNode.getNext();
		currentNode.setNext(nextNode.getNext());
		nodeCount--;
		return nextNode.getValue();
	}

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

	private boolean checkBadIndex(int index) {
		return index < 0 || index > nodeCount;
	}
}
