package Week12.Co_vua_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void testValidateCoordinates() {
        Board board = new Board();
        assertTrue(board.validate(3, 5));
        assertFalse(board.validate(-1, 2));
        assertFalse(board.validate(9, 10));
    }

    @Test
    public void testAddPiece() {
        Board board = new Board();
        Rook rook = new Rook(4, 5);
        board.addPiece(rook);
        assertEquals(rook, board.getAt(4, 5));

        // Adding the same piece shouldn't change anything
        board.addPiece(rook);
        assertEquals(1, board.getPieces().size());
    }

    @Test
    public void testRemoveAt() {
        Board board = new Board();
        Rook rook1 = new Rook(4, 5);
        Rook rook2 = new Rook(2, 3);
        board.addPiece(rook1);
        board.addPiece(rook2);

        board.removeAt(4, 5);
        assertNull(board.getAt(4, 5));
        assertEquals(1, board.getPieces().size());

        // Removing non-existing piece shouldn't change anything
        board.removeAt(10, 10);
        assertEquals(1, board.getPieces().size());
    }

    @Test
    public void testGetAt() {
        Board board = new Board();
        Rook rook = new Rook(4, 5);
        board.addPiece(rook);

        assertEquals(rook, board.getAt(4, 5));
        assertNull(board.getAt(1, 1));
    }
}
