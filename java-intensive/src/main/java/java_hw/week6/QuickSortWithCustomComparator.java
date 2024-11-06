package java_hw.week6;

import java.util.Comparator;
import java.util.List;

public class QuickSortWithCustomComparator {
    public static <T> void sort(List<T> list, Comparator<T> comparator){
        sort(list, 0, list.size() - 1, comparator);

    }

    public static <T> void sort(List<T> list, int low, int high, Comparator<T> comparator) {
        if(low < high){
            String pre = "pre  " + list.subList(low, high + 1);
            int pivotLocation = partition(list, low, high, comparator);
            System.out.printf("%s%npost %s%npivot %s%n", pre, list.subList(low, high + 1), list.get(pivotLocation));
            sort(list, low, pivotLocation, comparator);
            sort(list, pivotLocation + 1, high, comparator);
        }
    }

    public static <T> int partition(List<T> list, int low, int high, Comparator<T> comparator) {

        int pivotIndex = (high + low) / 2;
        T pivotElement = list.get(pivotIndex);

        swap(list, pivotIndex, high);

        int leftIndex = low;
        int rightIndex = high - 1;

        while (leftIndex < rightIndex) {
            boolean leftValueIsLessThanPivot = comparator.compare(list.get(leftIndex), pivotElement) < 0;
            if (leftValueIsLessThanPivot) {
                leftIndex += 1;
            }

            boolean rightValueIsLargerThanPivot = comparator.compare(list.get(rightIndex), pivotElement) > 0;
            if (rightValueIsLargerThanPivot) {
                rightIndex -= 1;
            }

            if (!leftValueIsLessThanPivot && !rightValueIsLargerThanPivot) {
                swap(list, leftIndex, rightIndex);
            }
        }

        swap(list, leftIndex, high);

        return leftIndex;
    }

    public static <T> void swap(List<T> list, int a, int b) {
        T elementA = list.get(a);
        list.set(a, list.get(b));
        list.set(b, elementA);
    }
}
