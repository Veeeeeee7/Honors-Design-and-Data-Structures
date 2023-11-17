public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void reverseList(ListNode head) {
		if (head == null) {
			return;
		}
		reverseList(head.getNext());
		System.out.println(head.getValue().toString());
		return;
	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	public static void infect(String[][] grid, int r, int c) {
		if (c > grid[r].length - 1 || r < 0 || r > grid.length - 1 || c < 0) {
			return;
		}
		if (grid[r][c].equals("vaccinated")) {
			return;
		}
		grid[r][c] = "infected";
		// for (int r1 = 0; r1 < grid.length; r1++) {
		// for (int c1 = 0; c1 < grid[r1].length; c1++) {
		// System.out.print(grid[r1][c1] + " ");
		// }
		// System.out.println();
		// }
		// System.out.println();
		// System.out.println("r: " + r + " c: " + c);
		// System.out.println(grid.length);
		// System.out.println(grid[c].length);
		if (r < grid.length - 1 && !grid[r + 1][c].equals("infected")) {
			infect(grid, r + 1, c);
		}
		if (r > 0 && !grid[r - 1][c].equals("infected")) {
			infect(grid, r - 1, c);
		}

		if (c < grid[r].length - 1 && !grid[r][c + 1].equals("infected")) {
			infect(grid, r, c + 1);
		}

		if (c > 0 && !grid[r][c - 1].equals("infected")) {
			infect(grid, r, c - 1);
		}

		return;
	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	public static long nonConsecutiveSubsets(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 2;
		}
		return nonConsecutiveSubsets(n - 1) + nonConsecutiveSubsets(n - 2);
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	public static long waysToJumpUpStairs(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		long count = 0;
		if (n == 1) {
			count += waysToJumpUpStairs(n - 1);
		} else if (n == 2) {
			count += waysToJumpUpStairs(n - 1);
			count += waysToJumpUpStairs(n - 2);
		} else {
			count += waysToJumpUpStairs(n - 1);
			count += waysToJumpUpStairs(n - 2);
			count += waysToJumpUpStairs(n - 3);
		}
		return count;
	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void permute(String str) {
		if (str.equals("")) {
			System.out.println("");
			return;
		}
		permuteHelper(str, 0);
	}

	// takes in a string and an index to start swapping at and then keep swapping
	// letters until the end of the string
	private static void permuteHelper(String str, int index) {
		if (index == str.length()) {
			System.out.println(str);
			return;
		}
		for (int i = index; i < str.length(); i++) {
			permuteHelper(swap(str, i, index), index + 1);
		}
	}

	// takes in a string and 2 indexes and returns a string with the characters in
	// those 2 indexes swaped
	private static String swap(String str, int i, int j) {
		StringBuilder newStr = new StringBuilder();
		char[] chars = str.toCharArray();
		for (int k = 0; k < chars.length; k++) {
			if (k == i) {
				newStr.append(chars[j]);
			} else if (k == j) {
				newStr.append(chars[i]);
			} else {
				newStr.append(chars[k]);
			}
		}
		return newStr.toString();
	}

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice
	public static void subsets(String str) {
		if (str.equals("")) {
			System.out.println("");
			return;
		}
		// System.out.println("");
		subsetsHelper("", str);
		// System.out.println(str);
	}

	// takes in the original string you are cutting from and the current string you
	// have
	// each time the first character of the original string is cut off
	// 2 recursive calls are made that explore the subsets with and without the cut
	// off character as part of the subset
	public static void subsetsHelper(String current, String original) {
		if (original.equals("")) {
			System.out.println(current);
		} else {
			subsetsHelper(current + original.substring(0, 1), original.substring(1));
			subsetsHelper(current, original.substring(1));
		}
	}

	// Performs a mergeSort on the given array of ints
	public static void mergeSort(int[] ints) {
		if (ints.length == 0) {
			return;
		}
		mergeSortHelper(ints, 0, ints.length);
	}

	// splits the array by halfs going forward
	// merge the sorted sections going backwards
	private static void mergeSortHelper(int[] ints, int left, int right) {
		if (right - left <= 1) {
			return;
		}

		int mid = (left + right) / 2;
		mergeSortHelper(ints, left, mid);
		mergeSortHelper(ints, mid, right);
		merge(ints, left, right, mid);
	}

	// merges 2 sorted subsections of the array
	private static void merge(int[] ints, int left, int right, int mid) {
		if (right - left == 0) {
			return;
		}
		if (right - left == 1) {
			if (ints[left] > ints[right]) {
				int temp = ints[right];
				ints[right] = ints[left];
				ints[left] = temp;
			}
			return;
		}

		int[] temp = new int[right - left];
		int i = left;
		int j = mid;
		int index = 0;
		while (i < mid && j < right) {
			if (ints[i] < ints[j]) {
				temp[index] = ints[i];
				i++;
			} else {
				temp[index] = ints[j];
				j++;
			}
			index++;
		}
		while (i < mid) {
			temp[index] = ints[i];
			index++;
			i++;
		}
		while (j < right) {
			temp[index] = ints[j];
			index++;
			j++;
		}

		int tempIndex = 0;
		for (int k = left; k < right; k++) {
			ints[k] = temp[tempIndex];
			tempIndex++;
		}
	}

	// OPTIONAL BONUS!!!!!!!!
	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	public static void quickSort(int[] ints) {

	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem with
	// n disks starting on tower 0, ending on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int n) {
		if (n <= 0) {
			return;
		}
		hanoiHelper(n, 0, 2, 1);
	}

	// move n disks from origin to target tower using the pivot tower
	// first go from origin to the pivot using the target
	// then go from pivot to target using the origin
	private static void hanoiHelper(int n, int origin, int target, int pivot) {
		if (n == 1) {
			System.out.println(origin + " -> " + target);
			return;
		}
		hanoiHelper(n - 1, origin, pivot, target);
		System.out.println(origin + " -> " + target);
		hanoiHelper(n - 1, pivot, target, origin);
	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.
	public static int scavHunt(int[] times, int[] points) {
		if (points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return points[0];
		}

		// int noSkip = scavHuntHelper(times, points, 0, 0, 0);
		// int skip = scavHuntHelper(times, points, 0, 1, 1);
		// return Math.max(noSkip, skip);

		return scavHuntHelper(times, points, 0, 0, -1);
	}

	// returns max points possible if we have the part of the array starting with
	// index
	// previous is used to keep track of the time from the previous time points were
	// taken
	// previous starts at -1 to allow for the first points to be taken at anytime
	private static int scavHuntHelper(int[] times, int[] points, int score, int index, int previous) {
		if (index > points.length - 1) {
			// return points[points.length - 1];
			return score;
		}

		int noSkipScore = previous < 0 || index == 0 || times[index] - times[previous] >= 5
				? scavHuntHelper(times, points, score + points[index], index + 1, index)
				: 0;
		System.out.println("NOSKIP: " + noSkipScore);
		int skipScore = scavHuntHelper(times, points, score, index + 1, previous);
		System.out.println("SKIP: " + skipScore);

		return Math.max(noSkipScore, skipScore);
	}

	// finds the index of the next possible event
	private static int nextEvent(int[] times, int index) {
		for (int i = index; i < times.length; i++) {
			if (times[i] - times[index] >= 5) {
				return i;
			}
		}
		return -1;
	}
}
