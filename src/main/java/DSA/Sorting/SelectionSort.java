package DSA.Sorting;

import java.util.List;

public class SelectionSort {
    public static <T extends Comparable<T>> void sort(List<T> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        int min_idx;
        for (int i = 0; i < arr.size() - 1; i++) {
            min_idx = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(min_idx).compareTo(arr.get(j)) > 0) {
                    min_idx = j;
                }
            }
            swap(arr, min_idx, i);
        }
    }

    public static <T extends Comparable<T>> void swap(List<T> arr, int idx1, int idx2) {
        T tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }
}
