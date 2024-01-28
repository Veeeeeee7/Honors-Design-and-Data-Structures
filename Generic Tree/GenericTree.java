import java.util.ArrayDeque;
import java.util.ArrayList;

public class GenericTree {
	private TreeNode root;

	public GenericTree() {
		root = null;
	}

	public GenericTree(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}

	public int size() {
		// YOUR CODE HERE
		// Code this method using a stack
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		if (root == null) {
			return 0;
		}
		stack.addFirst(root);
		int size = 1;

		while (!stack.isEmpty()) {
			TreeNode current = stack.removeFirst();
			ArrayList<TreeNode> children = current.getChildren();
			size += children.size();
			for (TreeNode node : children) {
				stack.addFirst(node);
			}
		}

		return size;
	}

	public boolean contains(Object obj) {
		if (root == null)
			return false;
		// Code this method using recursion in the TreeNode class

		return containsHelper(root, obj);
	}

	private boolean containsHelper(TreeNode node, Object obj) {
		if (node.getValue().equals(obj)) {
			return true;
		}

		ArrayList<TreeNode> children = node.getChildren();

		for (TreeNode n : children) {
			if (containsHelper(n, obj)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		// Order is irrelevant:
		// Each TreeNode's contents should be included, on a separate line
		return "";
	}

	public String toStringStack() {
		// Use a stack to do the toString
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		if (root == null) {
			return "";
		}
		stack.addFirst(root);
		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			TreeNode current = stack.removeFirst();
			ArrayList<TreeNode> children = current.getChildren();
			sb.append(current.toString() + "\n");
			for (TreeNode node : children) {
				stack.addFirst(node);
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public String toStringQueue() {
		// Use a queue to do the toString
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		if (root == null) {
			return "";
		}
		queue.addLast(root);
		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			TreeNode current = queue.removeFirst();
			ArrayList<TreeNode> children = current.getChildren();
			sb.append(current.toString() + "\n");
			for (TreeNode node : children) {
				queue.addLast(node);
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public String toStringRecursion() {
		// Use recursion to do the toString
		return recursionHelper(root);
	}

	private String recursionHelper(TreeNode node) {
		ArrayList<TreeNode> children = node.getChildren();
		StringBuilder sb = new StringBuilder(node.toString() + "\n");
		for (TreeNode n : children) {
			sb.append(recursionHelper(n));
		}
		return sb.toString();
	}
}
