import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tester {
    public static void main(String[] args) {
        int n = 3;
        String solution = "0 -> 2\n"
                + "0 -> 1\n"
                + "2 -> 1\n"
                + "0 -> 2\n"
                + "1 -> 0\n"
                + "1 -> 2\n"
                + "0 -> 2\n";
        Recursion.solveHanoi(n);
        System.out.println("\nSOLUTION:\n" + solution);
        // String[][] grid = { { "----------", "vaccinated", "----------", "----------",
        // "----------" },
        // { "vaccinated", "----------", "----------", "----------", "----------" },
        // { "----------", "----------", "vaccinated", "vaccinated", "vaccinated" },
        // { "----------", "----------", "----------", "vaccinated", "----------" } };
        // Recursion.infect(grid, 1, 2);
        // for (int r = 0; r < grid.length; r++) {
        // for (int c = 0; c < grid[r].length; c++) {
        // System.out.print(grid[r][c] + " ");
        // }
        // System.out.println();
        // }

        // ListNode n1 = new ListNode("FIRSRT");
        // ListNode n2 = new ListNode("SECOND");
        // ListNode n3 = new ListNode("THIRD");
        // n1.setNext(n2);
        // n2.setNext(n3);
        // Recursion.reverseList(n1);

        // String[][] grid = new String[5][5];
        // for (int r = 0; r < grid.length; r++) {
        // for (int c = 0; c < grid.length; c++) {
        // grid[r][c] = "nothing";
        // }
        // }
        // grid[2][3] = "vaccinated";
        // grid[1][4] = "vaccinated";
        // grid[3][4] = "vaccinated";
        // Recursion.infect(grid, 0, 2);
        // for (int r = 0; r < grid.length; r++) {
        // for (int c = 0; c < grid.length; c++) {
        // System.out.print(grid[r][c] + " ");
        // }
        // System.out.println();
        // }

        // System.out.println(Recursion.nonConsecutiveSubsetsx(4));

        // System.out.println(Recursion.waysToJumpUpStairs(4));

        // Recursion.permute("abc");

        // Recursion.subsets("abc");

        // int[] arr = { 12, 24, 35, 13, 2 };
        // Recursion.mergeSort(arr);
        // for (int i : arr) {
        // System.out.println(i);
        // }

    }
}
