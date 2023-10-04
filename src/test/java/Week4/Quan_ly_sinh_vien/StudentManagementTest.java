package Week4.Quan_ly_sinh_vien;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StudentManagementTest {
    private final StudentManagement studentManagement;

    public StudentManagementTest() {
        studentManagement = new StudentManagement();
    }

    @Test
    public void testSameGroup() {
        Student student1 = new Student("Alice", "123456789", "alice@example.com");
        Student student2 = new Student("Bob", "987654321", "bob@example.com");
        student1.setGroup("K62CB");
        student2.setGroup("K62CB");

        assertTrue(StudentManagement.sameGroup(student1, student2));

        student2.setGroup("K63CB");

        assertFalse(StudentManagement.sameGroup(student1, student2));
    }

    @Test
    public void testAddStudent() {
        Student student1 = new Student("Alice", "123456789", "alice@example.com");
        Student student2 = new Student("Bob", "987654321", "bob@example.com");

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);

        assertEquals(2, studentManagement.getNumberOfStudents());

        studentManagement.addStudent(student1); // duplicate student

        assertEquals(2, studentManagement.getNumberOfStudents());
    }

    @Test
    public void testStudentsByGroup() {
        Student student1 = new Student("Alice", "123456789", "alice@example.com");
        Student student2 = new Student("Bob", "987654321", "bob@example.com");
        Student student3 = new Student("Carol", "345678912", "carol@example.com");

        student1.setGroup("K62CB");
        student2.setGroup("K63CB");
        student3.setGroup("K62CB");

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);
        studentManagement.addStudent(student3);

        String expectedOutput =
                "K62CB\n" +
                "Alice - 123456789 - K62CB - alice@example.com\n" +
                "Carol - 345678912 - K62CB - carol@example.com\n" +
                "K63CB\n" +
                "Bob - 987654321 - K63CB - bob@example.com\n";

        assertEquals(expectedOutput, studentManagement.studentsByGroup());
    }

    @Test
    public void testRemoveStudent() {
        Student student1 = new Student("Alice", "123456789", "alice@example.com");
        Student student2 = new Student("Bob", "987654321", "bob@example.com");

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);

        assertEquals(2, studentManagement.getNumberOfStudents());

        studentManagement.removeStudent("123456789");

        assertEquals(1, studentManagement.getNumberOfStudents());

        studentManagement.removeStudent("987654321");

        assertEquals(0, studentManagement.getNumberOfStudents());
    }

    @Test
    public void testStudentManagement() {
        StudentManagement studentManage = new StudentManagement();

        Student student1 = new Student("Nguyen Van An", "17020001", "17020001@vnu.edu.vn");
        Student student2 = new Student("Nguyen Van B", "17020002", "17020002@vnu.edu.vn");

        final Student student3 = new Student("Nguyen Van C", "17020003", "17020003@vnu.edu.vn");
        final Student student4 = new Student("Nguyen Van D", "17020004", "17020004@vnu.edu.vn");

        student1.setGroup("K62CC");
        student2.setGroup("K62CC");

        studentManage.addStudent(student1);
        studentManage.addStudent(student3);
        studentManage.addStudent(student2);
        studentManage.addStudent(student3);
        studentManage.addStudent(student4);

        assertTrue(StudentManagement.sameGroup(student1, student2));
        assertFalse(StudentManagement.sameGroup(student1, student3));

        String expectedOutput1 =
                "K62CC\n" +
                "Nguyen Van An - 17020001 - K62CC - 17020001@vnu.edu.vn\n" +
                "Nguyen Van B - 17020002 - K62CC - 17020002@vnu.edu.vn\n" +
                "K62CB\n" +
                "Nguyen Van C - 17020003 - K62CB - 17020003@vnu.edu.vn\n" +
                "Nguyen Van D - 17020004 - K62CB - 17020004@vnu.edu.vn\n";

        assertEquals(expectedOutput1, studentManage.studentsByGroup());

        studentManage.removeStudent("17020003");
        String expectedOutput2 =
                "K62CC\n" +
                "Nguyen Van An - 17020001 - K62CC - 17020001@vnu.edu.vn\n" +
                "Nguyen Van B - 17020002 - K62CC - 17020002@vnu.edu.vn\n" +
                "K62CB\n" +
                "Nguyen Van D - 17020004 - K62CB - 17020004@vnu.edu.vn\n";

        assertEquals(expectedOutput2, studentManage.studentsByGroup());
    }
}
