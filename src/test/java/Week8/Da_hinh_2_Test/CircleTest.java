package Week8.Da_hinh_2_Test;

import Week8.Da_hinh_2.Circle;
import Week8.Da_hinh_2.Point;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CircleTest {

    @Test
    public void testConstructor() {
        Circle circle = new Circle();
        double delta = 0.00000001;

        assertEquals(0.0, circle.getRadius(), delta);
        assertEquals(new Point(), circle.getCenter());
        assertEquals("", circle.getColor());
        assertFalse(circle.isFilled());
    }

    @Test
    public void testConstructorWithRadius() {
        Circle circle = new Circle(5.0);
        double delta = 0.00000001;

        assertEquals(5.0, circle.getRadius(), delta);
        assertEquals(new Point(), circle.getCenter());
        assertEquals("", circle.getColor());
        assertFalse(circle.isFilled());
    }

    @Test
    public void testConstructorWithRadiusColorAndFilled() {
        Circle circle = new Circle(5.0, "red", true);
        double delta = 0.00000001;

        assertEquals(5.0, circle.getRadius(), delta);
        assertEquals(new Point(), circle.getCenter());
        assertEquals("red", circle.getColor());
        assertTrue(circle.isFilled());
    }

    @Test
    public void testConstructorWithRadiusCenterColorAndFilled() {
        Point center = new Point(1.0, 2.0);
        Circle circle = new Circle(center, 5.0, "red", true);
        double delta = 0.00000001;

        assertEquals(5.0, circle.getRadius(), delta);
        assertEquals(center, circle.getCenter());
        assertEquals("red", circle.getColor());
        assertTrue(circle.isFilled());
    }

    @Test
    public void testSettersAndGetters() {
        Circle circle = new Circle();
        double delta = 0.00000001;

        circle.setRadius(5.0);
        assertEquals(5.0, circle.getRadius(), delta);

        circle.setCenter(new Point(1.0, 2.0));
        assertEquals(new Point(1.0, 2.0), circle.getCenter());

        circle.setColor("red");
        assertEquals("red", circle.getColor());

        circle.setFilled(true);
        assertTrue(circle.isFilled());
    }

    @Test
    public void testToString() {
        Circle circle = new Circle(new Point(1.0, 2.0), 5.0, null, true);
        assertEquals("Circle[center=(1.0,2.0),radius=5.0,color=null,filled=true]", circle.toString());

        circle.setColor("");
        assertEquals("Circle[center=(1.0,2.0),radius=5.0,color=null,filled=true]", circle.toString());

        circle.setColor("red");
        assertEquals("Circle[center=(1.0,2.0),radius=5.0,color=red,filled=true]", circle.toString());
    }

    @Test
    public void testEquals() {
        Circle circle1 = new Circle(new Point(1.0, 2.0), 5.0, "red", true);
        Circle circle2 = new Circle(new Point(1.0, 2.0), 5.0, "blue", true);

        assertEquals(circle1, circle2);
    }

    @Test
    public void testHashCode() {
        Circle circle1 = new Circle(new Point(1.0, 2.0), 5.0, "red", true);
        Circle circle2 = new Circle(new Point(1.0, 2.0), 5.0, "blue", false);

        assertEquals(circle1.hashCode(), circle2.hashCode());
    }

    @Test
    public void testGetArea() {
        Circle circle = new Circle(5.0);

        double expectedArea = Math.PI * 5.0 * 5.0;
        double actualArea = circle.getArea();

        assertEquals(expectedArea, actualArea, 0.001);
    }

    @Test
    public void testGetPerimeter() {
        Circle circle = new Circle(5.0);

        double expectedPerimeter = 2.0 * Math.PI * 5.0;
        double actualPerimeter = circle.getPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, 0.001);
    }
}
