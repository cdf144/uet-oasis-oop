package DSA.Sorting;

import java.util.List;

public class BinaryInsertionSort {
    public static void sort(List<Integer> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        for (int i = 1; i < arr.size(); i++) {
            int location = binarySearch(arr, i - 1, arr.get(i));
            insert(arr, i, location);
        }
    }

    private static int binarySearch(List<Integer> arr, int high, int key) {
        int low = 0;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (arr.get(mid) == key) {
                return mid + 1;
            }
            if (arr.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        if (arr.get(mid) <= key) return mid + 1;
        return mid;
    }

    private static void insert(List<Integer> arr, int high, int location) {
        int i = high;
        int value = arr.get(high);
        for (; i > location; i--) {
            arr.set(i, arr.get(i - 1));
        }
        arr.set(i, value);
    }
}
