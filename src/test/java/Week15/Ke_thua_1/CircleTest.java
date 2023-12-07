package Week15.Ke_thua_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {
    @Test
    public void testConstructor1() {
        Circle circle = new Circle();
        assertEquals(0, circle.getRadius(), 0.001);
        assertEquals("", circle.getColor());
    }

    @Test
    public void testConstructor2() {
        double radius = 5;
        Circle circle = new Circle(radius);
        assertEquals(radius, circle.getRadius(), 0.001);
        assertEquals("", circle.getColor());
    }

    @Test
    public void testConstructor3() {
        double radius = 3;
        String color = "red";
        Circle circle = new Circle(radius, color);
        assertEquals(radius, circle.getRadius(), 0.001);
        assertEquals(color, circle.getColor());
    }

    @Test
    public void testGettersAndSetters() {
        Circle circle = new Circle(2, "blue");
        circle.setRadius(4);
        circle.setColor("green");
        assertEquals(4, circle.getRadius(), 0.001);
        assertEquals("green", circle.getColor());
    }

    @Test
    public void testGetArea() {
        Circle circle = new Circle(5);
        assertEquals(78.54, circle.getArea(), 0.001);
    }

    @Test
    public void testToString() {
        Circle circle = new Circle(3, "yellow");
        assertEquals("Circle[radius=3.0,color=yellow]", circle.toString());
    }
}
