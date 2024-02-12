import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMyBST {

	Integer[] ints = {3,9,7,5,4,10,5,6,2,1,8};
	
	String[] strings = {"Ahren", "Asher", "Markus", "Gabe", "Chase", "Allie", "Alexandra",
			"Wyatt", "Alex", "Natalie", "Aidan", "Kian", "Sammy", "Andrew", 
			"Samantha", "Ryan", "Derek", "Micah", "Chris", "Megan", "Mark", "Aidan", "Aaron",
			"Will", "Jake", "Ryan", "Grady", "Ben", "Ronan", "Claire", "Sophia"};
	
	MyBST bst = new MyBST();
	
	MyBSTSolution bstsol = new MyBSTSolution();
	
	void identicalTrees(BinaryNode tree1, BinaryNode tree2) {
		LinkedList<BinaryNode> stack1 = new LinkedList<BinaryNode>();
		LinkedList<BinaryNode> stack2 = new LinkedList<BinaryNode>();
		stack1.push(tree1);
		stack2.push(tree2);
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			tree1 = stack1.pop();
			tree2 = stack2.pop();
			assertEquals(tree1.getValue(), tree2.getValue());
			if (tree1.getLeft() != null)
				stack1.push(tree1.getLeft());	
			if (tree1.getRight() != null)
				stack1.push(tree1.getRight());	
			if (tree2.getLeft() != null)
				stack2.push(tree1.getLeft());	
			if (tree2.getRight() != null)
				stack2.push(tree1.getRight());	
		}	
		
//		LinkedList<BinaryNode> stack1 = new LinkedList<BinaryNode>();
//		LinkedList<BinaryNode> stack2 = new LinkedList<BinaryNode>();
//		ArrayList<Comparable> contents1 = new ArrayList<Comparable>();
//		ArrayList<Comparable> contents2 = new ArrayList<Comparable>();
//		stack1.push(tree1);
//		stack2.push(tree2);
//		while(!stack1.isEmpty() && !stack2.isEmpty()) {
//			tree1 = stack1.pop();
//			contents1.add(tree1.getValue());
//			tree2 = stack2.pop();
//			contents2.add(tree2.getValue());
//			if (tree1.hasLeft())
//				stack1.push(tree1.getLeft());	
//			if (tree1.hasRight())
//				stack1.push(tree1.getRight());	
//			if (tree2.hasLeft())
//				stack2.push(tree2.getLeft());	
//			if (tree2.hasRight())
//				stack2.push(tree2.getRight());	
//		}	
//		Collections.sort(contents1);
//		Collections.sort(contents2);
//		assertEquals(contents1.size(), contents2.size());
//		for (int i = 0; i < contents1.size(); i++) {
//			assertEquals(contents1.get(i), contents2.get(i));
//		}
	}
	
	boolean verifyBST(BinaryNode node) {
		if (node == null)
			return true;
		return ( verifyBSTLeft(node.getLeft(), node.getValue())
				&& verifyBSTRight(node.getRight(), node.getValue()));
	}
	
	boolean verifyBSTLeft(BinaryNode node, Comparable max) {
		if (node == null)
			return true;
		if (node.getValue().compareTo(max) > 0)
			return false;
		return verifyBST(node);
		
	}
	
	boolean verifyBSTRight(BinaryNode node, Comparable min) {
		if (node == null) 
			return true;
		if (node.getValue().compareTo(min) < 0)
			return false;
		return verifyBST(node);
	}
	
	void fillListsWithData(Comparable[] list) {
		for (Comparable c : list) {
			assertEquals(bstsol.add(c), bst.add(c));
		}
	}
	
	@Test
	@DisplayName("[5] Test1 if your add and contains method works correctly")
	public void testAdd1() {
		fillListsWithData(ints);
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
	}
	@Test
	@DisplayName("[5] Test2 if your add and contains method works correctly")
	public void testAdd2() {
		fillListsWithData(strings);
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
	}
	
	@Test
	@DisplayName("[5] Test1 if your remove method works correctly")
	public void testRemove1() {
		fillListsWithData(ints);
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
		assertEquals(bstsol.remove(ints[ints.length-1]), bst.remove(ints[ints.length-1]));
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
		assertEquals(bstsol.remove(ints[4]), bst.remove(ints[4]));
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
		assertEquals(bstsol.remove(ints[0]), bst.remove(ints[0]));
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());	
	}
	@Test
	@DisplayName("[5] Test2 if your remove method works correctly")
	public void testRemove2() {
		fillListsWithData(strings);
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
		assertEquals(bstsol.remove(strings[strings.length-1]), bst.remove(strings[strings.length-1]));
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
		assertEquals(bstsol.remove(strings[4]), bst.remove(strings[4]));
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());
		assertEquals(bstsol.remove(strings[0]), bst.remove(strings[0]));
		assertTrue(verifyBST(bst.getRoot()));
		identicalTrees(bstsol.getRoot(), bst.getRoot());	
	}
	
	@Test
	@DisplayName("[5] Test1 if your toString method works correctly")
	public void testToString1() {
		fillListsWithData(ints);
		assertEquals(bstsol.toString(), bst.toString());
	}
	@Test
	@DisplayName("[5] Test2 if your toString method works correctly")
	public void testToString2() {
		fillListsWithData(strings);
		assertEquals(bstsol.toString(), bst.toString());
	}


}
