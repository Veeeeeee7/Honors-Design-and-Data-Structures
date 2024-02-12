// Implements a BST with BinaryNode nodes

public class MyBST<E extends Comparable<E>> {

	private BinaryNode<E> root; // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode getRoot() {
		return root;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return containsHelper(root, value);
	}

	private boolean containsHelper(BinaryNode<E> node, E value) {
		E currentValue = node.getValue();
		if (node.getValue().equals(value)) {
			return true;
		}
		if (!node.hasChildren()) {
			return false;
		}
		if (value.compareTo(currentValue) > 0) {
			return containsHelper(node.getRight(), value);
		} else if (value.compareTo(currentValue) < 0) {
			return containsHelper(node.getLeft(), value);
		}
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		if (root == null) {
			root = new BinaryNode<E>(value);
			return true;
		}
		return addHelper(root, value);
	}

	private boolean addHelper(BinaryNode<E> node, E value) {
		E currentValue = node.getValue();
		if (value.compareTo(currentValue) > 0) {
			if (node.getRight() == null) {
				node.setRight(new BinaryNode<E>(value));
				return true;
			}
			addHelper(node.getRight(), value);
		} else if (value.compareTo(currentValue) < 0) {
			if (node.getLeft() == null) {
				node.setLeft(new BinaryNode<E>(value));
				return true;
			}
			addHelper(node.getLeft(), value);
		}
		return false;
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(E value) {
		return false;
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the
	// nodes, in order
	// e.g. ["Apple", "Cranberry", "Durian", "Mango"]
	public String toString() {
		return "[" + toStringHelper(root) + "]";
	}

	private String toStringHelper(BinaryNode<E> node) {
		StringBuilder sb = new StringBuilder();
		if (node == null) {
			return "";
		}

		if (node.hasLeft()) {
			sb.append(toStringHelper(node.getLeft()) + ", ");
		}
		sb.append(node.toString());
		if (node.hasRight()) {
			sb.append(", " + toStringHelper(node.getRight()));
		}
		return sb.toString();
	}
}
