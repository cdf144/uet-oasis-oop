package DSA.Sorting;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.JVM)
public class SortTests {
    private static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    static class Stopwatch {
        private final long startTime;

        /**
         * Stopwatch constructor. Start is the program (CPU)
         * startTime time in miliseconds.
         */
        public Stopwatch() {
            this.startTime = System.currentTimeMillis();
        }

        /**
         * Calculate the elapsed CPU time (how long it has
         * been since the program started)
         * @return Elapsed time (CPU)
         */
        public double elapsedTime() {
            long currentTime = System.currentTimeMillis();
            return (currentTime - this.startTime) / 1000.0;
        }
    }

    @BeforeClass
    public static void init() {
        System.out.printf(
                "%-25s | %-10s | %-10s%n",
                "Sorting algorithm",
                "Array size",
                "Time taken");
    }

    @Test
    public void testLomutoQuickSort() {
        int size = 800000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        LomutoQuickSort.sort(list, 0, list.size() - 1);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Lomuto Quicksort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }

    @Test
    public void testDualPivotQuickSort() {
        int size = 800000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        DualPivotQuickSort.sort(list, 0, list.size() - 1);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Dual-Pivot Quicksort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }

    @Test
    public void testMergeSort() {
        int size = 800000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        List<Integer> sortedList = MergeSort.sort(list);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Merge sort",
                size,
                timeTaken
        );

        assertTrue(isSorted(sortedList));
    }

    @Test
    public void testHeapSort() {
        int size = 800000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        HeapSort.sort(list);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Heap sort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }

    @Test
    public void testCountingSort() {
        int size = 800000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        CountingSort.sort(list);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Counting sort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }

    @Test
    public void testBubbleSort() {
        int size = 30000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        BubbleSort.sort(list);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Bubble sort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }

    @Test
    public void testSelectionSort() {
        int size = 40000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        SelectionSort.sort(list);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Selection sort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }

    @Test
    public void testInsertionSort() {
        int size = 40000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        InsertionSort.sort(list);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Insertion sort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }

    @Test
    public void testBinaryInsertionSort() {
        int size = 80000;
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int element = random.nextInt(size);
            list.add(element);
        }

        Stopwatch stopwatch = new Stopwatch();
        BinaryInsertionSort.sort(list);
        double timeTaken = stopwatch.elapsedTime();
        System.out.printf(
                "%-25s | %-10d | %7.3fs%n",
                "Binary Insertion sort",
                size,
                timeTaken
        );

        assertTrue(isSorted(list));
    }
}
