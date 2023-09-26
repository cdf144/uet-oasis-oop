public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    public double getSide() {
        return this.width;
    }

    /**
     * Set square side.
     * @param side Square side
     */
    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Set square side 2.
     * @param side Square side
     */
    public void setWidth(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Set square side 3.
     * @param side Square side
     */
    public void setLength(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Square toString.
     * @return square string
     */
    @Override
    public String toString() {
        return String.format("Square[topLeft=%s,side=%.1f,color=%s,filled=%s]",
                this.topLeft.toString(),
                this.length,
                (this.color.equals("")
                        ? "null" : this.color),
                this.filled
        );
    }

    /**
     * Boolean if 2 rectangles are equal.
     * @param o another object
     * @return boolean
     */
    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square another = (Square) o;
            return Math.abs(this.width - another.getSide())
                    <= 0.001
                    && this.topLeft.equals(another.getTopLeft());
        }
        return false;
    }

    /**
     * Square hashcode.
     * @return hashcode
     */
    public int hashCode() {
        int hash = 3000;
        hash += this.topLeft.hashCode();
        hash += Double.hashCode(this.width);
        hash += Double.hashCode(this.length);
        return hash;
    }
}