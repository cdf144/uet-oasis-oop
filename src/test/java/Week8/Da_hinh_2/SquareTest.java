package Week8.Da_hinh_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquareTest {

    @Test
    public void testConstructor() {
        Square square = new Square();
        double delta = 0.00000001;

        assertEquals(0.0, square.getSide(), delta);
    }

    @Test
    public void testConstructorWithSide() {
        Square square = new Square(5.0);
        double delta = 0.00000001;

        assertEquals(5.0, square.getSide(), delta);
    }

    @Test
    public void testConstructorWithSideColorFilled() {
        Square square = new Square(5.0, "red", true);
        double delta = 0.00000001;

        assertEquals(5.0, square.getSide(), delta);
        assertEquals("red", square.getColor());
        assertTrue(square.isFilled());
    }

    @Test
    public void testConstructorWithTopLeftSide() {
        Point topLeft = new Point(1.0, 2.0);
        Square square = new Square(topLeft, 5.0, null, false);
        double delta = 0.00000001;

        assertEquals(5.0, square.getSide(), delta);
        assertEquals(topLeft, square.getTopLeft());
    }

    @Test
    public void testSettersAndGetters() {
        Square square = new Square();
        double delta = 0.00000001;

        Point topLeft = new Point(1.0, 2.0);
        square.setTopLeft(topLeft);
        assertEquals(topLeft, square.getTopLeft());

        square.setSide(5.0);
        assertEquals(5.0, square.getSide(), delta);
    }

    @Test
    public void testToString() {
        Point topLeft = new Point(1.0, 2.0);
        Square square = new Square(topLeft, 5.0, null, false);
        assertEquals("Square[topLeft=(1.0,2.0),side=5.0,color=null,filled=false]", square.toString());
    }

    @Test
    public void testEquals() {
        Point topLeft = new Point(1.0, 2.0);
        Square square1 = new Square(topLeft, 5.0, "red", true);
        Square square2 = new Square(topLeft, 5.0, "blue", false);

        assertEquals(square1, square2);
    }

    @Test
    public void testHashCode() {
        Point topLeft = new Point(1.0, 2.0);
        Square square1 = new Square(topLeft, 5.0, "red", true);
        Square square2 = new Square(topLeft, 5.0, "blue", false);

        assertEquals(square1.hashCode(), square2.hashCode());
    }

    @Test
    public void testGetArea() {
        Square square = new Square(5.0);

        double expectedArea = 5.0 * 5.0;
        double actualArea = square.getArea();

        assertEquals(expectedArea, actualArea, 0.001);
    }

    @Test
    public void testGetPerimeter() {
        Square square = new Square(5.0);

        double expectedPerimeter = 4.0 * 5.0;
        double actualPerimeter = square.getPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, 0.001);
    }
}
