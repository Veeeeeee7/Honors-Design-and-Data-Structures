import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;

	public HeapPQ() {
		this.heap = (E[]) new Comparable[3];
		this.objectCount = 0;
	}

	// Returns the number of elements in the priority queue
	public int size() {
		return objectCount;
	}

	// DO NOT CHANGE MY JANKY TOSTRING!!!!!
	public String toString() {
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++) {
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for (int rowLength = 1, j = 0; j < objectCount; rowLength *= 2) {
			for (int i = 0; i < rowLength && j < objectCount; i++, j++) {
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount) {
				for (int i = 0; i < Math.min(objectCount - j, rowLength * 2); i++) {
					if (i % 2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	// public void print() {
	// Queue<Node<E>> queue = new LinkedList<>();
	// Node<E> root = new Node<>(heap[0]);
	// queue.add(root);

	// for (int i = 1; i < heap.length; i++) {
	// Node<E> currentNode = queue.poll();
	// Node<E> leftChild = new Node<>(heap[i]);
	// currentNode.left = leftChild;
	// leftChild.parent = currentNode;
	// queue.add(leftChild);
	// i++;

	// if (i < heap.length) {
	// Node<E> rightChild = new Node<>(heap[i]);
	// currentNode.right = rightChild;
	// rightChild.parent = currentNode;
	// queue.add(rightChild);
	// }
	// }
	// BinaryTreePrinter.printNode(root);
	// }

	// Doubles the size of the heap array
	private void increaseCapacity() {
		E[] newHeap = (E[]) new Comparable[heap.length * 2];
		for (int i = 0; i < heap.length; i++) {
			newHeap[i] = heap[i];
		}
		heap = newHeap;
	}

	// Returns the index of the "parent" of index i
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// Returns the index of the *smaller child* of index i
	private int smallerChild(int i) {
		if (i * 2 + 2 >= objectCount) {
			return i * 2 + 1;
		}
		return heap[i * 2 + 1].compareTo(heap[i * 2 + 2]) < 0 ? i * 2 + 1 : i * 2 + 2;
	}

	// Swaps the contents of indices i and j
	private void swap(int i, int j) {
		E temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i) {
		if (i <= 0) {
			return;
		}
		int parent = parent(i);
		if (heap[i].compareTo(heap[parent]) > 0) {
			return;
		}
		swap(i, parent);
		bubbleUp(parent);
	}

	// Bubbles the element at index i downwards until the heap properties hold
	// again.
	private void bubbleDown(int i) {
		if (i * 2 + 1 >= objectCount) {
			return;
		}
		int smallerChild = smallerChild(i);
		if (heap[i].compareTo(heap[smallerChild]) < 0) {
			return;
		}
		swap(i, smallerChild);
		bubbleDown(smallerChild);
	}

	// Adds obj to the Priority Queue
	public void add(E obj) {
		if (objectCount >= heap.length) {
			increaseCapacity();
		}
		heap[objectCount] = obj;
		objectCount++;
		bubbleUp(objectCount - 1);
	}

	// Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin() {
		if (objectCount == 0) {
			throw new NoSuchElementException();
		}

		E temp = heap[0];
		swap(0, objectCount - 1);
		heap[objectCount - 1] = null;
		objectCount--;
		bubbleDown(0);
		return temp;
	}

	// Returns the MINIMUM element from the Priority Queue without removing it
	public E peek() {
		return heap[0];
	}

	// Returns true if the priority queue is empty
	public boolean isEmpty() {
		return objectCount == 0;
	}

}
