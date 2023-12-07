package Week12.Lap_trinh_tong_quat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Week11Test {
    @Test
    public void testSortGenericInteger() {
        List<Integer> unsortedList = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> actualList = Week11.sortGeneric(unsortedList);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testSortLargeStringList() {
        List<String> unsortedList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            unsortedList.add(String.valueOf(i));
        }
        Collections.shuffle(unsortedList);

        List<String> expectedList = new ArrayList<>(unsortedList);
        Collections.sort(expectedList);

        LomutoQuickSort.sort(unsortedList, 0, unsortedList.size() - 1);

        assertEquals(expectedList, unsortedList);
    }

    @Test
    public void testSortGenericString() {
        List<String> unsortedList = Arrays.asList("apple", "banana", "orange", "grapefruit", "kiwi");
        List<String> expectedList = Arrays.asList("apple", "banana", "grapefruit", "kiwi", "orange");
        List<String> actualList = Week11.sortGeneric(unsortedList);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testSortGenericPerson() {
        Person p1 = new Person("Alice", 20, "123 Main Street");
        Person p2 = new Person("Bob", 25, "456 Elm Street");
        Person p3 = new Person("Charles", 30, "789 Oak Street");
        Person p4 = new Person("Alice", 22, "1011 Pine Avenue");

        List<Person> unsortedList = Arrays.asList(p4, p3, p2, p1);
        List<Person> expectedList = Arrays.asList(p1, p4, p2, p3);

        List<Person> actualList = Week11.sortGeneric(unsortedList);

        boolean sorted = true;
        for (int i = 0; i < expectedList.size(); i++) {
            Person person1 = expectedList.get(i);
            Person person2 = actualList.get(i);
            if (person1.compareTo(person2) != 0) {
                sorted = false;
                break;
            }
        }

        assertTrue(sorted);
    }
}
