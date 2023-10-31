package Week12.Co_vua_1;

public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Piece constructor 1. X, Y coordinate must be valid.
     *
     * @param coordinatesX X coordinate
     * @param coordinatesY Y coordinate
     */
    public Piece(int coordinatesX, int coordinatesY) {
        if (checkValidCoordinates(coordinatesX, coordinatesY)) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
        }
        this.color = "";
    }

    /**
     * Piece constructor 1. X, Y coordinate and Color must be valid.
     *
     * @param coordinatesX X coordinate
     * @param coordinatesY Y coordinate
     * @param color        Color String
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        if (checkValidCoordinates(coordinatesX, coordinatesY)) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
        }

        if (checkValidColor(color)) {
            this.color = color;
        } else {
            this.color = "";
        }
    }

    public static boolean checkValidCoordinates(int x, int y) {
        return (x >= 1 && x <= 8) && (y >= 1 && y <= 8);
    }

    public static boolean checkValidColor(String color) {
        return color.equals("black") || color.equals("white");
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Check if the input Piece is in the same position
     * as this piece.
     *
     * @param p Another piece
     * @return Boolean if the 2 pieces are in the same
     * position
     */
    public boolean checkPosition(Piece p) {
        if (!checkValidCoordinates(p.getCoordinatesX(), p.getCoordinatesY())) {
            return false;
        }

        return p.getCoordinatesX() == this.coordinatesX
                && p.getCoordinatesY() == this.coordinatesY;
    }
}
