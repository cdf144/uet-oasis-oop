package Week8.Da_hinh_1_Test;

import Week8.Da_hinh_1.Rectangle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void testConstructor() {
        Rectangle rectangle = new Rectangle();
        double delta = 0.00000001;

        assertEquals(0.0, rectangle.getWidth(), delta);
        assertEquals(0.0, rectangle.getLength(), delta);
    }

    @Test
    public void testConstructorWithWidthAndLength() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        double delta = 0.00000001;

        assertEquals(5.0, rectangle.getWidth(), delta);
        assertEquals(10.0, rectangle.getLength(), delta);
    }

    @Test
    public void testConstructorWithWidthLengthColorFilled() {
        Rectangle rectangle = new Rectangle(5.0, 10.0, null, false);
        double delta = 0.00000001;

        assertEquals(5.0, rectangle.getWidth(), delta);
        assertEquals(10.0, rectangle.getLength(), delta);
    }

    @Test
    public void testSettersAndGetters() {
        Rectangle rectangle = new Rectangle();
        double delta = 0.00000001;

        rectangle.setWidth(5.0);
        assertEquals(5.0, rectangle.getWidth(), delta);

        rectangle.setLength(10.0);
        assertEquals(10.0, rectangle.getLength(), delta);
    }

    @Test
    public void testToString() {
        Rectangle rectangle = new Rectangle(5.0, 10.0, null, false);
        assertEquals("Rectangle[width=5.0,length=10.0,color=null,filled=false]", rectangle.toString());
    }

    @Test
    public void testGetArea() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);

        double expectedArea = 5.0 * 10.0;
        double actualArea = rectangle.getArea();

        assertEquals(expectedArea, actualArea, 0.001);
    }

    @Test
    public void testGetPerimeter() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);

        double expectedPerimeter = 2.0 * (5.0 + 10.0);
        double actualPerimeter = rectangle.getPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, 0.001);
    }
}
