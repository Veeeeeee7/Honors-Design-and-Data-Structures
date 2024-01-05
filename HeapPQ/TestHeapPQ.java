import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestHeapPQ {

	HeapPQSolution<Integer> pqsol = new HeapPQSolution<Integer>();
	HeapPQ<Integer> pq = new HeapPQ<Integer>();

	void fillListsWithData() {
		pqsol.add(10);
		pqsol.add( 6);
		pqsol.add(11);
		pqsol.add( 8);
		pqsol.add( 9);
		pqsol.add( 5);
		pqsol.add( 7);
		pq.add(10);
		pq.add( 6);
		pq.add(11);
		pq.add( 8);
		pq.add( 9);
		pq.add( 5);
		pq.add( 7);
	}

	@Test
	@DisplayName("[15] Test if add works")
	public void testAdd() {

		fillListsWithData();

		assertEquals(pqsol.toString(), pq.toString());
	}
	
	@Test
	@DisplayName("[15] Test if removeMin works")
	public void testRemoveMin() {

		fillListsWithData();

		assertEquals(pqsol.removeMin(), pq.removeMin());
		assertEquals(pqsol.toString(), pq.toString());
		assertEquals(pqsol.removeMin(), pq.removeMin());
		assertEquals(pqsol.toString(), pq.toString());
		
	}
	
	@Test
	@DisplayName("[5] Test if peek works")
	public void testPeek() {

		fillListsWithData();

		assertEquals(pqsol.peek(), pq.peek());
		assertEquals(pqsol.toString(), pq.toString());
		
	}
	
	@Test
	@DisplayName("[5] Test if isEmpty works")
	public void testIsEmpty() {

		assertTrue(pq.isEmpty());
		fillListsWithData();
		assertFalse(pq.isEmpty());

	}

}
