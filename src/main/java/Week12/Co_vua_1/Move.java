package Week12.Co_vua_1;

public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Move constructor 1.
     *
     * @param startX     Start X
     * @param endX       End X
     * @param startY     Start Y
     * @param endY       End Y
     * @param movedPiece Moved Piece
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Move constructor 2.
     *
     * @param startX      Start X
     * @param endX        End X
     * @param startY      Start Y
     * @param endY        End Y
     * @param movedPiece  Moved Piece
     * @param killedPiece Killed Piece
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * Move toString.
     *
     * @return String of move made
     */
    public String toString() {
        return movedPiece.getColor()
                + "-"
                + movedPiece.getSymbol()
                + (char) ('a' + endX - 1)
                + endY;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
