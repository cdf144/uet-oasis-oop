package Week13.Co_vua_1_BKT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BishopTest {

    @Test
    public void testConstructor() {
        // Test valid constructor with default color
        Bishop bishop = new Bishop(4, 5);
        assertEquals(4, bishop.getCoordinatesX());
        assertEquals(5, bishop.getCoordinatesY());
        assertEquals("white", bishop.getColor());

        // Test valid constructor with specified color
        Bishop bishop2 = new Bishop(2, 3, "black");
        assertEquals(2, bishop2.getCoordinatesX());
        assertEquals(3, bishop2.getCoordinatesY());
        assertEquals("black", bishop2.getColor());

        // Test invalid constructor with invalid coordinates
        Bishop bishop3 = new Bishop(-1, 10);
        assertEquals(0, bishop3.getCoordinatesX());
        assertEquals(0, bishop3.getCoordinatesY());
    }

    @Test
    public void testGetSymbol() {
        Bishop bishop = new Bishop(4, 5);
        assertEquals("B", bishop.getSymbol());
    }

    @Test
    public void testValidDiagonalMoves() {
        Board board = new Board();
        Bishop bishop = new Bishop(4, 5);
        board.addPiece(bishop);

        assertTrue(bishop.canMove(board, 7, 8)); // Up-right
        assertTrue(bishop.canMove(board, 1, 2)); // Down-left
        assertTrue(bishop.canMove(board, 7, 2)); // Up-left
        assertTrue(bishop.canMove(board, 1, 8)); // Down-right

        // Test capture moves
        Bishop enemyBishop = new Bishop(7, 8, "black");
        board.addPiece(enemyBishop);
        assertTrue(bishop.canMove(board, 7, 8)); // Capture enemy bishop
    }

    @Test
    public void testInvalidDiagonalMoves() {
        Board board = new Board();
        Bishop bishop = new Bishop(4, 5);
        board.addPiece(bishop);

        assertFalse(bishop.canMove(board, 3, 5)); // Not diagonal
        assertFalse(bishop.canMove(board, 4, 5)); // No move
        assertFalse(bishop.canMove(board, -1, 5)); // Out of bounds

        // Test friendly piece blocking
        Bishop bishop2 = new Bishop(5, 6);
        board.addPiece(bishop2);
        assertFalse(bishop.canMove(board, 7, 8)); // Blocked by friendly bishop
    }
}
