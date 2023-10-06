package DSA.Sorting;

import java.util.List;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(List<T> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        for (int i = 1; i < arr.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(List<T> arr, int idx1, int idx2) {
        T tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }
}
