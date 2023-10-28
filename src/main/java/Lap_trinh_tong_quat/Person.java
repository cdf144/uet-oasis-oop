package Lap_trinh_tong_quat;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String address;

    /**
     * Person constructor 1.
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.address = "";
    }

    /**
     * Person constructor 2.
     * @param name Person name
     * @param age Person age
     * @param address Person address
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Person compareTo method override.
     * @param o the object to be compared.
     * @return Comparison int
     */
    @Override
    public int compareTo(Person o) {
        int nameCompare = this.name.compareTo(o.getName());
        return nameCompare != 0
                ? nameCompare
                : Integer.compare(this.age, o.getAge());
    }
}
