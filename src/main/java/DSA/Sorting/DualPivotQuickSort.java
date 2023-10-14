package DSA.Sorting;

import java.util.List;

public class DualPivotQuickSort {

    /**
     * Method to swap 2 elements of an Array (List)
     * at 2 indexes.
     * @param arr Array (List)
     * @param idx1 first element index
     * @param idx2 second element index
     */
    private static <T extends Comparable<T>> void swap(List<T> arr, int idx1, int idx2) {
        T tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }

    /**
     * Dual-Pivot Quicksort method.
     * @param arr Array to sort
     * @param low lower bound of area to sort
     * @param high higher bound of area to sort
     */
    public static <T extends Comparable<T>> void sort(List<T> arr, int low, int high) {
        if (low < high) {
            /*
             piv[] stores left pivot and right pivot.
             piv[0] means left pivot and
             piv[1] means right pivot
             */
            int[] piv;
            piv = partition(arr, low, high);

            sort(arr, low, piv[0] - 1);
            sort(arr, piv[0] + 1, piv[1] - 1);
            sort(arr, piv[1] + 1, high);
        }
    }

    /**
     * Partition method using 2 pivots (Dual-Pivot).
     * @param arr Array to partition
     * @param low lower bound of area to partition
     * @param high higher bound of area to sort
     * @return 2 indices of the pivots which has
     * been brought to their appropiate positions
     */
    static <T extends Comparable<T>> int[] partition(List<T> arr, int low, int high) {
        if (arr.get(low).compareTo(arr.get(high)) > 0) {
            swap(arr, low, high);
        }

        // p is the left pivot, and q
        // is the right pivot.
        int j = low + 1;
        int g = high - 1, k = low + 1;
        T p = arr.get(low), q = arr.get(high);

        while (k <= g) {
            // If elements are less than the left pivot
            if (arr.get(k).compareTo(p) < 0) {
                swap(arr, k, j);
                j++;
            }
            // If elements are greater than or equal
            // to the right pivot
            else if (arr.get(k).compareTo(q) >= 0) {
                while (arr.get(g).compareTo(q) > 0 && k < g) {
                    g--;
                }

                swap(arr, k, g);
                g--;

                if (arr.get(k).compareTo(p) < 0) {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        // Bring pivots to their appropriate positions.
        swap(arr, low, j);
        swap(arr, high, g);

        // Returning the indices of the pivots
        // because we cannot return two elements
        // from a function, we do that using an array.
        return new int[] { j, g };
    }
}