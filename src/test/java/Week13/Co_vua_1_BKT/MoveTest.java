package Week13.Co_vua_1_BKT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MoveTest {

    @Test
    public void testConstructor1() {
        Piece bishop = new Bishop(4, 5);
        Move move = new Move(4, 5, 5, 6, bishop);

        assertEquals(4, move.getStartX());
        assertEquals(5, move.getStartY());
        assertEquals(5, move.getEndX());
        assertEquals(6, move.getEndY());
        assertEquals(bishop, move.getMovedPiece());
        assertNull(move.getKilledPiece());
    }

    @Test
    public void testConstructor2() {
        Piece bishop = new Bishop(3, 7, "black");
        Piece bishop2 = new Bishop(5, 5, "white");
        Move move = new Move(3, 7, 5, 5, bishop, bishop2);

        assertEquals(3, move.getStartX());
        assertEquals(7, move.getStartY());
        assertEquals(5, move.getEndX());
        assertEquals(5, move.getEndY());
        assertEquals(bishop, move.getMovedPiece());
        assertEquals(bishop2, move.getKilledPiece());
    }

    @Test
    public void testToString() {
        Piece bishop = new Bishop(4, 7, "black");
        Move move = new Move(4, 7, 1, 4, bishop);

        assertEquals("black-Ba4", move.toString());
    }
}
