package Week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList;

    /**
     * Person constructor 1.
     */
    public Person() {
        this.name = "";
        this.address = "";
        this.vehicleList = new ArrayList<>();
    }

    /**
     * Person constructor 2.
     * @param name person name
     * @param address person address
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        vehicleList = new ArrayList<>();
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

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        for (Vehicle vehicle : this.vehicleList) {
            if (Objects.equals(vehicle.getRegistrationNumber(), registrationNumber)) {
                this.vehicleList.remove(vehicle);
                break;
            }
        }
    }

    public String getVehicleInfo() {
        StringBuilder vehicleInfo = new StringBuilder();
        vehicleInfo.append(String.format("%s has", this.name));

        if (Objects.isNull(this.vehicleList)) {
            vehicleInfo.append(" no vehicle!");
            return vehicleInfo.toString();
        } else {
            if (this.vehicleList.isEmpty()) {
                vehicleInfo.append(" no vehicle!");
                return vehicleInfo.toString();
            }
        }

        vehicleInfo.append(":").append("\n\n");
        for (Vehicle vehicle : this.vehicleList) {
            vehicleInfo.append(vehicle.getInfo()).append("\n");
        }

        return vehicleInfo.toString();
    }
}
