package Week9.BKT1_Abstract;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {
    @Test
    public void testConstructor1() {
        Person person = new Person();
        assertEquals("", person.getName());
        assertEquals("", person.getAddress());
        assertTrue(person.getVehicleList().isEmpty());
    }

    @Test
    public void testConstructor2() {
        String name = "John Doe";
        String address = "123 Main St";
        Person person = new Person(name, address);
        assertEquals(name, person.getName());
        assertEquals(address, person.getAddress());
        assertTrue(person.getVehicleList().isEmpty());
    }

    @Test
    public void testGettersAndSetters() {
        Person person = new Person("Jane Doe", "456 Elm St");
        person.setName("Jane Smith");
        person.setAddress("789 Oak St");
        assertEquals("Jane Smith", person.getName());
        assertEquals("789 Oak St", person.getAddress());
    }

    @Test
    public void testAddVehicleAndVehicleList() {
        Person person = new Person();
        Vehicle car = new Car(
                "Toyota", "Camry", "123ABC",
                new Person("John Doe", "123 Main St"), 4
        );
        Vehicle motorbike = new MotorBike(
                "Honda", "Rebel", "456DEF",
                new Person("Jane Doe", "456 Elm St"), true
        );
        person.addVehicle(car);
        person.addVehicle(motorbike);

        List<Vehicle> expectedVehicleList = new ArrayList<>();
        expectedVehicleList.add(car);
        expectedVehicleList.add(motorbike);

        assertEquals(expectedVehicleList, person.getVehicleList());
    }

    @Test
    public void testRemoveVehicle() {
        Person person = new Person();
        Vehicle car = new Car(
                "Toyota", "Camry", "123ABC",
                new Person("John Doe", "123 Main St"), 4
        );
        Vehicle motorbike = new MotorBike(
                "Honda", "Rebel", "456DEF",
                new Person("Jane Doe", "456 Elm St"), true
        );
        person.addVehicle(car);
        person.addVehicle(motorbike);

        person.removeVehicle("123ABC");

        List<Vehicle> expectedVehicleList = new ArrayList<>();
        expectedVehicleList.add(motorbike);

        assertEquals(expectedVehicleList, person.getVehicleList());
    }

    @Test
    public void testGetVehiclesInfoNoVehicle() {
        Person person = new Person("John Doe", "123 Main St");
        String expectedInfo = "John Doe has no vehicle!";
        assertEquals(expectedInfo, person.getVehiclesInfo());
    }

    @Test
    public void testGetVehiclesInfoWithVehicle() {
        Person person = new Person("Jane Doe", "456 Elm St");
        Vehicle car = new Car(
                "Toyota", "Corolla", "789GHI",
                new Person("Mike Smith", "789 Oak St"), 4
        );
        person.addVehicle(car);
        String expectedInfo = "Jane Doe has:" + "\n\n" + car.getInfo() + "\n";
        assertEquals(expectedInfo, person.getVehiclesInfo());
    }
}

