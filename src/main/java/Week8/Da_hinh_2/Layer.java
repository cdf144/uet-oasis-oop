package Week8.Da_hinh_2;

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

  public List<Shape> getShapes() {
    return shapes;
  }

  /**
   * Get info of layer.
   *
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

  public static void main(String[] args) {
    Point point = new Point(5.0, 8.0);
    Shape s1 = new Square(point, 4.0, "", true);
    System.out.println(s1);
    Rectangle s2 = new Square(point, 2.5, "TRUE", true);
    System.out.println(s2);
  }
}
