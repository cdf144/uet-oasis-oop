package Week12.Co_vua_1;

import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<>();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean validate(int x, int y) {
        return Piece.checkValidCoordinates(x, y);
    }

    /**
     * Add a Piece to Board if it isn't on it already.
     *
     * @param p Piece to add
     */
    public void addPiece(Piece p) {
        boolean existPiece = getAt(p.getCoordinatesX(), p.getCoordinatesY()) != null;

        if (!existPiece) {
            pieces.add(p);
        }
    }

    /**
     * Remove a Piece from list.
     *
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void removeAt(int x, int y) {
        if (Piece.checkValidCoordinates(x, y)) {
            pieces.remove(getAt(x, y));
        }
    }

    /**
     * Get a Piece from Board.
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @return Piece at queried coordinate
     */
    public Piece getAt(int x, int y) {
        if (Piece.checkValidCoordinates(x, y)) {
            for (Piece piece : pieces) {
                if (piece.getCoordinatesX() == x
                        && piece.getCoordinatesY() == y
                ) {
                    return piece;
                }
            }
        }

        return null;
    }
}
