public class Person {
    private String name;
    private String address;

    /**
     * Person constructor.
     * @param name Person name
     * @param address Person address
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Person toString.
     * @return A String for Person
     */
    public String toString() {
        return String.format("Person[name=%s,address=%s]",
                this.name,
                this.address
        );
    }
}
