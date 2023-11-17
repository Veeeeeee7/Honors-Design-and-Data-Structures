import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class test {

    @Test
    public void testExample() {
        int[] times = { 3, 7, 9 };
        int[] points = { 10, 15, 10 };
        assertEquals(20, Recursion.scavHunt(times, points));
    }

    @Test
    public void testEmptyArrays() {
        int[] times = {};
        int[] points = {};
        assertEquals(0, Recursion.scavHunt(times, points));
    }

    @Test
    public void testSingleItem() {
        int[] times = { 5 };
        int[] points = { 8 };
        assertEquals(8, Recursion.scavHunt(times, points));
    }

    @Test
    public void testNoOverlap() {
        int[] times = { 0, 5, 10 };
        int[] points = { 5, 10, 15 };
        assertEquals(30, Recursion.scavHunt(times, points));
    }

    @Test
    public void testOverlappingItems() {
        int[] times = { 2, 5, 8, 11 };
        int[] points = { 5, 10, 15, 20 };
        assertEquals(30, Recursion.scavHunt(times, points));
    }
}
