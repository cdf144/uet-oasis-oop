package Week7.Ke_thua_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testConstructor() {
        Person person = new Person("Alice", "123 Main Street");
        assertEquals("Alice", person.getName());
        assertEquals("123 Main Street", person.getAddress());
    }

    @Test
    public void testGettersAndSetters() {
        Person person = new Person("Alice", "123 Main Street");
        person.setName("Bob");
        person.setAddress("456 Elm Street");
        assertEquals("Bob", person.getName());
        assertEquals("456 Elm Street", person.getAddress());
    }

    @Test
    public void testToString() {
        Person person = new Person("Alice", "123 Main Street");
        assertEquals(
                "Person[name=Alice,address=123 Main Street]",
                person.toString());
    }
}
