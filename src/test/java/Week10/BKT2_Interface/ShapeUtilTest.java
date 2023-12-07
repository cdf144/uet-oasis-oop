package Week10.BKT2_Interface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShapeUtilTest {
    @Test
    public void testPrintInfoEmptyList() {
        ShapeUtil util = new ShapeUtil();
        String expectedInfo = "";
        assertEquals(expectedInfo, util.printInfo(null));
    }

    @Test
    public void testPrintInfoOneCircle() {
        ShapeUtil util = new ShapeUtil();
        List<GeometricObject> shapes = new ArrayList<>();
        Circle circle = new Circle(new Point(0, 0), 5);
        shapes.add(circle);
        String expectedInfo = "Circle:\n" + circle.getInfo() + "\n";
        assertEquals(expectedInfo, util.printInfo(shapes));
    }

    @Test
    public void testPrintInfoOneTriangle() {
        ShapeUtil util = new ShapeUtil();
        List<GeometricObject> shapes = new ArrayList<>();
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 4), new Point(5, 0));
        shapes.add(triangle);
        String expectedInfo = "Triangle:\n" + triangle.getInfo() + "\n";
        assertEquals(expectedInfo, util.printInfo(shapes));
    }

    @Test
    public void testPrintInfoMultipleShapes() {
        ShapeUtil util = new ShapeUtil();
        List<GeometricObject> shapes = new ArrayList<>();
        Circle circle1 = new Circle(new Point(0, 0), 5);
        Circle circle2 = new Circle(new Point(1, 2), 3);
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 4), new Point(5, 0));
        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(triangle);
        String expectedInfo = "Circle:\n" + circle1.getInfo() + "\n" + circle2.getInfo() + "\nTriangle:\n" + triangle.getInfo() + "\n";
        assertEquals(expectedInfo, util.printInfo(shapes));
    }
}
