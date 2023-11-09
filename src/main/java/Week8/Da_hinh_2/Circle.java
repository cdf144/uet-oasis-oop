package Week8.Da_hinh_2;

import java.util.Objects;

public class Circle extends Shape {
    protected Point center;
    protected double radius;

    /**
     * Week10.Circle constructor 1.
     */
    public Circle() {
        super();
        this.center = new Point();
        this.radius = 0;
    }

    /**
     * Week10.Circle constructor 2.
     *
     * @param radius Week10.Circle radius
     */
    public Circle(double radius) {
        super();
        this.center = new Point();
        this.radius = radius;
    }

    /**
     * Week10.Circle constructor 3.
     *
     * @param radius Week10.Circle radius
     * @param color  Shape color
     * @param filled Shape is filled
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.center = new Point();
        this.radius = radius;
    }

    /**
     * Week10.Circle constructor 4.
     *
     * @param center center
     * @param radius radisu
     * @param color  color
     * @param filled filled
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
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
     * Week10.Circle toString override.
     *
     * @return Week10.Circle string
     */
    @Override
    public String toString() {
        return String.format(
                "Circle[center=%s,radius=%.1f,color=%s,filled=%s]",
                this.center.toString(),
                this.radius,
                (Objects.equals(this.color, "") ? "null" : this.color),
                this.filled
        );
    }

    /**
     * Boolean if 2 circles are equal, not counting
     * color and filled.
     *
     * @param o another object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            Circle another = (Circle) o;
            return Math.abs(this.radius - another.getRadius())
                    <= 0.001
                    && this.center.equals(another.getCenter());
        }
        return false;
    }

    /**
     * Week10.Circle hashcode, not taking into account color
     * and filled.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 1000;
        hash += this.center.hashCode();
        hash += Double.hashCode(this.radius);
        return hash;
    }
}
