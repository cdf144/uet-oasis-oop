package Week12.Co_vua_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class GameTest {
    @Test
    public void testMovePieceValid() {
        Game game = new Game();
        Board board = game.getBoard();
        Rook rook = new Rook(4, 5);
        board.addPiece(rook);

        // Move rook to valid position
        game.movePiece(rook, 7, 5);
        assertEquals(7, rook.getCoordinatesX());
        assertEquals(5, rook.getCoordinatesY());
        assertEquals(1, game.getMoveHistory().size());

        // Capture enemy piece
        Rook rook2 = new Rook(2, 5, "black");
        board.addPiece(rook2);
        game.movePiece(rook, 2, 5);
        assertEquals(2, rook.getCoordinatesX());
        assertEquals(5, rook.getCoordinatesY());
        assertNull(board.getAt(4, 5));
        assertEquals(2, game.getMoveHistory().size());
    }

    @Test
    public void testMovePieceInvalid() {
        Game game = new Game();
        Board board = game.getBoard();
        Rook rook = new Rook(4, 5);
        board.addPiece(rook);

        // Move rook to invalid position
        assertFalse(rook.canMove(board, 10, 5));
        game.movePiece(rook, 10, 5);
        assertEquals(4, rook.getCoordinatesX());
        assertEquals(5, rook.getCoordinatesY());
        assertEquals(0, game.getMoveHistory().size());

        // Move rook to occupied position by friendly piece
        Rook rook2 = new Rook(5, 5);
        board.addPiece(rook2);
        assertFalse(rook.canMove(board, 5, 5));
        game.movePiece(rook, 5, 5);
        assertEquals(4, rook.getCoordinatesX());
        assertEquals(5, rook.getCoordinatesY());
        assertEquals(0, game.getMoveHistory().size());
    }
}

