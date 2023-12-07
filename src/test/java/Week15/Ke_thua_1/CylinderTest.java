package Week15.Ke_thua_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CylinderTest {
    double delta = 1e-9;

    @Test
    public void testConstructor1() {
        Cylinder cylinder = new Cylinder(5);
        assertEquals(0, cylinder.getRadius(), 0.001);
        assertEquals("", cylinder.getColor());
        assertEquals(5, cylinder.getHeight(), 0.001);
    }

    @Test
    public void testConstructor2() {
        double radius = 2;
        double height = 10;
        Cylinder cylinder = new Cylinder(radius, height);
        assertEquals(radius, cylinder.getRadius(), 0.001);
        assertEquals("", cylinder.getColor());
        assertEquals(height, cylinder.getHeight(), 0.001);
    }

    @Test
    public void testConstructor3() {
        double radius = 4;
        double height = 6;
        String color = "orange";
        Cylinder cylinder = new Cylinder(radius, height, color);
        assertEquals(radius, cylinder.getRadius(), 0.001);
        assertEquals(color, cylinder.getColor());
        assertEquals(height, cylinder.getHeight(), 0.001);
    }

    @Test
    public void testGettersAndSetters() {
        Cylinder cylinder = new Cylinder(1, 3, "purple");
        cylinder.setRadius(2);
        cylinder.setHeight(7);
        cylinder.setColor("pink");
        assertEquals(2, cylinder.getRadius(), 0.001);
        assertEquals("pink", cylinder.getColor());
        assertEquals(7, cylinder.getHeight(), 0.001);
    }

    @Test
    public void testGetArea() {
        Cylinder cylinder = new Cylinder(2, 4);
        assertEquals(75.398223684, cylinder.getArea(), delta);
    }

    @Test
    public void testGetVolume() {
        Cylinder cylinder = new Cylinder(3, 5);
        assertEquals(141.371669407, cylinder.getVolume(), delta);
    }

    @Test
    public void testToString() {
        Cylinder cylinder = new Cylinder(5, 8, "magenta");
        assertEquals("Cylinder[Circle[radius=5.0,color=magenta],height=8.0]", cylinder.toString());
    }
}
