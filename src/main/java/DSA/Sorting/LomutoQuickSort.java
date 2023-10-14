package DSA.Sorting;

import java.util.List;

public class LomutoQuickSort {
    /**
     * The default sort method uses
     * rightmost elements as pivots.
     * @param arr Array (List) to sort
     */
    public static <T extends Comparable<T>> void sort(List<T> arr, int low, int high) {
        if (low < high) {
            // Find the correct place of pivot to start partitioning
            int pivotIndex = partition(arr, low, high);

            // Recurse
            sort(arr, pivotIndex + 1, high); // Sort higher half
            sort(arr, low, pivotIndex - 1); // Sort lower half
        }
    }

    /**
     * The default partitioning method uses
     * rightmost element as pivot.
     * @param arr Array (List) to partition
     * @param low lower bound of index
     * @param high higher bound of index
     * @return pivot index in Array (List)
     */
    private static <T extends Comparable<T>> int partition(List<T> arr, int low, int high) {
        int pivotIndex = low; // temporary pivot index
        T pivotVal = arr.get(high); // rightmost element as index
        for (int i = low; i < high; i++) {
            if (arr.get(i).compareTo(pivotVal) < 0) {
                // values larger than pivot gets swapped to the left
                swap(arr, i, pivotIndex);
                pivotIndex++; // iterate temporary pivot index
            }
        }
        swap(arr, high, pivotIndex);
        return pivotIndex;
    }

    /**
     * Alternative partitioning method that uses
     * leftmost element as pivot;
     * @param arr Array (List) to partition
     * @param low lower bound of index
     * @param high higher bound of index
     * @return pivot index in Array (List)
     */
    private static <T extends Comparable<T>> int partitionLeftmostIndex(List<T> arr, int low, int high) {
        int pivotIndex = high;
        T pivot = arr.get(low); // leftmost element as index
        for (int i = high; i > low; i--) {
            if (arr.get(i).compareTo(pivot) > 0) {
                // values larger than pivot gets swapped to the right
                swap(arr, i, pivotIndex);
                pivotIndex--;
            }
        }
        swap(arr, low, pivotIndex);
        return pivotIndex;
    }

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
}
