import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.knit.solutions.Task2_19;

public class Task2_19Test {
    private static Task2_19 task2_19;

    @BeforeClass
    public static void setTask2_19() {
        task2_19 = new Task2_19();
    }

    @Test
    public void testNormalArrays() {
        int[] nums1 = new int[] {0, 0, 1, 2, 3, 6, 8, 10, 0, 0, 0, 0, 0};
        int[] nums2 = new int[] {0, 3, 7, 9, 1000};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 1, 2, 3, 3, 6, 7, 8, 9, 10, 1000}, nums1);
    }

    @Test
    public void testFirstEndEarly() {
        int[] nums1 = new int[] {10, 12, 14, 15, 20, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[] {1, 2, 5, 6, 7, 7, 8, 9};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{1, 2, 5, 6, 7, 7, 8, 9, 10, 12, 14, 15, 20}, nums1);
    }

    @Test
    public void testSecondEndEarly() {
        int[] nums1 = new int[] {1, 2, 5, 6, 7, 7, 8, 9, 0, 0, 0, 0, 0};
        int[] nums2 = new int[] {10, 12, 14, 15, 20};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{1, 2, 5, 6, 7, 7, 8, 9, 10, 12, 14, 15, 20}, nums1);
    }

    @Test
    public void testFirstEmpty() {
        int[] nums1 = new int[] {0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[] {0, 10, 12, 14, 15, 20};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{0, 10, 12, 14, 15, 20}, nums1);
    }

    @Test
    public void testSecondEmpty() {
        int[] nums1 = new int[] {1, 2, 5, 6, 7, 7};
        int[] nums2 = new int[] {};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{1, 2, 5, 6, 7, 7}, nums1);
    }

    @Test
    public void testBothEmpty() {
        int[] nums1 = new int[] {};
        int[] nums2 = new int[] {};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{}, nums1);
    }

    @Test
    public void testAllZeros() {
        int[] nums1 = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[] {0, 0, 0};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, nums1);
    }

    @Test
    public void testAllEqual() {
        int[] nums1 = new int[] {7, 7, 7, 7, 7, 0, 0, 0};
        int[] nums2 = new int[] {7, 7, 7};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{7, 7, 7, 7, 7, 7, 7, 7}, nums1);
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums1 = new int[] {-5, -1, 0, 2, 5, 6, 0, 0, 0, 0, 0};
        int[] nums2 = new int[] {-10, -2, 4, 15, 20};
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        Assert.assertArrayEquals(new int[]{-10, -5, -2, -1, 0, 2, 4, 5, 6, 15, 20}, nums1);
    }

    @Test
    public void testBigSlowArray() {
        int[] nums1 = new int[2000000];
        int[] nums2 = new int[1000000];
        long startTime = System.nanoTime();
        task2_19.merge(nums1, nums1.length, nums2, nums2.length);
        long endTime = System.nanoTime();
        Assert.assertArrayEquals(new int[2000000], nums1);
        if ((endTime - startTime) / 1000000 > 1000) {
            throw new AssertionError("the method is too slow (>1 sec)");
        }
    }

    @AfterClass
    public static void clearTask2_18() {
        task2_19 = null;
    }
}
