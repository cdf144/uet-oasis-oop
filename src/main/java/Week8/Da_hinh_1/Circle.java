package Week8.Da_hinh_1;

import java.util.Objects;

public class Circle extends Shape {
    protected double radius;

    /**
     * Circle constructor 1.
     */
    public Circle() {
        super();
        this.radius = 0;
    }

    /**
     * Circle constructor 2.
     *
     * @param radius Circle radius
     */
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    /**
     * Circle constructor 3.
     *
     * @param radius Circle radius
     * @param color  Shape color
     * @param filled Shape is filled
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calculate circle area.
     *
     * @return circle area
     */
    public double getArea() {
        final double PI = 3.1415926535;
        return PI * this.radius * this.radius;
    }

    /**
     * Calculate circle perimeter.
     *
     * @return circle perimeter
     */
    public double getPerimeter() {
        final double PI = 3.1415926535;
        return 2 * PI * this.radius;
    }

    /**
     * Circle toString override.
     *
     * @return Circle string
     */
    @Override
    public String toString() {
        return String.format("Circle[radius=%.1f,color=%s,filled=%s]",
                this.radius,
                (Objects.equals(this.color, "")
                        ? "null" : this.color),
                this.filled
        );
    }
}
