package Week9.BKT1_Abstract;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    @Test
    public void testConstructor1() {
        Car car = new Car();
        assertEquals(0, car.getNumberOfDoors());
    }

    @Test
    public void testConstructor2() {
        int numberOfDoors = 4;
        Car car = new Car(numberOfDoors);
        assertEquals(numberOfDoors, car.getNumberOfDoors());
    }

    @Test
    public void testConstructor3() {
        Car car = new Car(
                "Toyota", "Camry", "789GHI",
                new Person("Mike Smith", "789 Oak St"), 4
        );
        assertEquals("Toyota", car.getBrand());
        assertEquals("Camry", car.getModel());
        assertEquals("789GHI", car.getRegistrationNumber());
        assertEquals(new Person("Mike Smith", "789 Oak St").getAddress(), car.getOwner().getAddress());
        assertEquals(4, car.getNumberOfDoors());
    }

    @Test
    public void testGetInfo() {
        Car car = new Car(
                "Toyota", "Camry", "789GHI",
                new Person("Mike Smith", "789 Oak St"), 4
        );
        String expectedInfo = "Car:\n"
                + "\t" + "Brand: Toyota" + "\n"
                + "\t" + "Model: Camry" + "\n"
                + "\t" + "Registration Number: 789GHI" + "\n"
                + "\t" + "Number of Doors: 4" + "\n"
                + "\t" + "Belongs to Mike Smith - 789 Oak St";
        assertEquals(expectedInfo, car.getInfo());
    }
}


