package Week9;

public class MotorBike extends Vehicle{
    private boolean hasSidecar;

    public MotorBike() {
        super();
        this.hasSidecar = false;
    }

    public MotorBike(boolean hasSidecar) {
        super();
        this.hasSidecar = hasSidecar;
    }

    public MotorBike(String brand, String model, String registrationNumber, Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    public String getInfo() {
        StringBuilder motorBikeInfo = new StringBuilder();
        motorBikeInfo.append("Motor Bike:\n");
        motorBikeInfo.append("\t")
                .append(String.format("Brand: %s",
                        this.brand)
                )
                .append("\n");
        motorBikeInfo.append("\t")
                .append(String.format("Model: %s",
                        this.model)
                )
                .append("\n");
        motorBikeInfo.append("\t")
                .append(String.format("Registration Number: %s",
                        this.registrationNumber)
                )
                .append("\n");
        motorBikeInfo.append("\t")
                .append(String.format("Has Side Car: %s",
                        this.hasSidecar)
                )
                .append("\n");
        motorBikeInfo.append("\t")
                .append(String.format("Belongs to %s - %s",
                        this.owner.getName(),
                        this.owner.getAddress())
                );
        return motorBikeInfo.toString();
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
