public class Node<E extends Comparable<E>> {
    E data;
    Node left;
    Node right;
    Node parent;
    boolean color; // false = red, true = black
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    // Constructor
    public Node(E data) {
        this.data = data;
    }

    // toString() method
    public String toString() {
        return "Node=[" + data.toString() + "]";
    }

    // Get the minimum value in the tree
    public E min() {
        // If there is no left child, return the current node
        if (left == null) {
            return data;
        }
        // Otherwise, recursively call the min() method on the left child
        else {
            return (E) left.min();
        }
    }

    // Get the maximum value in the tree
    public E max() {
        // If there is no right child, return the current node
        if (right == null) {
            return data;
        }
        // Otherwise, recursively call the max() method on the right child
        else {
            return (E) right.max();
        }
    }

    // Get the minimum node in the tree
    public Node minNode() {
        // If there is no left child, return the current node
        if (left == null) {
            return this;
        }
        // Otherwise, recursively call the minNode() method on the left child
        else {
            return left.minNode();
        }
    }

    // Get the maximum node in the tree
    public Node maxNode() {
        // If there is no right child, return the current node
        if (right == null) {
            return this;
        }
        // Otherwise, recursively call the maxNode() method on the right child
        else {
            return right.maxNode();
        }
    }

    // isBlack() method
    public boolean isBlack() {
        return color == BLACK;
    }

    // getSibling() method
    public Node getSibling() {
        Node parent = this.parent;

        // Look at the parent and return the other child of the parent
        if (this == parent.left) {
            return parent.right;
        } else if (this == parent.right) {
            return parent.left;
        }
        // If the node has no parent, it has no sibling
        else {
            throw new IllegalStateException("This node has no parent node and thus no sibling node");
        }
    }

    // getUncle() method
    public Node getUncle() {
        Node grandparent = this.parent;

        // Look at the grandparent and return the other child of the grandparent
        if (grandparent.left == this) {
            return grandparent.right;
        } else if (grandparent.right == this) {
            return grandparent.left;
        }
        // If the node has no grandparent, it has no uncle
        else {
            throw new IllegalStateException("This node has no grandparent node and thus no uncle node");
        }
    }
}