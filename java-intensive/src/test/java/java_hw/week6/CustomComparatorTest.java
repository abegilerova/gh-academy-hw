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
    public void sortTwoElementsNaturalOrder() {
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(2);

        sort(intList, Comparator.naturalOrder());
        assertEquals(intList.get(0), 2);
        assertEquals(intList.get(1), 3);
    }

    @Test
    public void partition() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(2,1,5,3,8,7,1,0));
        CustomComparator.partition(intList, 0, intList.size()-1,Comparator.naturalOrder());
        assertEquals(List.of(2,1,0,3,8,7,6,5), intList);

    }

}