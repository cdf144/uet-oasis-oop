package Week9.BKT1_Abstract;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MotorBikeTest {
    @Test
    public void testConstructor1() {
        MotorBike motorBike = new MotorBike();
        assertFalse(motorBike.isHasSidecar());
    }

    @Test
    public void testConstructor2() {
        MotorBike motorBike = new MotorBike(true);
        assertTrue(motorBike.isHasSidecar());
    }

    @Test
    public void testConstructor3() {
        MotorBike motorBike = new MotorBike(
                "Honda", "Goldwing", "ABC123",
                new Person("John Doe", "123 Main St"), true
        );
        assertEquals("Honda", motorBike.getBrand());
        assertEquals("Goldwing", motorBike.getModel());
        assertEquals("ABC123", motorBike.getRegistrationNumber());
        assertEquals(new Person("John Doe", "123 Main St").getName(), motorBike.getOwner().getName());
        assertTrue(motorBike.isHasSidecar());
    }

    @Test
    public void testGetInfo() {
        MotorBike motorBike = new MotorBike(
                "Honda", "Goldwing", "ABC123",
                new Person("John Doe", "123 Main St"), true
        );
        String expectedInfo = "Motor Bike:\n"
                + "\t" + "Brand: Honda" + "\n"
                + "\t" + "Model: Goldwing" + "\n"
                + "\t" + "Registration Number: ABC123" + "\n"
                + "\t" + "Has Side Car: true" + "\n"
                + "\t" + "Belongs to John Doe - 123 Main St";
        assertEquals(expectedInfo, motorBike.getInfo());
    }
}

