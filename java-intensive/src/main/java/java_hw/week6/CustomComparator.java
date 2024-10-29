package java_hw.week6;

import java.util.Comparator;
import java.util.List;

public class CustomComparator {
    public static <T> void sort(List<T> list, Comparator<T> comparator) {

    }

    public static <T> void partition (List<T>list, int low, int high, Comparator<T> comparator){
        int lastIndex = list.size() - 1;
        int pivotIndex = (list.size()/2)-1;
        T pivotElement = list.get(pivotIndex);
        T lastElement = list.get(lastIndex);

        list.set(lastIndex, pivotElement);
        list.set(pivotIndex, lastElement);

        int leftIndex = 0;
        while(true){
            boolean leftValueIsLessThanPivot = comparator.compare(list.get(leftIndex), pivotElement) < 0;
            if (leftValueIsLessThanPivot){
                leftIndex += 1;
                System.out.println("incremented left " + leftIndex);
            }

            break;
        }



    }
}
