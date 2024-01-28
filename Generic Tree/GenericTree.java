
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
		//YOUR CODE HERE
		//Code this method using a stack
		return 0;
	}
	
	public boolean contains(Object obj) {
		if (root == null) return false;
		//Code this method using recursion in the TreeNode class
		return root.contains(obj);
	}
	
	
	public String toString() {
		// Order is irrelevant:
		// Each TreeNode's contents should be included, on a separate line
		return "";
	}
	
	public String toStringStack() {
		//Use a stack to do the toString
		return "";
	}
	
	public String toStringQueue() {
		//Use a queue to do the toString
		return "";
	}
	
	public String toStringRecursion() {
		//Use recursion to do the toString
		return root.recursiveToString();
	}
}
