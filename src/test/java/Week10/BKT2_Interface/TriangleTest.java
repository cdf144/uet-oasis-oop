package Week10.BKT2_Interface;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TriangleTest {
    double delta = 1e-9;

    @Test
    public void testConstructor1() {
        Triangle triangle = new Triangle();
        assertEquals(0.0, triangle.getP1().getPointX(), delta);
        assertEquals(0.0, triangle.getP1().getPointY(), delta);
        assertEquals(0.0, triangle.getP2().getPointX(), delta);
        assertEquals(0.0, triangle.getP2().getPointY(), delta);
        assertEquals(0.0, triangle.getP3().getPointX(), delta);
        assertEquals(0.0, triangle.getP3().getPointY(), delta);
    }

    @Test
    public void testConstructor2ValidPoints() {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Point p3 = new Point(5.0, 2.0);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertEquals(triangle.getP1(), p1);
        assertEquals(triangle.getP2(), p2);
        assertEquals(triangle.getP3(), p3);
    }

    @Test
    public void testConstructor2InvalidPointsSamePoint() {
        Point p1 = new Point(1.0, 2.0);
        assertThrows(RuntimeException.class, () -> new Triangle(p1, p1, new Point(3.0, 4.0)));
    }

    @Test
    public void testConstructor2InvalidPointsStraightLine() {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(1.0, 1.0);
        Point p3 = new Point(2.0, 2.0);
        assertThrows(RuntimeException.class, () -> new Triangle(p1, p2, p3));
    }

    @Test
    public void testAreaCalculation() {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(4.0, 0.0), new Point(2.0, 3.4641));
        double expectedArea = 6.9282;
        assertEquals(expectedArea, triangle.getArea(), delta);
    }

    @Test
    public void testPerimeterCalculation() {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(4.0, 0.0), new Point(2.0, 3.4641));
        double expectedPerimeter = 11.999997202;
        assertEquals(expectedPerimeter, triangle.getPerimeter(), delta);
    }
}
