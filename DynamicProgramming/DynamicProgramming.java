
public class DynamicProgramming {

    // Every day for the rest of the year, you're going to be given a choice between
    // two jobs to do:
    // one that is LOW stress, and one that is HIGH stress. Each job pays out a
    // dollar amount;
    // *usually* the high stress jobs pay more. However, after doing a high stress
    // job, you need to
    // REST for a day.

    // Given a list of all the payouts for all the low stress and high stress jobs,
    // what is the most amount of money you can get?

    // You can assume lowPayouts.length == highPayouts.length
    public static int hiLoStress(int[] lowPayouts, int[] highPayouts) {
        int[] max = new int[lowPayouts.length + 1];
        // max[0] = 0;
        // max[1] = lowPayouts[0];
        max[max.length - 1] = 0;
        max[max.length - 2] = lowPayouts[lowPayouts.length - 1];
        for (int i = max.length - 3; i >= 0; i--) {
            max[i] = Math.max(max[i + 2] + highPayouts[i], max[i + 1] + lowPayouts[i]);
        }
        return max[0];
    }

    // You are partaking in a scavenger hunt!
    // You've gotten a secret map to find many of the more difficult
    // items, but they are only available at VERY specific times at
    // specific places. You have an array, times[], that lists at which
    // MINUTE an item is available, in increasing order.
    // Items in the ScavHunt are worth varying numbers of points.
    // You also have an array, points[], same length as times[],
    // that lists how many points each of the corresponding items is worth.
    // Problem is: to get from one location to the other takes 5 minutes,
    // so if there is an item, for example, available at time 23 and another
    // at time 27, it's just not possible for you to make it to both: you'll
    // have to choose!
    // Write a method that returns the maximum POINTS you can get.
    public static int scavHunt(int[] times, int[] points) {
        int[] max = new int[times.length + 1];
        max[0] = 0;
        max[1] = points[0];
        System.out.println(max[1]);

        for (int i = 2; i < points.length + 1; i++) {
            if (times[i - 1] - times[i - 2] < 5) {
                int previousPossibleIndex = i - 2;
                while (previousPossibleIndex > -1 && times[i - 1] - times[previousPossibleIndex] < 5) {
                    previousPossibleIndex--;
                }
                if (previousPossibleIndex == -1) {
                    max[i] = points[i - 1];
                } else {
                    max[i] = max[previousPossibleIndex + 1] + points[i - 1];
                }
            } else {
                max[i] = max[i - 1] + points[i - 1];
            }
            max[i] = Math.max(max[i], max[i - 1]);
            System.out.println(max[i]);
        }

        return max[max.length - 1];
    }

    /*
     * Uses memoization to calculate the route which grants the most cookies,
     * starting at [0][0], only going right or down at each point
     */
    public static int dynamicCookies(int[][] cookieGrid) {
        int[][] maxGrid = new int[cookieGrid.length][cookieGrid[0].length];
        int max = 0;
        for (int i = 0; i < maxGrid.length; i++) {
            for (int j = 0; j < maxGrid[i].length; j++) {
                maxGrid[i][j] = Integer.MIN_VALUE;
            }
        }

        maxGrid[0][0] = cookieGrid[0][0];
        for (int i = 0; i < maxGrid.length; i++) {
            for (int j = 0; j < maxGrid[i].length; j++) {
                if (i < maxGrid.length - 1 && cookieGrid[i + 1][j] != -1) {
                    maxGrid[i + 1][j] = Math.max(maxGrid[i + 1][j], maxGrid[i][j] + cookieGrid[i + 1][j]);
                }
                if (j < maxGrid.length - 1 && cookieGrid[i][j + 1] != -1) {
                    maxGrid[i][j + 1] = Math.max(maxGrid[i][j + 1], maxGrid[i][j] + cookieGrid[i][j + 1]);
                }
                // int previousUp = i > 0 ? maxGrid[i - 1][j] : 0;
                // int previousLeft = j > 0 ? maxGrid[i][j - 1] : 0;
                // int previous = Math.max(previousUp, previousLeft);

                // maxGrid[i][j] = cookieGrid[i][j] == -1 ? previous : previous +
                // cookieGrid[i][j];
                max = Math.max(max, maxGrid[i][j]);
            }
        }

        for (int i = 0; i < maxGrid.length; i++) {
            for (int j = 0; j < maxGrid.length; j++) {
                System.out.print(cookieGrid[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("\n\n");

        for (int i = 0; i < maxGrid.length; i++) {
            for (int j = 0; j < maxGrid.length; j++) {
                System.out.print(maxGrid[i][j] + ", ");
            }
            System.out.println();
        }
        return max;
    }

}
