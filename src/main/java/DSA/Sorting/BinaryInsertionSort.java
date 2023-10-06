package DSA.Sorting;

import java.util.List;

public class BinaryInsertionSort {
    public static <T extends Comparable<T>> void sort(List<T> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        for (int i = 1; i < arr.size(); i++) {
            int location = binarySearch(arr, i - 1, arr.get(i));
            insert(arr, i, location);
        }
    }

    private static <T extends Comparable<T>> int binarySearch(List<T> arr, int high, T key) {
        int low = 0;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (arr.get(mid).compareTo(key) == 0) {
                return mid + 1;
            }
            if (arr.get(mid).compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        if (arr.get(mid).compareTo(key) <= 0) return mid + 1;
        return mid;
    }

    private static <T extends Comparable<T>> void insert(List<T> arr, int high, int location) {
        int i = high;
        T value = arr.get(high);
        for (; i > location; i--) {
            arr.set(i, arr.get(i - 1));
        }
        arr.set(i, value);
    }
}
