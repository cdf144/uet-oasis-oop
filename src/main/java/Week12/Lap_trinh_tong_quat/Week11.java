package Week12.Lap_trinh_tong_quat;

import java.util.List;

public class Week11<T> {
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> arr) {
        LomutoQuickSort.sort(arr, 0, arr.size() - 1);
        return arr;
    }
}
