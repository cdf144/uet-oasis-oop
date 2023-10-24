package Week11.Ngoai_le_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Week8Task2Test {
    Week8Task2 test = new Week8Task2();

    @Test
    public void testArithmeticEx() {
        String expected = "Lỗi Arithmetic";
        String actual = test.arithmeticExTest();

        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOutOfBoundsEx() {
        String expected = "Lỗi Array Index Out of Bounds";
        String actual = test.arrayIndexOutOfBoundsExTest();

        assertEquals(expected, actual);
    }

    @Test
    public void testFileNotFoundEx() {
        String expected = "Lỗi File Not Found";
        String actual = test.fileNotFoundExTest();

        assertEquals(expected, actual);
    }

    @Test
    public void testIOEx() {
        String expected = "Lỗi IO";
        String actual = test.ioExTest();

        assertEquals(expected, actual);
    }

    @Test
    public void testNullPointerEx() {
        String expected = "Lỗi Null Pointer";
        String actual = test.nullPointerExTest();

        assertEquals(expected, actual);
    }
}
