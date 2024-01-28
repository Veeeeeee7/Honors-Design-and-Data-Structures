import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGenericTree {

	Integer[] ints = {3,9,7,5,4,10,5,6,2,1,8};
	
	TreeNode root = new TreeNode(12);
	
	GenericTree tree = new GenericTree(root);
	
	
	void createTree(Object[] list) {
		Random r = new Random(10000);
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		nodeList.add(tree.getRoot());
		tree.getRoot().addChild(list[0]);
		nodeList.add(tree.getRoot().getChildren().get(0));
		for (int i = 1; i < list.length; i++) {
			Object c = list[i];
			int randIndex = r.nextInt(nodeList.size()-1);
			TreeNode parent = nodeList.get(randIndex);
			parent.addChild(c);
			nodeList.add(parent.getChildren().get(parent.getChildren().size()-1));
		}
	}
	
	@Test
	@DisplayName("[10] Test if your size method works correctly")
	public void testSize() {
		createTree(ints);
		assertEquals(ints.length+1, tree.size());
	}
	
	@Test
	@DisplayName("[10] Test if your contains method works correctly")
	public void testContains() {
		createTree(ints);
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(6));
		assertFalse(tree.contains(11));
	}
	
	@Test
	@DisplayName("[5] Test if your toStringStack method works correctly")
	public void testToStringStack() {
		createTree(ints);
		ArrayList<String> list = new ArrayList<String>();
		for (Object o : ints)
			list.add(o.toString());
		list.add(root.getValue().toString());
		String s = tree.toStringStack();
		Scanner reader = new Scanner(s);
		while(reader.hasNext()) {
			assertTrue(list.remove(reader.next()));
		}
		assertTrue(list.isEmpty());
		reader.close();
	}
	@Test
	@DisplayName("[5] Test if your toStringQueue method works correctly")
	public void testToStringQueue() {
		createTree(ints);
		ArrayList<String> list = new ArrayList<String>();
		for (Object o : ints)
			list.add(o.toString());
		list.add(root.getValue().toString());

		String s = tree.toStringQueue();
		Scanner reader = new Scanner(s);
		while(reader.hasNext()) {
			assertTrue(list.remove(reader.next()));
		}
		assertTrue(list.isEmpty());
		reader.close();
	}
	
	@Test
	@DisplayName("[5] Test if your toStringRecursion method works correctly")
	public void testToStringRecursion() {
		createTree(ints);
		ArrayList<String> list = new ArrayList<String>();
		for (Object o : ints)
			list.add(o.toString());
		list.add(root.getValue().toString());

		String s = tree.toStringRecursion();
		Scanner reader = new Scanner(s);
		while(reader.hasNext()) {
			assertTrue(list.remove(reader.next()));
		}
		assertTrue(list.isEmpty());
		reader.close();
	}


}
