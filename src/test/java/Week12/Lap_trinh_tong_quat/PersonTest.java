package Week12.Lap_trinh_tong_quat;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {

    @Test
    public void testConstructor1() {
        Person person = new Person();
        assertEquals("", person.getName());
        assertEquals(0, person.getAge());
        assertEquals("", person.getAddress());
    }

    @Test
    public void testConstructor2() {
        String name = "John Doe";
        int age = 30;
        String address = "123 Main Street";
        Person person = new Person(name, age, address);
        assertEquals(name, person.getName());
        assertEquals(age, person.getAge());
        assertEquals(address, person.getAddress());
    }

    @Test
    public void testGettersAndSetters() {
        Person person = new Person("Jane Doe", 25, "456 Elm Street");
        person.setName("Alice");
        person.setAge(20);
        person.setAddress("789 Oak Street");
        assertEquals("Alice", person.getName());
        assertEquals(20, person.getAge());
        assertEquals("789 Oak Street", person.getAddress());
    }

    @Test
    public void testCompareTo() {
        Person person1 = new Person("Alice", 20, "123 Main Street");
        Person person2 = new Person("Bob", 25, "456 Elm Street");
        Person person3 = new Person("Alice", 20, "456 Elm Street");

        assertTrue(person1.compareTo(person2) < 0);
        assertEquals(0, person1.compareTo(person3));
        assertTrue(person2.compareTo(person1) > 0);
    }
}

