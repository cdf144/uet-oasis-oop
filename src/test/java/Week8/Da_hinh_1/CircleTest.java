package Week8.Da_hinh_1;

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
        assertEquals("", circle.getColor());
        assertFalse(circle.isFilled());
    }

    @Test
    public void testConstructorWithRadius() {
        Circle circle = new Circle(5.0);
        double delta = 0.00000001;

        assertEquals(5.0, circle.getRadius(), delta);
        assertEquals("", circle.getColor());
        assertFalse(circle.isFilled());
    }

    @Test
    public void testConstructorWithRadiusColorAndFilled() {
        Circle circle = new Circle(5.0, "red", true);
        double delta = 0.00000001;

        assertEquals(5.0, circle.getRadius(), delta);
        assertEquals("red", circle.getColor());
        assertTrue(circle.isFilled());
    }

    @Test
    public void testSettersAndGetters() {
        Circle circle = new Circle();
        double delta = 0.00000001;

        circle.setRadius(5.0);
        assertEquals(5.0, circle.getRadius(), delta);

        circle.setColor("red");
        assertEquals("red", circle.getColor());

        circle.setFilled(true);
        assertTrue(circle.isFilled());
    }

    @Test
    public void testToString() {
        Circle circle = new Circle(5.0, null, true);
        assertEquals("Week10.Circle[radius=5.0,color=null,filled=true]", circle.toString());

        circle.setColor("");
        assertEquals("Week10.Circle[radius=5.0,color=null,filled=true]", circle.toString());

        circle.setColor("red");
        assertEquals("Week10.Circle[radius=5.0,color=red,filled=true]", circle.toString());
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
