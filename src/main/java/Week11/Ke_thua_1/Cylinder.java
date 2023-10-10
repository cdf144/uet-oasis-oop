package Week11.Ke_thua_1;

public class Cylinder extends Circle {
    private double height;

    /**
     * Cylinder constructor 1.
     */
    public Cylinder(double height) {
        super();
        this.height = height;
    }

    /**
     * Cylinder constructor 2.
     *
     * @param radius radius
     */
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    /**
     * Cylinder constructor 3.
     *
     * @param radius radius
     * @param color  color
     */
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return 2.0 * PI * getRadius() * (height + getRadius());
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    /**
     * Cylinder to String.
     *
     * @return cylinder string
     */
    @Override
    public String toString() {
        String cylinderString = String.format("Cylinder[%s,height=%.1f]",
                super.toString(),
                this.height);
        return cylinderString;
    }
}
