package Week10.BKT2_Interface;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {
    double delta = 1e-9;

    @Test
    public void testConstructor1() {
        Circle circle = new Circle();
        assertEquals(0, circle.getRadius(), delta);
        assertEquals(0.0, circle.getCenter().getPointX(), delta);
        assertEquals(0.0, circle.getCenter().getPointY(), delta);
    }

    @Test
    public void testConstructor2() {
        Point center = new Point(1.0, 2.0);
        double radius = 3.0;
        Circle circle = new Circle(center, radius);
        assertEquals(radius, circle.getRadius(), delta);
        assertEquals(circle.getCenter(), center);
    }

    @Test
    public void testAreaCalculation() {
        Circle circle = new Circle(new Point(0, 0), 5.0);
        double expectedArea = Math.PI * Math.pow(5.0, 2);
        assertEquals(expectedArea, circle.getArea(), 0.1);
    }

    @Test
    public void testPerimeterCalculation() {
        Circle circle = new Circle(new Point(0, 0), 5.0);
        double expectedPerimeter = 2.0 * Math.PI * 5.0;
        assertEquals(expectedPerimeter, circle.getPerimeter(), 0.1);
    }

    @Test
    public void testInfoString() {
        Circle circle = new Circle(new Point(1.0, 2.0), 3.0);
        String expectedInfo = "Circle[(1.00,2.00),r=3.00]";
        assertEquals(expectedInfo, circle.getInfo());
    }
}

