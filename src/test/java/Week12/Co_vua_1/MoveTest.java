package Week12.Co_vua_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MoveTest {
    @Test
    public void testConstructor1() {
        Piece rook = new Rook(4, 5);
        Move move = new Move(4, 6, 5, 5, rook);

        assertEquals(4, move.getStartX());
        assertEquals(6, move.getEndX());
        assertEquals(5, move.getStartY());
        assertEquals(5, move.getEndY());
        assertEquals(rook, move.getMovedPiece());
        assertNull(move.getKilledPiece());
    }

    @Test
    public void testConstructor2() {
        Piece rook1 = new Rook(2, 5, "black");
        Piece rook2 = new Rook(5, 5, "white");
        Move move = new Move(2, 5, 5, 5, rook1, rook2);

        assertEquals(2, move.getStartX());
        assertEquals(5, move.getEndX());
        assertEquals(5, move.getStartY());
        assertEquals(5, move.getEndY());
        assertEquals(rook1, move.getMovedPiece());
        assertEquals(rook2, move.getKilledPiece());
    }

    @Test
    public void testToString() {
        Piece rook = new Rook(4, 7, "black");
        Move move = new Move(4, 7, 1, 4, rook);

        assertEquals("black-Rg4", move.toString());
    }
}

