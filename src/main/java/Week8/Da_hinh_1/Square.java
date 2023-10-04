package Week8.Da_hinh_1;

import java.util.Objects;

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

    public double getSide() {
        return this.width;
    }

    /**
     * Set square side.
     *
     * @param side Square side
     */
    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Set square side 2.
     *
     * @param side Square side
     */
    public void setWidth(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Set square side 3.
     *
     * @param side Square side
     */
    public void setLength(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Square toString.
     *
     * @return Square string
     */
    @Override
    public String toString() {
        return String.format("Square[side=%.1f,color=%s,filled=%s]",
                this.width,
                (Objects.equals(this.color, "")
                        ? "null" : this.color),
                this.filled
        );
    }
}
