package Week7.Ke_thua_2;

public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    /**
     * Student constructor.
     *
     * @param name    Person name
     * @param address Person address
     * @param program Student program
     * @param year    Student year
     * @param fee     Student fee
     */
    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * Student toString.
     *
     * @return A String for Student
     */
    @Override
    public String toString() {
        return String.format("Student[%s,program=%s,year=%d,fee=%.1f]",
                super.toString(),
                this.program,
                this.year,
                this.fee
        );
    }
}