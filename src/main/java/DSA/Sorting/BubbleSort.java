package DSA.Sorting;

import java.util.List;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(List<T> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        int length = arr.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < length - 1; i++) {
                if (arr.get(i).compareTo(arr.get(i + 1)) > 0) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            length--;
        } while (swapped);
    }

    private static <T extends Comparable<T>> void swap(List<T> arr, int idx1, int idx2) {
        T tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }
}
