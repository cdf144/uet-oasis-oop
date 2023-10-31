package Co_vua_1_BKT;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    /**
     * Game constructor 1.
     */
    public Game() {
        board = new Board();
        moveHistory = new ArrayList<>();
    }

    /**
     * Game constructor 2.
     *
     * @param board Another board
     */
    public Game(Board board) {
        this.board = board;
        moveHistory = new ArrayList<>();
    }

    /**
     * Move piece and add to moveHistory if Move is valid,
     * if a Piece exists at location to move to, remove that Piece.
     *
     * @param piece Piece to move
     * @param x     X coordinate to move to
     * @param y     Y coordinate to move to
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move;
            Piece pieceAt = board.getAt(x, y);
            if (pieceAt == null) {
                move = new Move(
                        piece.getCoordinatesX(),
                        x,
                        piece.getCoordinatesY(),
                        y,
                        piece
                );
            } else {
                move = new Move(
                        piece.getCoordinatesX(),
                        x,
                        piece.getCoordinatesY(),
                        y,
                        piece,
                        pieceAt
                );
                board.removeAt(x, y);
            }

            moveHistory.add(move);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }
}
