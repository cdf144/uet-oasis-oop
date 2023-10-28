package Week8.Da_hinh_2;

public class Point {
    private double pointX;
    private double pointY;

    /**
     * Week10.Point constructor 1.
     */
    public Point() {
        pointX = 0.0;
        pointY = 0.0;
    }

    /**
     * Week10.Point constructor 2.
     *
     * @param pointX pointX
     * @param pointY pointY
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * Calculate distance between 2 points.
     *
     * @param newPoint another point
     * @return distance
     */
    public double distance(Point newPoint) {
        if (newPoint != null) {
            return Math.sqrt((this.pointX - newPoint.getPointX())
                    * (this.pointX - newPoint.getPointX())
                    + (this.pointY - newPoint.getPointY())
                    * (this.pointY - newPoint.getPointY())
            );
        } else {
            return Math.sqrt(this.pointX * this.pointX
                    + this.pointY * this.pointY);
        }
    }

    /**
     * Boolean if 2 points are equal.
     *
     * @param o another object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point another = (Point) o;
            return Math.abs(this.pointX - another.getPointX())
                    <= 0.001
                    && Math.abs(this.pointY - another.getPointY())
                    <= 0.001;
        }
        return false;
    }

    /**
     * Week10.Point toString.
     *
     * @return Week10.Point string
     */
    @Override
    public String toString() {
        return String.format(
                "(%.1f,%.1f)",
                this.pointX,
                this.pointY
        );
    }

    /**
     * Week10.Point hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode += (int) Math.round(this.pointX);
        hashCode += (int) Math.round(this.pointY);
        hashCode += (int) Math.round(this.pointX * this.pointY);
        return hashCode;
    }
}
