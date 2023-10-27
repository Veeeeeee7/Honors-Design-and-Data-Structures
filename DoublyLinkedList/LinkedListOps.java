import java.util.HashSet;

public class LinkedListOps {

	// Returns whether or not the singly linked list which begins at "start"
	// has a loop in it (i.e. one of the nodes points to an earlier node in the list
	public static boolean hasLoop(ListNode start) {
		HashSet<ListNode> visitedNodes = new HashSet<>();
		ListNode node = start;
		while (node != null) {
			if (visitedNodes.contains(node)) {
				return true;
			}
			visitedNodes.add(node);
			node = node.getNext();
		}
		return false;
	}
}
