package java_hw.week6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java_hw.week6.CustomComparator.sort;
import static org.junit.jupiter.api.Assertions.*;

class CustomComparatorTest {

    @Test
    public void partition() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(2, 6, 5, 3, 8, 7, 1, 0));
        int pivotLocation = CustomComparator.partition(intList, 0, intList.size() - 1, Comparator.naturalOrder());
        assertEquals(List.of(2, 1, 0, 3, 8, 7, 6, 5), intList);
        assertEquals(3, pivotLocation);
    }

    @Test
    public void partition2() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(2, 3, 5, 6, 8, 7, 1, 0));
        int pivotLocation = CustomComparator.partition(intList, 0, intList.size() - 1, Comparator.naturalOrder());
        assertEquals(List.of(2, 3, 5, 0, 1, 6, 8, 7), intList);
        assertEquals(5, pivotLocation);
    }

    @Test
    public void sortTwoElements() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(6,0));
        CustomComparator.sort(intList, Comparator.naturalOrder());
        assertEquals(List.of(0,6), intList);
    }

    @Test
    public void sortOneElement() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(6));
        CustomComparator.sort(intList, Comparator.naturalOrder());
        assertEquals(List.of(6), intList);
    }

    @Test
    public void sort() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(2, 3, 5, 6, 8, 7, 1, 0));
        CustomComparator.sort(intList, Comparator.naturalOrder());
        assertEquals(List.of(0,1,2,3,5,6,7,8), intList);
    }

}