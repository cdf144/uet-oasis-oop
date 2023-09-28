package Week7;

import Week7_Ke_thua_2.Student;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void testConstructor() {
        Student student = new Student("Alice", "123 Main Street",
                "Computer Science", 1, 10000);
        double delta = 0.00000001;
        assertEquals("Alice", student.getName());
        assertEquals("123 Main Street", student.getAddress());
        assertEquals("Computer Science", student.getProgram());
        assertEquals(1, student.getYear());
        assertEquals(10000, student.getFee(), delta);
    }

    @Test
    public void testGettersAndSetters() {
        Student student = new Student("Alice", "123 Main Street",
                "Computer Science", 1, 10000);
        student.setProgram("Information Systems");
        student.setYear(2);
        student.setFee(12000);
        double delta = 0.00000001;

        assertEquals("Information Systems", student.getProgram());
        assertEquals(2, student.getYear());
        assertEquals(12000, student.getFee(), delta);
    }

    @Test
    public void testToString() {
        Student student = new Student("Alice", "123 Main Street",
                "Computer Science", 1, 10000);
        assertEquals(
                "Student[Person[name=Alice,address=123 Main Street],program=Computer Science,year=1,fee=10000.0]",
                student.toString());
    }
}
