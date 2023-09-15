public class MoveToBackTester {

	public static void main(String[] args) {
		MyArrayList<Integer> ints = new MyArrayList<Integer>();
		final boolean EFFICIENCY = true;
		// Set max to 10000000 for an efficiency check, or 100 for an accuracy check
		int max = 0;
		if (EFFICIENCY)
			max = 10000000;
		else
			max = 100;

		for (int i = 0; i < max; i++) {
			if (i % 5 == 0 || i % 17 == 0)
				ints.add((Integer) 1);
			else
				ints.add((Integer) 2);
		}

		int banned = 0;
		if (EFFICIENCY)
			banned = 7529412;
		else
			banned = 76;

		long startTime = System.currentTimeMillis();
		ints.moveToBack((Integer) 1);
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total milliseconds for moveToBack is " + totalTime);

		for (int i = 0; i < banned; i++) {
			if (ints.get(i).equals((Integer) 1)) {
				System.out.println("Incorrect!");
				return;
			}
		}
		for (int i = banned; i < ints.size(); i++) {
			if (!ints.get(i).equals((Integer) 1)) {
				System.out.println("Incorrect!");
				return;
			}
		}
		System.out.println("Probably correct!");

	}
}