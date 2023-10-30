package Week10.BKT2_Interface;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private double pointX;
    private double pointY;

    /**
     * Week10.Point constructor 1.
     */
    public Point() {
        this.pointX = 0;
        this.pointY = 0;
    }

    /**
     * Week10.Point constructor 2.
     *
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point(double x, double y) {
        this.pointX = x;
        this.pointY = y;
    }

    /**
     * Week10.Point copy constructor.
     *
     * @param point Another point to copy
     */
    public Point(Point point) {
        this.pointX = point.getPointX();
        this.pointY = point.getPointY();
    }

    public double getPointX() {
        return this.pointX;
    }

    public void setPointX(double x) {
        this.pointX = x;
    }

    public double getPointY() {
        return this.pointY;
    }

    public void setPointY(double y) {
        this.pointY = y;
    }

    /**
     * Calculate distance between this point
     * and another point.
     *
     * @param other Other point
     * @return distance between 2 points.
     */
    public double distance(Point other) {
        try {
            return sqrt(
                    pow(this.pointX - other.getPointX(), 2)
                    + pow(this.pointY - other.getPointY(), 2)
            );
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * Week10.Point toString.
     *
     * @return Week10.Point string
     */
    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)",
                this.pointX,
                this.pointY
        );
    }

    /**
     * Boolean if 2 points are equal.
     *
     * @param o another object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        try {
            if (o instanceof Point) {
                Point another = (Point) o;
                return Math.abs(this.pointX - another.getPointX())
                        <= 0.001
                        && Math.abs(this.pointY - another.getPointY())
                        <= 0.001;
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
