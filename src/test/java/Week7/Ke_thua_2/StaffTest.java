package Week7.Ke_thua_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaffTest {
    @Test
    public void testConstructor() {
        Staff staff = new Staff("Alice", "123 Main Street",
                "Stanford University", 100000);
        double delta = 0.00000001;

        assertEquals("Alice", staff.getName());
        assertEquals("123 Main Street", staff.getAddress());
        assertEquals("Stanford University", staff.getSchool());
        assertEquals(100000, staff.getPay(), delta);
    }

    @Test
    public void testGettersAndSetters() {
        Staff staff = new Staff("Alice", "123 Main Street",
                "Stanford University", 100000);
        staff.setSchool("MIT");
        staff.setPay(120000);
        double delta = 0.00000001;

        assertEquals("MIT", staff.getSchool());
        assertEquals(120000, staff.getPay(), delta);
    }

    @Test
    public void testToString() {
        Staff staff = new Staff("Alice", "123 Main Street",
                "Stanford University", 100000);
        assertEquals(
                "Staff[Person[name=Alice,address=123 Main Street],school=Stanford University,pay=100000.0]",
                staff.toString());
    }
}
