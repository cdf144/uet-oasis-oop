package Co_vua_1;

import java.util.Objects;

public class Rook extends Piece {
    /**
     * Rook constructor 1. X, Y coordinate must be valid.
     *
     * @param coordinatesX X coordinate
     * @param coordinatesY Y coordinate
     */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * Rook constructor 1. X, Y coordinate and Color must be valid.
     *
     * @param coordinatesX X coordinate
     * @param coordinatesY Y coordinate
     * @param color        Color String
     */
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Check if Rook move to coordinates x and y is possible.
     *
     * @param board Board to move on.
     * @param x     X coordinate to move to
     * @param y     Y coordinate to move to
     * @return If Rook move is possible or not
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y) || isInvalidRookMove(x, y)) {
            return false;
        }

        Piece pieceAt = board.getAt(x, y);
        if (pieceAt != null) {
            if (Objects.equals(pieceAt.getColor(), this.getColor())) {
                return false;
            }
        }

        String moveAxis = this.getCoordinatesY() == y ? "Horizontal" : "Vertical";

        if (moveAxis.compareTo("Horizontal") == 0) {
            return canMoveRookHorizontal(board, x, y);
        } else {
            return canMoveRookVertical(board, x, y);
        }
    }

    /**
     * Check if Rook horizontal move to coordinates x and y is possible.
     *
     * @param board Board to move on.
     * @param x     X coordinate to move to
     * @param y     Y coordinate to move to
     * @return If Rook horizontal move is possible or not
     */
    public boolean canMoveRookHorizontal(Board board, int x, int y) {
        int currX = this.getCoordinatesX();
        String moveDirection = currX < x ? "Right" : "Left";

        if (moveDirection.compareTo("Right") == 0) {
            while (++currX < x) {
                if (board.getAt(currX, y) != null) {
                    return false;
                }
            }
        } else {
            while (--currX > x) {
                if (board.getAt(currX, y) != null) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if Rook vertical move to coordinates x and y is possible.
     *
     * @param board Board to move on.
     * @param x     X coordinate to move to
     * @param y     Y coordinate to move to
     * @return If Rook vertical move is possible or not
     */
    public boolean canMoveRookVertical(Board board, int x, int y) {
        int currY = this.getCoordinatesY();
        String moveDirection = currY < y ? "Up" : "Down";

        if (moveDirection.compareTo("Up") == 0) {
            while (++currY < y) {
                if (board.getAt(x, currY) != null) {
                    return false;
                }
            }
        } else {
            while (--currY > y) {
                if (board.getAt(x, currY) != null) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if Rook move is invalid (if the move is diagonal or no move) or not.
     *
     * @param x X coordinate to move to
     * @param y Y coordinate to move to
     * @return If Rook move is invalid or not
     */
    public boolean isInvalidRookMove(int x, int y) {
        return (this.getCoordinatesX() != x && this.getCoordinatesY() != y) // diagonal
                || (this.getCoordinatesX() == x && this.getCoordinatesY() == y); // no move
    }
}
