import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Layer {
    private List<Shape> shapes;

    public Layer() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Get info of layer.
     * @return layer string info
     */
    public String getInfo() {
        StringBuilder s = new StringBuilder();
        s.append("Layer of crazy shapes:");
        for (Shape shape : shapes) {
            s.append("\n").append(shape.toString());
        }
        return s.toString();
    }

    public void removeCircles() {
        shapes.removeIf(shape -> shape instanceof Circle);
    }

    /**
     * Remove duplicates from shape list.
     */
    public void removeDuplicates() {
        LinkedHashSet<Shape> shapeSet = new LinkedHashSet<>(shapes);
        this.shapes = new ArrayList<>(shapeSet);
    }
}
