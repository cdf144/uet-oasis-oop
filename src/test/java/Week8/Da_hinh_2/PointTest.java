package Week8.Da_hinh_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void testGettersAndSetters() {
        Point point = new Point();
        double delta = 0.00000001;

        point.setPointX(1.0);
        assertEquals(1.0, point.getPointX(), delta);

        point.setPointY(2.0);
        assertEquals(2.0, point.getPointY(), delta);
    }

    @Test
    public void testDistance() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(3.0, 5.0);

        double expectedDistance = Math.sqrt(13.0);
        double actualDistance = point1.distance(point2);

        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test
    public void testEquals() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);

        assertEquals(point1, point2);
    }

    @Test
    public void testHashCode() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);

        assertEquals(point1.hashCode(), point2.hashCode());
    }
}
