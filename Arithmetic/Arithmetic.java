import java.util.ArrayDeque;
import java.util.Scanner;

public class Arithmetic {

	// Evaluates a String exp that has an arithmetic expression, written in classic
	// notation
	public static int evaluate(String exp) {
		return evaluateStout(convertClassicToStout(exp));
	}

	// Returns the result of doing operand1 operation operand2,
	// e.g. operate(5, 2, "-") should return 3
	public static int operate(int operand1, int operand2, String operation) {
		if (operation.equals("+")) {
			return operand1 + operand2;
		}
		if (operation.equals("-")) {
			return operand1 - operand2;
		}
		if (operation.equals("*")) {
			return operand1 * operand2;
		}
		if (operation.equals("/")) {
			return operand1 / operand2;
		}
		return 0;
	}

	private static int operateFlipped(int operand2, int operand1, String operation) {
		if (operation.equals("+")) {
			return operand1 + operand2;
		}
		if (operation.equals("-")) {
			return operand1 - operand2;
		}
		if (operation.equals("*")) {
			return operand1 * operand2;
		}
		if (operation.equals("/")) {
			return operand1 / operand2;
		}
		return 0;
	}

	// Evaluates a String exp that has an arithmetic expression written in STOUT
	// notation
	public static int evaluateStout(String exp) {
		Scanner scanner = new Scanner(exp);
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		while (scanner.hasNext()) {
			dq.push(scanner.hasNextInt() ? scanner.nextInt() : operateFlipped(dq.pop(), dq.pop(), scanner.next()));
		}
		scanner.close();
		return dq.peek();
	}

	public static String convertClassicToStout(String exp) {
		return "";
	}

}
