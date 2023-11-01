package Week13.Co_vua_1_BKT;

import java.util.Objects;

public class Bishop extends Piece {
    /**
     * Bishop constructor 1. X, Y coordinate must be valid.
     *
     * @param coordinatesX X coordinate
     * @param coordinatesY Y coordinate
     */
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * Bishop constructor 1. X, Y coordinate and Color must be valid.
     *
     * @param coordinatesX X coordinate
     * @param coordinatesY Y coordinate
     * @param color        Color String
     */
    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    /**
     * Check if Bishop move to coordinates x and y is possible.
     *
     * @param board Board to move on.
     * @param x     X coordinate to move to
     * @param y     Y coordinate to move to
     * @return If Bishop move is possible or not
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y) || isInvalidBishopMove(x, y)) {
            return false;
        }

        Piece pieceAt = board.getAt(x, y);
        if (pieceAt != null) {
            if (Objects.equals(pieceAt.getColor(), this.getColor())) {
                return false;
            }
        }

        int dx = this.getCoordinatesX() < x ? 1 : -1;
        int dy = this.getCoordinatesY() < y ? 1 : -1;

        int currX = this.getCoordinatesX() + dx;
        int currY = this.getCoordinatesY() + dy;

        while (currX != x) {
            if (board.getAt(currX, currY) != null) {
                return false;
            }
            currX += dx;
            currY += dy;
        }

        return true;
    }

    /**
     * Check if Bishop move is invalid (if the move is not diagonal or no move) or not.
     *
     * @param x X coordinate to move to
     * @param y Y coordinate to move to
     * @return If Bishop move is invalid or not
     */
    public boolean isInvalidBishopMove(int x, int y) {
        return (Math.abs(this.getCoordinatesX() - x)
                != Math.abs(this.getCoordinatesY() - y)) // not diagonal
                || (this.getCoordinatesX() == x && this.getCoordinatesY() == y); // no move
    }
}
