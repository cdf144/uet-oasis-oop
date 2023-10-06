package DSA.Sorting;

import java.util.List;

public class InsertionSort {
    public static void sort(List<Integer> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        for (int i = 1; i < arr.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j) > arr.get(j + 1)) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(List<Integer> arr, int idx1, int idx2) {
        int tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }
}
