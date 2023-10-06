package DSA.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {
    public static void sort(List<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (max < arr.get(i)) {
                max = arr.get(i);
            }
        }

        List<Integer> count = new ArrayList<>(
                Collections.nCopies(max + 1, 0)
        );
        for (Integer integer : arr) {
            count.set(
                    integer,
                    count.get(integer) + 1
            );
        }

        List<Integer> sortedArr = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            for (int j = 1; j <= count.get(i); j++) {
                sortedArr.add(i);
            }
        }

        arr.clear();
        arr.addAll(sortedArr);
    }
}
