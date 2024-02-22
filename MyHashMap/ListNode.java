// Represents a node of a circular DOUBLY-linked list.

public class ListNode<E> {
	private E entry;
	private ListNode<E> previous;
	private ListNode<E> next;
	private final boolean isSentinel;

	public ListNode(E entry, ListNode<E> previous, ListNode<E> next) {
		this.entry = entry;
		this.previous = previous;
		this.next = next;
		this.isSentinel = false;
	}

	public ListNode(E value) {
		this(value, null, null);
	}
	
	public ListNode() {
		this.entry = null;
		this.previous = this;
		this.next = this;
		this.isSentinel = true;
	}

	public E getEntry() { return entry; }
	public ListNode<E> getPrevious() {	return previous; }
	public ListNode<E> getNext() { return next; }
	public boolean isSentinel() {	return isSentinel; }

	public void setEntry(E entry) { this.entry = entry; }
	public void setPrevious(ListNode<E> previous) {	this.previous = previous; }
	public void setNext(ListNode<E> next) { this.next = next; }
}


