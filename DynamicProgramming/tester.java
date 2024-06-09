public class tester {
    public static void main(String[] args) {
        int[] low = { 2, 400, 6, 8 };
        int[] high = { 100, 2, 30, 400 };
        System.out.println(DynamicProgramming.hiLoStress(low, high));

        // int[] times = { 6, 7, 12, 14, 16, 18, 20, 22, 23, 25 };
        // int[] points = { 5, 6, 5, 1, 3, 4, 7, 4, 5, 3 };
        // System.out.println(DynamicProgramming.scavHunt(times, points));

        // int[][] grid = { { 1, 5, 2, 7 },
        // { 5, 4, 8, -1 },
        // { 0, -1, 5, 4 },
        // { -1, 5, 2, -1 } };
        // System.out.println(DynamicProgramming.dynamicCookies(grid));
    }
}
