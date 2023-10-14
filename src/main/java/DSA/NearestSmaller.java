package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class NearestSmaller {
    public static List<Integer> nearestLeftSmallerValue(List<Integer> arr) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> nearestSmallerValueList = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            while (!indexStack.isEmpty() && arr.get(indexStack.peek()) >= arr.get(i)) {
                indexStack.pop();
            }
            if (indexStack.isEmpty()) {
                nearestSmallerValueList.add(-1);
            } else {
                nearestSmallerValueList.add(indexStack.peek());
            }
            indexStack.push(i);
        }
        return nearestSmallerValueList;
    }

    public static List<Integer> nearestRightSmallerValue(List<Integer> arr) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> nearestSmallerValueList = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            nearestSmallerValueList.add(0);
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!indexStack.isEmpty() && arr.get(indexStack.peek()) >= arr.get(i)) {
                indexStack.pop();
            }
            if (indexStack.isEmpty()) {
                nearestSmallerValueList.set(i, arr.size());
            } else {
                nearestSmallerValueList.set(i, indexStack.peek());
            }
            indexStack.push(i);
        }
        return nearestSmallerValueList;
    }

    public static void main(String[] args) {
        final int size = 50;
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int element = random.nextInt(size);
            arr.add(element);
        }

        List<Integer> nearestLeftSmaller = nearestLeftSmallerValue(arr);
        List<Integer> nearestRightSmaller = nearestRightSmallerValue(arr);
        for (Integer integer : arr) {
            System.out.printf("%-2d ", integer);
        }
        System.out.println();
        for (Integer integer : nearestLeftSmaller) {
            System.out.printf("%-2d ", integer + 1);
        }
        System.out.println();
        for (Integer integer : nearestRightSmaller) {
            System.out.printf("%-2d ", integer);
        }
        System.out.println();
        int maxArea = 0;
        for (int i = 0 ; i < arr.size(); i++) {
            int area = arr.get(i) * (nearestRightSmaller.get(i) - (nearestLeftSmaller.get(i) + 1));
            if (maxArea < area) {
                maxArea = area;
            }
        }
        System.out.print(maxArea);
    }
}
