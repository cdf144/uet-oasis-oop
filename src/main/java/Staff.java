public class Staff extends Person {
    private String school;
    private double pay;

    /**
     * Staff constructor.
     * @param name Person name
     * @param address Person address
     * @param school Staff school
     * @param pay Staff pay
     */
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    /**
     * Staff toString.
     * @return A String for Staff
     */
    @Override
    public String toString() {
        return String.format("Staff[%s,school=%s,pay=%.1f]",
                super.toString(),
                this.school,
                this.pay
        );
    }
}
