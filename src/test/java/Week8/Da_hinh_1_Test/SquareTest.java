package Week8.Da_hinh_1_Test;

import Week8.Da_hinh_1.Square;

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
    public void testSettersAndGetters() {
        Square square = new Square();
        double delta = 0.00000001;

        square.setSide(5.0);
        assertEquals(5.0, square.getSide(), delta);
        assertEquals(5.0, square.getWidth(), delta);
        assertEquals(5.0, square.getLength(), delta);
    }

    @Test
    public void testToString() {
        Square square = new Square(5.0, null, false);
        assertEquals("Square[side=5.0,color=null,filled=false]", square.toString());
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
