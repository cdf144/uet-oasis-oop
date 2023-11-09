package Week8.Da_hinh_2;

import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    /**
     * Rectangle constructor 1.
     */
    public Rectangle() {
        super();
        this.topLeft = new Point();
        this.width = 0.0;
        this.length = 0.0;
    }

    /**
     * Rectangle constructor 2.
     *
     * @param width  Rectangle width
     * @param length Rectangle length
     */
    public Rectangle(double width, double length) {
        super();
        this.topLeft = new Point();
        this.width = width;
        this.length = length;
    }

    /**
     * Rectangle constructor 3.
     *
     * @param width  Rectangle width
     * @param length Rectangle length
     * @param color  Shape color
     * @param filled Shape is filled
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = new Point();
        this.width = width;
        this.length = length;
    }

    /**
     * Rectangle constructor 4.
     *
     * @param topLeft topLeft
     * @param width   width
     * @param length  length
     * @param color   color
     * @param filled  filled
     */
    public Rectangle(Point topLeft, double width, double length,
                     String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * width + 2 * length;
    }

    /**
     * Rectangle toString override.
     *
     * @return Rectangle string
     */
    @Override
    public String toString() {
        return String.format(
                "Rectangle[topLeft=%s,width=%.1f,length=%.1f,color=%s,filled=%s]",
                this.topLeft.toString(),
                this.width,
                this.length,
                (Objects.equals(this.color, "")
                        ? "null" : this.color),
                this.filled
        );
    }

    /**
     * Boolean if 2 rectangles are equal, not counting
     * color and filled.
     *
     * @param o another object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            Rectangle another = (Rectangle) o;
            return Math.abs(this.width - another.getWidth())
                    <= 0.001
                    && Math.abs(this.length - another.getLength())
                    <= 0.001
                    && this.topLeft.equals(another.getTopLeft());
        }
        return false;
    }

    /**
     * Rectangle hashcode, not taking into account color
     * and filled.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, length);
    }
}
