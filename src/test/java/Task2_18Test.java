import org.junit.*;
import org.knit.solutions.Task2_18;

public class Task2_18Test {
    private static Task2_18 task2_18;

    @BeforeClass
    public static void setTask2_18() {
        task2_18 = new Task2_18();
    }

    @Test
    public void testNormalArray() {
        int[] arr = new int[] {1, 0, 2, 3, 0, 4, 5, 0};
        //System.out.println(Arrays.toString(arr));
        task2_18.duplicateZeros(arr);
        //System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr);
    }

    @Test
    public void testNoZeros() {
        int[] arr = new int[] {1, 2, 2, 3, 6, 4, 5, 1};
        task2_18.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 6, 4, 5, 1}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = new int[]{};
        task2_18.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testAllZeros() {
        int[] arr = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
        task2_18.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, arr);
    }

    @Test
    public void testZeroLast() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 0};
        task2_18.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 0}, arr);
    }

    @Test
    public void testZeroFirst() {
        int[] arr = new int[] {0, 2, 3, 4, 5, 6, 7, 1};
        task2_18.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{0, 0, 2, 3, 4, 5, 6, 7}, arr);
    }

    @Test
    public void testMultipleZeros() {
        int[] arr = new int[] {0, 2, 0, 0, 5, 0, 0, 0, 6, 4, 0, 0, 3, 5, 6, 2, 4, 1};
        task2_18.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{0, 0, 2, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 6, 4, 0, 0}, arr);
    }

    @Test
    public void testOneZero() {
        int[] arr = new int[] {0};
        task2_18.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{0}, arr);
    }

    @Test
    public void testBigSlowArray() {
        int[] arr = new int[1000000];
        long startTime = System.nanoTime();
        task2_18.duplicateZeros(arr);
        long endTime = System.nanoTime();
        Assert.assertArrayEquals(new int[1000000], arr);
        if ((endTime - startTime) / 1000000 > 1000) {
            throw new AssertionError("the method is too slow (>1 sec)");
        }
    }

    @AfterClass
    public static void clearTask2_18() {
        task2_18 = null;
    }
}
