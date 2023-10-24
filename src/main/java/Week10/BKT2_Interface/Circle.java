package Week10.BKT2_Interface;

public class Circle implements GeometricObject {
    public static final double PI = 3.14;
    private Point center;
    private double radius;

    /**
     * Week10.Circle constructor 1.
     */
    public Circle() {
        this.center = new Point();
        this.radius = 0;
    }

    /**
     * Week10.Circle constructor 2.
     *
     * @param center circle center
     * @param radius circle radius
     */
    public Circle(Point center, double radius) {
        if (center != null) {
            this.center = center;
        } else {
            this.center = new Point();
        }
        if (radius >= 0) {
            this.radius = radius;
        } else {
            this.radius = 0;
        }
    }

    public Point getCenter() {
        return center;
    }

    /**
     * Center setter.
     *
     * @param center center
     */
    public void setCenter(Point center) {
        if (center != null) {
            this.center = center;
        }
    }

    public double getRadius() {
        return radius;
    }

    /**
     * Radius setter.
     *
     * @param radius radius
     */
    public void setRadius(double radius) {
        if (radius >= 0) {
            this.radius = radius;
        }
    }

    @Override
    public double getArea() {
        return PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * PI * this.radius;
    }

    /**
     * Get info string of Week10.Circle object.
     *
     * @return info string of Week10.Circle instance
     */
    @Override
    public String getInfo() {
        return String.format("Circle[%s,r=%.2f]",
                this.center.toString(),
                this.radius
        );
    }
}
