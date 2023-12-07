package Week12.Co_vua_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RookTest {
    @Test
    public void testConstructor() {
        // Test valid constructor with default color
        Rook rook1 = new Rook(4, 5);
        assertEquals(4, rook1.getCoordinatesX());
        assertEquals(5, rook1.getCoordinatesY());
        assertEquals("white", rook1.getColor());

        // Test valid constructor with specified color
        Rook rook2 = new Rook(2, 3, "black");
        assertEquals(2, rook2.getCoordinatesX());
        assertEquals(3, rook2.getCoordinatesY());
        assertEquals("black", rook2.getColor());

        // Test invalid constructor with invalid coordinates
        Rook rook3 = new Rook(-1, 10);
        assertEquals(0, rook3.getCoordinatesX());
        assertEquals(0, rook3.getCoordinatesY());
    }

    @Test
    public void testGetSymbol() {
        Rook rook = new Rook(4, 5);
        assertEquals("R", rook.getSymbol());
    }

    @Test
    public void testCanMoveHorizontal() {
        Board board = new Board();
        Rook rook = new Rook(4, 5);
        board.addPiece(rook);

        // Test valid horizontal moves
        assertTrue(rook.canMove(board, 7, 5)); // Move right
        assertTrue(rook.canMove(board, 1, 5)); // Move left

        // Test invalid horizontal moves
        assertFalse(rook.canMove(board, 2, 3)); // Diagonal move
        assertFalse(rook.canMove(board, 4, 5)); // No move
        assertFalse(rook.canMove(board, -1, 5)); // Out of bounds

        // Test moves with pieces in between
        Rook otherRook = new Rook(5, 5);
        board.addPiece(otherRook);
        assertFalse(rook.canMove(board, 6, 5)); // Blocked by other piece
        assertFalse(rook.canMove(board, 5, 5)); // Blocked by other piece

        // Test capture moves
        Rook enemyRook = new Rook(1, 5, "black");
        board.addPiece(enemyRook);
        assertTrue(rook.canMove(board, 1, 5)); // Capture enemy piece
    }

    @Test
    public void testCanMoveVertical() {
        Board board = new Board();
        Rook rook = new Rook(4, 5);
        board.addPiece(rook);

        // Test valid vertical moves
        assertTrue(rook.canMove(board, 4, 7)); // Move up
        assertTrue(rook.canMove(board, 4, 1)); // Move down

        // Test invalid vertical moves
        assertFalse(rook.canMove(board, 6, 3)); // Diagonal move
        assertFalse(rook.canMove(board, 4, 5)); // No move
        assertFalse(rook.canMove(board, 4, -1)); // Out of bounds

        // Test moves with pieces in between
        Rook otherRook = new Rook(4, 6);
        board.addPiece(otherRook);
        assertFalse(rook.canMove(board, 4, 7)); // Blocked by other piece
        assertFalse(rook.canMove(board, 4, 6)); // Blocked by other piece

        // Test capture moves
        Rook enemyRook = new Rook(4, 3, "black");
        board.addPiece(enemyRook);
        assertTrue(rook.canMove(board, 4, 3)); // Capture enemy piece
    }
}
