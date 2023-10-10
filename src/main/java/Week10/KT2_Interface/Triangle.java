package Week10.KT2_Interface;

import static java.lang.Math.sqrt;

public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * Week10.Triangle constructor 1.
     */
    public Triangle() {
        this.p1 = new Point();
        this.p2 = new Point();
        this.p3 = new Point();
    }

    /**
     * Week10.Triangle constructor 2.
     * @param p1 point 1
     * @param p2 point 2
     * @param p3 point 3
     */
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        if (p1 == null || p2 == null || p3 == null
            || isSamePoint(p1, p2)
            || isSamePoint(p1, p3)
            || isSamePoint(p2, p3)
            || isStraight(p1, p2, p3)) {
            throw new RuntimeException();
        }
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    private boolean isSamePoint(Point p1, Point p2) {
        return p1.equals(p2);
    }

    private boolean isStraight(Point p1, Point p2, Point p3) {
        return (p1.getPointY() - p2.getPointY()) / (p1.getPointX() - p2.getPointX())
                ==
                (p2.getPointY() - p3.getPointY()) / (p2.getPointX() - p3.getPointX());
    }

    public Point getP1() {
        return p1;
    }

    /**
     * P1 setter.
     * @param p1 point 1
     */
    public void setP1(Point p1) {
        if (p1 != null
            && !isSamePoint(p1, this.p2)
            && !isSamePoint(p1, this.p3)
            && isStraight(p1, this.p2, this.p3)) {
            this.p1 = p1;
        }
    }

    public Point getP2() {
        return p2;
    }

    /**
     * P2 setter.
     * @param p2 point 2
     */
    public void setP2(Point p2) {
        if (p2 != null
            && !isSamePoint(p2, this.p1)
            && !isSamePoint(p2, this.p3)
            && isStraight(this.p1, p2, this.p3)) {
            this.p2 = p2;
        }
    }

    public Point getP3() {
        return p3;
    }

    /**
     * P3 setter.
     * @param p3 point 3
     */
    public void setP3(Point p3) {
        if (p3 != null
                && !isSamePoint(p3, this.p1)
                && !isSamePoint(p3, this.p2)
                && isStraight(this.p1, this.p2, p3)) {
            this.p3 = p3;
        }
    }

    /**
     * Get area of Week10.Triangle with
     * Heron's formula.
     * @return Week10.Triangle area
     */
    @Override
    public double getArea() {
        double a = this.p1.distance(this.p2);
        double b = this.p2.distance(this.p3);
        double c = this.p1.distance(this.p3);
        double s = (a + b + c) / 2;
        return sqrt(
                s
                * (s - a)
                * (s - b)
                * (s - c)
        );
    }

    /**
     * Get Week10.Triangle perimeter.
     * @return Week10.Triangle perimeter
     */
    @Override
    public double getPerimeter() {
        double a = this.p1.distance(this.p2);
        double b = this.p2.distance(this.p3);
        double c = this.p1.distance(this.p3);
        return a + b + c;
    }

    /**
     * Get Week10.Triangle info.
     * @return Week10.Triangle info string
     */
    @Override
    public String getInfo() {
        return String.format(
                "Triangle[%s,%s,%s]",
                this.p1.toString(),
                this.p2.toString(),
                this.p3.toString()
        );
    }
}
