package Week4.Quan_ly_sinh_vien;

import java.util.*;

public class StudentManagement {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students;
    private int numberOfStudents = 0;

    public StudentManagement() {
        students = new Student[MAX_STUDENTS];
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Add student to students array.
     *
     * @param newStudent student to insert
     */
    public void addStudent(Student newStudent) {
        boolean exist = false;

        for (int i = 0; i < numberOfStudents; i++) {
            if (newStudent.equals(students[i])) {
                exist = true;
                break;
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

        for (int i = 0; i < numberOfStudents; i++) {
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
     *
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
}
