import java.util.ArrayList;

public class tester {
    public static void main(String[] args) {
        TreeNode parent = new TreeNode(1);

        parent.addChild(11);
        parent.addChild(12);
        parent.addChild(13);

        ArrayList<TreeNode> children = parent.getChildren();

        TreeNode child1 = children.get(0);
        TreeNode child2 = children.get(1);
        TreeNode child3 = children.get(2);

        child1.addChild(111);
        child1.addChild(112);

        child2.addChild(121);
        child2.addChild(122);

        child3.addChild(131);
        child3.addChild(132);

        GenericTree tree = new GenericTree(parent);
        // System.out.println(tree.toStringStack() + "\n");
        // System.out.println(tree.toStringQueue() + "\n");
        System.out.println(tree.toStringRecursion());
    }
}
