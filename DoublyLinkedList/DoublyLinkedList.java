import java.util.LinkedList;

public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		nodeCount = 0;
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		if (values.length == 0) {
			SENTINEL.setNext(SENTINEL);
			SENTINEL.setPrevious(SENTINEL);
			return;
		}

		ListNode2<Nucleotide> current = SENTINEL;
		ListNode2<Nucleotide> previous = SENTINEL;
		for (Nucleotide value : values) {
			ListNode2<Nucleotide> newNode = new ListNode2<Nucleotide>(value);
			current.setNext(newNode);
			current.setPrevious(previous);
			previous = current;
			current = newNode;
		}
		current.setNext(SENTINEL);
		current.setPrevious(previous);
		SENTINEL.setPrevious(current);
		nodeCount += values.length;
	}

	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}

	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}

	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		return nodeCount == 0;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(Nucleotide obj) {
		return indexOf(obj) > -1;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		ListNode2<Nucleotide> current = SENTINEL;
		int index = 0;
		while (current.getNext() != null) {
			current = current.getNext();
			if (current.getValue().equals(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		if (nodeCount == 0) {
			ListNode2<Nucleotide> node = new ListNode2<Nucleotide>(obj);
			SENTINEL.setNext(node);
			SENTINEL.setPrevious(node);
			node.setPrevious(SENTINEL);
			node.setNext(SENTINEL);
			nodeCount++;
			return true;
		}
		ListNode2<Nucleotide> lastNode = SENTINEL.getPrevious();
		ListNode2<Nucleotide> node = new ListNode2<Nucleotide>(obj);
		lastNode.setNext(node);
		SENTINEL.setPrevious(node);
		node.setNext(SENTINEL);
		node.setPrevious(lastNode);
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		if (nodeCount == 0) {
			return false;
		}
		ListNode2<Nucleotide> current = SENTINEL;
		while (current.getNext().getValue() != null) {
			current = current.getNext();
			if (current.getValue().equals(obj)) {
				current.getPrevious().setNext(current.getNext());
				current.getNext().setPrevious(current.getPrevious());
				nodeCount--;
				return true;
			}
		}
		return false;
	}

	// Returns the i-th element.
	public Nucleotide get(int i) {
		if (checkIndex(i)) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> current = SENTINEL.getNext();
		for (int index = 0; index < i; index++) {
			current = current.getNext();
		}
		return current.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		if (checkIndex(i)) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> current = SENTINEL.getNext();
		for (int index = 0; index < i; index++) {
			current = current.getNext();
		}
		Nucleotide previousValue = current.getValue();
		current.setValue(obj);
		return previousValue;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		if (i == nodeCount) {
			add(obj);
			return;
		}
		if (checkIndex(i)) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> current = SENTINEL;
		for (int index = 0; index < i; index++) {
			current = current.getNext();
		}
		ListNode2<Nucleotide> node = new ListNode2<Nucleotide>(obj);
		node.setPrevious(current);
		node.setNext(current.getNext());
		current.getNext().setPrevious(node);
		current.setNext(node);
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (checkIndex(i)) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> current = SENTINEL.getNext();
		for (int index = 0; index < i; index++) {
			current = current.getNext();
		}
		current.getNext().setPrevious(current.getPrevious());
		current.getPrevious().setNext(current.getNext());
		nodeCount--;
		return current.getValue();
	}

	// Returns a string representation of this list exactly like that for
	// MyArrayList.
	public String toString() {
		if (nodeCount == 0) {
			return "[]";
		}
		ListNode2<Nucleotide> current = SENTINEL.getNext();
		StringBuilder sb = new StringBuilder("[");
		while (current.getValue() != null) {
			sb.append(current.getValue().toString() + ", ");
			current = current.getNext();
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return sb.toString();
	}

	public String backwardsToString() {
		if (nodeCount == 0) {
			return "[]";
		}
		ListNode2<Nucleotide> current = SENTINEL.getPrevious();
		StringBuilder sb = new StringBuilder("[");
		while (current.getValue() != null) {
			sb.append(current.getValue().toString() + ", ");
			current = current.getPrevious();
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return sb.toString();
	}

	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		ListNode2<Nucleotide> lastNode = SENTINEL.getPrevious();
		lastNode.setNext(seg.getHead());
		seg.getHead().setPrevious(lastNode);
		seg.getTail().setNext(SENTINEL);
		SENTINEL.setPrevious(seg.getTail());
		nodeCount += seg.size();
	}

	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		ListNode2<Nucleotide> nextNode = nodeBefore;
		for (int i = 0; i < 17; i++) {
			if (nextNode.getNext().equals(SENTINEL)) {
				return;
			}
			nextNode = nextNode.getNext();
		}
		nodeBefore.setNext(nextNode);
		nextNode.setPrevious(nodeBefore);
		nodeCount -= 16;
		return;

	}

	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {
		ListNode2<Nucleotide> left = SENTINEL.getNext();
		ListNode2<Nucleotide> right = SENTINEL.getNext();
		ListNode2<Nucleotide> segHead = seg.getHead();
		while (left.getValue() != null) {
			if (left.getValue().equals(segHead.getValue())) {
				right = left.getNext();
				ListNode2<Nucleotide> nextNode = segHead.getNext();
				while (right.getValue().equals(nextNode.getValue())) {
					right = right.getNext();
					nextNode = nextNode.getNext();
					if (nextNode.getValue() == null) {
						left.getPrevious().setNext(right);
						right.setPrevious(left.getPrevious());
						nodeCount -= seg.size();
						return true;
					}
				}
				left = right.getPrevious();
			}
			left = left.getNext();
		}
		return false;
	}

	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {
		if (nodeCount < 3) {
			return false;
		}
		ListNode2<Nucleotide> lastNode = SENTINEL.getPrevious().getPrevious().getPrevious().getPrevious();
		lastNode.setNext(SENTINEL);
		SENTINEL.setPrevious(lastNode);
		nodeCount -= 3;
		return true;
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {
		ListNode2<Nucleotide> current = SENTINEL.getPrevious();
		while (current.getValue() != null) {
			if (current.getValue().equals(Nucleotide.A)) {
				ListNode2<Nucleotide> nextNode = current.getNext();
				ListNode2<Nucleotide> aNode = new ListNode2<Nucleotide>(Nucleotide.A);
				ListNode2<Nucleotide> cNode = new ListNode2<Nucleotide>(Nucleotide.C);
				current.setValue(Nucleotide.T);
				current.setNext(aNode);
				aNode.setPrevious(current);
				aNode.setNext(cNode);
				cNode.setPrevious(aNode);
				cNode.setNext(nextNode);
				nodeCount += 2;
			}
			current = current.getPrevious();
		}
	}

	private boolean checkIndex(int i) {
		return i < 0 || i >= nodeCount;
	}

}
