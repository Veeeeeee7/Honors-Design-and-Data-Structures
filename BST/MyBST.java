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
		if (currentValue.equals(value)) {
			return true;
		}
		if (node.hasRight() && value.compareTo(currentValue) > 0) {
			return containsHelper(node.getRight(), value);
		} else if (node.hasLeft() && value.compareTo(currentValue) < 0) {
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
			return addHelper(node.getRight(), value);
		} else if (value.compareTo(currentValue) < 0) {
			if (node.getLeft() == null) {
				node.setLeft(new BinaryNode<E>(value));
				return true;
			}
			return addHelper(node.getLeft(), value);
		}
		return false;
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(E value) {
		return removeHelper(root, value);
	}

	private boolean removeHelper(BinaryNode<E> node, E value) {
		if (root.getValue().equals(value)) {
			if (root == null) {
				return false;
			}
			if (!root.hasChildren()) {
				root = null;
				return true;
			}
			if (!root.hasRight()) {
				root = root.getLeft();
				return true;
			}
			if (!root.hasLeft()) {
				root = root.getRight();
				return true;
			}

			BinaryNode<E> leftMax = getBeforeMax(root.getLeft(), root);
			// System.out.println(leftMax.getValue());
			if (leftMax.getValue().equals(root.getValue())) {
				root.setValue(root.getLeft().getValue());
				root.setLeft(root.getLeft().getLeft());
				return true;
			}

			if (leftMax.hasRight()) {
				root.setValue(leftMax.getRight().getValue());
				leftMax.setRight(null);
			} else if (leftMax.hasLeft()) {
				root.setValue(leftMax.getLeft().getValue());
				leftMax.setLeft(null);
			}

		}

		BinaryNode<E> previousNode = findPreviousNode(root, value);
		boolean left = false;
		BinaryNode<E> removeNode = new BinaryNode<>(null);
		if (previousNode == null) {
			return false;
		}
		if (value.compareTo(previousNode.getValue()) > 0) {
			removeNode = previousNode.getRight();
			left = false;
		} else if (value.compareTo(previousNode.getValue()) < 0) {
			removeNode = previousNode.getLeft();
			left = true;
		}

		if (!removeNode.hasChildren()) {
			if (left) {
				previousNode.setLeft(null);
			} else {
				previousNode.setRight(null);
			}
		}

		if (!removeNode.hasLeft()) {
			if (left) {
				previousNode.setLeft(removeNode.getRight());
			} else {
				previousNode.setRight(removeNode.getRight());
			}
		}

		if (!removeNode.hasRight()) {
			if (left) {
				previousNode.setLeft(removeNode.getLeft());
			} else {
				previousNode.setRight(removeNode.getLeft());
			}
		}

		BinaryNode<E> leftMax = getBeforeMax(removeNode, removeNode);

		if (leftMax.hasRight()) {
			removeNode.setValue(leftMax.getRight().getValue());
			leftMax.setRight(null);
		} else if (leftMax.hasLeft()) {
			removeNode.setValue(leftMax.getLeft().getValue());
			leftMax.setLeft(null);
		}

		return true;
	}

	private BinaryNode<E> getBeforeMax(BinaryNode<E> node, BinaryNode<E> previousNode) {
		if (node.hasRight()) {
			return getBeforeMax(node.getRight(), node);
		}
		// if (node.hasLeft()) {
		// return getBeforeMax(node.getLeft(), node);
		// }
		return previousNode;
	}

	private BinaryNode<E> findPreviousNode(BinaryNode<E> node, E value) {
		E currentValue = node.getValue();
		if (node.hasRight() && node.getRight().getValue().equals(value)) {
			return node;
		} else if (node.hasLeft() && node.getLeft().getValue().equals(value)) {
			return node;
		}

		if (node.hasRight() && value.compareTo(currentValue) > 0) {
			return findPreviousNode(node.getRight(), value);
		} else if (node.hasLeft() && value.compareTo(currentValue) < 0) {
			return findPreviousNode(node.getLeft(), value);
		}
		return null;
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
