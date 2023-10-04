package Week8.Da_hinh_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LayerTest {

    @Test
    public void testAddShape() {
        Layer layer = new Layer();

        Shape square = new Square(new Point(1.0, 2.0), 5.0, null, false);
        layer.addShape(square);

        assertEquals(1, layer.getShapes().size());
        assertEquals(square, layer.getShapes().get(0));
    }

    @Test
    public void testGetInfo() {
        Layer layer = new Layer();

        Shape square1 = new Square(new Point(1.0, 2.0), 5.0, null, false);
        layer.addShape(square1);

        Shape square2 = new Square(new Point(3.0, 4.0), 7.0, null, false);
        layer.addShape(square2);

        String expectedInfo = "Layer of crazy shapes:\n" +
                "Square[topLeft=(1.0,2.0),side=5.0,color=null,filled=false]\n" +
                "Square[topLeft=(3.0,4.0),side=7.0,color=null,filled=false]";

        assertEquals(expectedInfo, layer.getInfo());
    }

    @Test
    public void testRemoveCircles() {
        Layer layer = new Layer();

        Shape circle = new Circle(new Point(5.0, 6.0), 3.0, null, false);
        layer.addShape(circle);

        Shape square = new Square(new Point(7.0, 8.0), 4.0, null, false);
        layer.addShape(square);

        layer.removeCircles();

        assertEquals(1, layer.getShapes().size());
        assertEquals(square, layer.getShapes().get(0));
    }

    @Test
    public void testRemoveDuplicates() {
        Layer layer = new Layer();

        Shape square1 = new Square(new Point(1.0, 2.0), 5.0, null, false);
        layer.addShape(square1);

        Shape square2 = new Square(new Point(3.0, 4.0), 7.0, null, false);
        layer.addShape(square2);

        Shape square3 = new Square(new Point(1.0, 2.0), 5.0, "blue", true);
        layer.addShape(square3);

        layer.removeDuplicates();

        assertEquals(2, layer.getShapes().size());
        assertEquals(square1, layer.getShapes().get(0));
        assertEquals(square2, layer.getShapes().get(1));
    }
}
