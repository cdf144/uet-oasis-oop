package Week9.BKT1_Abstract;

public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Car constructor 1.
     */
    public Car() {
        super();
        this.numberOfDoors = 0;
    }

    /**
     * Car constructor 2.
     *
     * @param numberOfDoors number of car doors
     */
    public Car(int numberOfDoors) {
        super();
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Car constructor 3.
     *
     * @param brand              car brand
     * @param model              car model
     * @param registrationNumber car reg number
     * @param owner              car owner
     * @param numberOfDoors      number of car doors
     */
    public Car(String brand, String model,
               String registrationNumber, Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Get car info.
     *
     * @return string of car info
     */
    public String getInfo() {
        return "Car:\n" +
                "\t" +
                String.format("Brand: %s",
                        this.brand) +
                "\n" +
                "\t" +
                String.format("Model: %s",
                        this.model) +
                "\n" +
                "\t" +
                String.format("Registration Number: %s",
                        this.registrationNumber) +
                "\n" +
                "\t" +
                String.format("Number of Doors: %s",
                        this.numberOfDoors) +
                "\n" +
                "\t" +
                String.format("Belongs to %s - %s",
                        this.owner.getName(),
                        this.owner.getAddress());
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
