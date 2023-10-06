package DSA.Sorting;

import java.util.List;

public class BubbleSort {
    public static void sort(List<Integer> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        int length = arr.size();
        boolean swapped;
        while (true) {
            swapped = false;
            for (int i = 0; i < length - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
            length--;
        }
    }

    private static void swap(List<Integer> arr, int idx1, int idx2) {
        int tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }
}
