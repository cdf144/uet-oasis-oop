package Week8.Da_hinh_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void testConstructor() {
        Rectangle rectangle = new Rectangle();
        double delta = 0.00000001;

        assertEquals(new Point(), rectangle.getTopLeft());
        assertEquals(0.0, rectangle.getWidth(), delta);
        assertEquals(0.0, rectangle.getLength(), delta);
    }

    @Test
    public void testConstructorWithWidthAndLength() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        double delta = 0.00000001;

        assertEquals(new Point(), rectangle.getTopLeft());
        assertEquals(5.0, rectangle.getWidth(), delta);
        assertEquals(10.0, rectangle.getLength(), delta);
    }

    @Test
    public void testConstructorWithTopLeftWidthAndLength() {
        Point topLeft = new Point(1.0, 2.0);
        Rectangle rectangle = new Rectangle(topLeft, 5.0, 10.0, null, false);
        double delta = 0.00000001;

        assertEquals(topLeft, rectangle.getTopLeft());
        assertEquals(5.0, rectangle.getWidth(), delta);
        assertEquals(10.0, rectangle.getLength(), delta);
    }

    @Test
    public void testSettersAndGetters() {
        Rectangle rectangle = new Rectangle();
        double delta = 0.00000001;

        Point topLeft = new Point(1.0, 2.0);
        rectangle.setTopLeft(topLeft);
        assertEquals(topLeft, rectangle.getTopLeft());

        rectangle.setWidth(5.0);
        assertEquals(5.0, rectangle.getWidth(), delta);

        rectangle.setLength(10.0);
        assertEquals(10.0, rectangle.getLength(), delta);
    }

    @Test
    public void testToString() {
        Point topLeft = new Point(1.0, 2.0);
        Rectangle rectangle = new Rectangle(topLeft, 5.0, 10.0, null, false);
        assertEquals("Rectangle[topLeft=(1.0,2.0),width=5.0,length=10.0,color=null,filled=false]", rectangle.toString());
    }

    @Test
    public void testEquals() {
        Point topLeft = new Point(1.0, 2.0);
        Rectangle rectangle1 = new Rectangle(topLeft, 5.0, 10.0, "red", true);
        Rectangle rectangle2 = new Rectangle(topLeft, 5.0, 10.0, "blue", false);

        assertEquals(rectangle1, rectangle2);
    }

    @Test
    public void testHashCode() {
        Point topLeft = new Point(1.0, 2.0);
        Rectangle rectangle1 = new Rectangle(topLeft, 5.0, 10.0, "red", true);
        Rectangle rectangle2 = new Rectangle(topLeft, 5.0, 10.0, "blue", false);

        assertEquals(rectangle1.hashCode(), rectangle2.hashCode());
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
