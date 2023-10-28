package Co_vua_2;

import java.util.Objects;

import static java.lang.Math.abs;

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

        String moveAxis = this.getCoordinatesX() - x == this.getCoordinatesY() - y
                ? "DiagonalUp" : "DiagonalDown";

        if (moveAxis.compareTo("DiagonalUp") == 0) {
            return canMoveBishopDiagonalUp(board, x, y);
        } else {
            return canMoveBishopDiagonalDown(board, x, y);
        }
    }

    /**
     * Check if Bishop diagonal up move to coordinates x and y is possible.
     *
     * @param board Board to move on.
     * @param x     X coordinate to move to
     * @param y     Y coordinate to move to
     * @return If Bishop diagonal up move is possible or not
     */
    public boolean canMoveBishopDiagonalUp(Board board, int x, int y) {
        int currX = this.getCoordinatesX();
        int currY = this.getCoordinatesY();
        String moveDirection = currX < x ? "Right" : "Left";

        if (moveDirection.compareTo("Right") == 0) {
            while (++currX < x) {
                ++currY;
                if (board.getAt(currX, currY) != null) {
                    return false;
                }
            }
        } else {
            while (--currX > x) {
                --currY;
                if (board.getAt(currX, currY) != null) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if Bishop diagonal down move to coordinates x and y is possible.
     *
     * @param board Board to move on.
     * @param x     X coordinate to move to
     * @param y     Y coordinate to move to
     * @return If Bishop diagonal down move is possible or not
     */
    public boolean canMoveBishopDiagonalDown(Board board, int x, int y) {
        int currX = this.getCoordinatesX();
        int currY = this.getCoordinatesY();
        String moveDirection = currX < x ? "Right" : "Left";

        if (moveDirection.compareTo("Right") == 0) {
            while (++currX < x) {
                --currY;
                if (board.getAt(currX, currY) != null) {
                    return false;
                }
            }
        } else {
            while (--currX > x) {
                ++currY;
                if (board.getAt(currX, currY) != null) {
                    return false;
                }
            }
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
        return (abs(this.getCoordinatesX() - x) != abs(this.getCoordinatesY() - y)) // not diagonal
                || (this.getCoordinatesX() == x && this.getCoordinatesY() == y); // no move
    }
}
