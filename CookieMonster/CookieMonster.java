import java.io.File;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make stacks and queues,
 * and Java's PriorityQueue class to make a priority queue */

public class CookieMonster {

	private int[][] cookieGrid;
	private int numRows;
	private int numCols;

	// Constructs a CookieMonster from a file with format:
	// numRows numCols
	// <<rest of the grid, with spaces in between the numbers>>
	public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try {
			Scanner input = new Scanner(new File(fileName));

			numRows = input.nextInt();
			numCols = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++)
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();

			input.close();
		} catch (Exception e) {
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

	}

	public CookieMonster(int[][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows = cookieGrid.length;
		this.numCols = cookieGrid[0].length;
	}

	/*
	 * RECURSIVELY calculates the route which grants the most cookies.
	 * Returns the maximum number of cookies attainable.
	 */
	public int recursiveCookies() {
		// return recursiveHelper(new OrphanScout(0, 0, 0)).getCookiesDiscovered();
		return recursiveHelper(0, 0, 0);
	}

	// private OrphanScout recursiveHelper(OrphanScout o) {
	// if (o.getEndingCol() >= numCols || o.getEndingRow() >= numRows
	// || cookieGrid[o.getEndingRow()][o.getEndingCol()] == -1) {
	// return o;
	// }
	// OrphanScout right = new OrphanScout(o.getEndingRow() + 1, o.getEndingCol(),
	// o.getCookiesDiscovered() + cookieGrid[o.getEndingRow()][o.getEndingCol()]);
	// OrphanScout down = new OrphanScout(o.getEndingRow(), o.getEndingCol() + 1,
	// o.getCookiesDiscovered() + cookieGrid[o.getEndingRow()][o.getEndingCol()]);
	// return recursiveHelper(right).compareTo(recursiveHelper(down)) > 0 ? right :
	// down;
	// }

	private int recursiveHelper(int r, int c, int count) {
		return r >= numRows || c >= numCols || cookieGrid[r][c] == -1 ? count
				: Math.max(recursiveHelper(r + 1, c, count + cookieGrid[r][c]),
						recursiveHelper(r, c + 1, count + cookieGrid[r][c]));

	}

	private int get(int r, int c) {
		return r >= numRows || c >= numCols || cookieGrid[r][c] < 0 ? -1 : cookieGrid[r][c];
	}

	/*
	 * Calculate which route grants the most cookies using a QUEUE.
	 * Returns the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int queueCookies() {
		ArrayDeque<OrphanScout> queue = new ArrayDeque<OrphanScout>();
		int max = 0;

		if (cookieGrid[0][0] < 0) {
			return 0;
		}

		queue.addLast(new OrphanScout(0, 0, cookieGrid[0][0]));
		max = cookieGrid[0][0];

		while (!queue.isEmpty()) {
			OrphanScout current = queue.removeFirst();
			int r = current.getEndingRow();
			int c = current.getEndingCol();
			int count = current.getCookiesDiscovered();
			int right = get(r, c + 1);
			int down = get(r + 1, c);

			if (right >= 0) {
				queue.addLast(new OrphanScout(r, c + 1, count + right));
				max = Math.max(max, count + right);
			}
			if (down >= 0) {
				queue.addLast(new OrphanScout(r + 1, c, count + down));
				max = Math.max(max, count + down);
			}
		}

		return max;
	}

	/*
	 * Calculate which route grants the most cookies using a stack.
	 * Returns the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int stackCookies() {
		ArrayDeque<OrphanScout> stack = new ArrayDeque<OrphanScout>();
		int max = 0;
		if (cookieGrid[0][0] < 0) {
			return 0;
		}

		stack.addFirst(new OrphanScout(0, 0, cookieGrid[0][0]));
		max = cookieGrid[0][0];

		while (!stack.isEmpty()) {
			OrphanScout current = stack.removeFirst();
			int r = current.getEndingRow();
			int c = current.getEndingCol();
			int count = current.getCookiesDiscovered();
			int right = get(r, c + 1);
			int down = get(r + 1, c);

			if (right >= 0) {
				stack.addFirst(new OrphanScout(r, c + 1, count + right));
				max = Math.max(max, count + right);
			}
			if (down >= 0) {
				stack.addFirst(new OrphanScout(r + 1, c, count + down));
				max = Math.max(max, count + down);
			}
		}
		return max;
	}

	/*
	 * Calculate which route grants the most cookies using a priority queue.
	 * Returns the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int pqCookies() {
		PriorityQueue<OrphanScout> pq = new PriorityQueue<OrphanScout>();
		int max = 0;

		if (cookieGrid[0][0] < 0) {
			return 0;
		}

		pq.add(new OrphanScout(0, 0, cookieGrid[0][0]));
		max = cookieGrid[0][0];

		while (!pq.isEmpty()) {
			OrphanScout current = pq.remove();
			int r = current.getEndingRow();
			int c = current.getEndingCol();
			int count = current.getCookiesDiscovered();
			int right = get(r, c + 1);
			int down = get(r + 1, c);

			if (right >= 0) {
				pq.add(new OrphanScout(r, c + 1, count + right));
				max = Math.max(max, count + right);
			}
			if (down >= 0) {
				pq.add(new OrphanScout(r + 1, c, count + down));
				max = Math.max(max, count + down);
			}
		}
		return max;
	}
}
