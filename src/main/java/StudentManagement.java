import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentManagement {
    private static final int MAX_STUDENTS = 100;
    private static final Student[] students = new Student[MAX_STUDENTS];
    private static int numberOfStudents = 0;

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Add student to students array.
     * @param newStudent student to insert
     */
    public void addStudent(Student newStudent) {
        boolean exist = false;

        for (int i = 0; i < numberOfStudents; ++i) {
            if (Objects.equals(newStudent.getName(), students[i].getName())
                    && Objects.equals(newStudent.getId(), students[i].getId())
                    && Objects.equals(newStudent.getEmail(), students[i].getEmail())) {
                exist = true;
            }
        }

        if (!exist) {
            if (numberOfStudents < MAX_STUDENTS) {
                students[numberOfStudents++] = newStudent;
            }
        }
    }

    /**
     * Print student by group.
     */
    public String studentsByGroup() {
        StringBuilder output = new StringBuilder();
        Map<String, List<Student>> studentGroupMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfStudents; ++i) {
            if (students[i] != null) {
                String group = students[i].getGroup();
                if (studentGroupMap.get(group) == null) {
                    List<Student> listStudent = new ArrayList<>();
                    listStudent.add(students[i]);
                    studentGroupMap.put(group, listStudent);
                } else {
                    studentGroupMap.get(group).add(students[i]);
                }
            }
        }

        for (String group : studentGroupMap.keySet()) {
            output.append(group).append("\n");
            List<Student> listStudent = studentGroupMap.get(group);
            for (Student student : listStudent) {
                output.append(student.getInfo()).append("\n");
            }
        }
        return output.toString();
    }

    /**
     * Remove student from array.
     * @param id student's id to remove
     */
    public void removeStudent(String id) {
        for (int i = 0; i < numberOfStudents; ++i) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < numberOfStudents - 1; ++j) {
                    students[j] = students[j + 1];
                }
                numberOfStudents--;
                return;
            }
        }
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();

        Student student1 = new Student("Nguyen Van An", "17020001", "17020001@vnu.edu.vn");
        Student student2 = new Student("Nguyen Van B", "17020002", "17020002@vnu.edu.vn");

        final Student student3 = new Student("Nguyen Van C", "17020003", "17020003@vnu.edu.vn");
        final Student student4 = new Student("Nguyen Van D", "17020004", "17020004@vnu.edu.vn");

        student1.setGroup("K62CC");
        student2.setGroup("K62CC");

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student3);
        studentManagement.addStudent(student2);
        studentManagement.addStudent(student3);
        studentManagement.addStudent(student4);

        boolean areInSameGroup = StudentManagement.sameGroup(student1, student2);
        if (areInSameGroup) {
          System.out.println("Student 1 and 2 are in the same group.");
        } else {
          System.out.println("Student 1 and 2 are not in the same group.");
        }

        System.out.println(studentManagement.studentsByGroup());

        studentManagement.removeStudent("17020003");
        System.out.println(studentManagement.studentsByGroup());
    }
}
