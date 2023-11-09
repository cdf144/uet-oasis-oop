package Week15.Ke_thua_1;

public class Circle {
    protected static final double PI = 3.1415926535;
    private double radius;
    private String color;

    /**
     * Circle constructor 1.
     */
    public Circle() {
        this.radius = 0;
        this.color = "";
    }

    /**
     * Circle constructor 2.
     *
     * @param radius radius
     */
    public Circle(double radius) {
        this.radius = radius;
        this.color = "";
    }

    /**
     * Circle constructor 3.
     *
     * @param radius radius
     * @param color  color
     */
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * Circle to String.
     *
     * @return circle string
     */
    @Override
    public String toString() {
        return String.format("Circle[radius=%.1f,color=%s]",
                this.radius,
                this.color);
    }
}
