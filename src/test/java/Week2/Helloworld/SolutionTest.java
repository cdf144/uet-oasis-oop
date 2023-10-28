package Week2.Helloworld;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(printStream);
    }

    @Test
    public void testSolution() {
        String expectedOutput = "HelloWorld";
        String[] dummyArgs = {};

        Solution.main(dummyArgs);
        assertEquals(expectedOutput, outputStream.toString());
    }
}
