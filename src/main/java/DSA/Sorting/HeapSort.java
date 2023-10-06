package DSA.Sorting;

import java.util.List;

public class HeapSort {

    public static <T extends Comparable<T>> void sort(List<T> arr) {
        buildMaxHeap(arr);

        for (int i = arr.size() - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    private static <T extends Comparable<T>> void buildMaxHeap(List<T> arr) {
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.size());
        }
    }

    private static <T extends Comparable<T>> void maxHeapify(List<T> arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr.get(left).compareTo(arr.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && arr.get(right).compareTo(arr.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }

    private static <T extends Comparable<T>> void swap(List<T> arr, int i, int j) {
        T tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}

