package Week9.BKT1_Abstract;

public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    public MotorBike() {
        super();
        this.hasSidecar = false;
    }

    public MotorBike(boolean hasSidecar) {
        super();
        this.hasSidecar = hasSidecar;
    }

    public MotorBike(String brand, String model,
                     String registrationNumber, Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    /**
     * Get motorbike info.
     *
     * @return motorbike info string
     */
    public String getInfo() {
        return "Motor Bike:\n"
                + "\t" + String.format("Brand: %s", brand) + "\n"
                + "\t" + String.format("Model: %s", model) + "\n"
                + "\t" + String.format("Registration Number: %s", registrationNumber) + "\n"
                + "\t" + String.format("Has Side Car: %s", hasSidecar)
                + "\t" + String.format("Belongs to %s - %s", owner.getName(), owner.getAddress());
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
