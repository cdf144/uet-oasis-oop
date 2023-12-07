package Week10.BKT2_Interface;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    double delta = 1e-9;

    @Test
    public void testConstructor1() {
        Point point = new Point();
        assertEquals(0, point.getPointX(), delta);
        assertEquals(0, point.getPointY(), delta);
    }

    @Test
    public void testConstructor2() {
        Point point = new Point(3, 4);
        assertEquals(3, point.getPointX(), delta);
        assertEquals(4, point.getPointY(), delta);
    }

    @Test
    public void testGettersAndSetters() {
        Point point = new Point(1, 2);
        point.setPointX(5);
        point.setPointY(10);
        assertEquals(5, point.getPointX(), delta);
        assertEquals(10, point.getPointY(), delta);
    }

    @Test
    public void testDistance() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 4);
        assertEquals(5, point1.distance(point2), delta);
    }

    @Test
    public void testToString() {
        Point point = new Point(1.5, 2.75);
        assertEquals("(1.50,2.75)", point.toString());
    }

    @Test
    public void testEquals() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        assertEquals(point1, point2);
    }
}

