package Week4.Quan_ly_sinh_vien;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void testConstructor() {
        Student student = new Student();

        assertEquals("Student", student.getName());
        assertEquals("000", student.getId());
        assertEquals("K62CB", student.getGroup());
        assertEquals("uet@vnu.edu.vn", student.getEmail());
    }

    @Test
    public void testConstructorWithParams() {
        Student student = new Student("Alice", "123456789", "alice@example.com");

        assertEquals("Alice", student.getName());
        assertEquals("123456789", student.getId());
        assertEquals("K62CB", student.getGroup());
        assertEquals("alice@example.com", student.getEmail());
    }

    @Test
    public void testCopyConstructor() {
        Student student1 = new Student("Alice", "123456789", "alice@example.com");
        Student student2 = new Student(student1);

        assertEquals("Alice", student2.getName());
        assertEquals("123456789", student2.getId());
        assertEquals("K62CB", student2.getGroup());
        assertEquals("alice@example.com", student2.getEmail());
    }

    @Test
    public void testGettersAndSetters() {
        Student student = new Student();

        student.setName("Bob");
        student.setId("987654321");
        student.setGroup("K63CB");
        student.setEmail("bob@example.com");

        assertEquals("Bob", student.getName());
        assertEquals("987654321", student.getId());
        assertEquals("K63CB", student.getGroup());
        assertEquals("bob@example.com", student.getEmail());
    }

    @Test
    public void testGetInfo() {
        Student student = new Student("Alice", "123456789", "alice@example.com");

        assertEquals("Alice - 123456789 - K62CB - alice@example.com", student.getInfo());
    }
}
