package Week4_Quan_ly_sinh_vien;

public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    /**
     * Student class constructor.
     */
    public Student() {
        this.name = "Student";
        this.id = "000";
        this.group = "K62CB";
        this.email = "uet@vnu.edu.vn";
    }

    /**
     * Student class constructor 2.
     * @param email student email
     * @param name student name
     * @param id student id
     */
    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.group = "K62CB";
    }

    /**
     * Student class constructor 3.
     * @param s student name
     */
    public Student(Student s) {
        this.name = s.getName();
        this.id = s.getId();
        this.group = s.getGroup();
        this.email = s.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getId() {
        return id;
    }

    public void setId(String s) {
        this.id = s;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String s) {
        this.group = s;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String s) {
        this.email = s;
    }

    public String getInfo() {
        return String.format("%s - %s - %s - %s", name, id, group, email);
    }
}
