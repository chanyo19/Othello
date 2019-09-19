package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import uk.ac.wlv.cs5006.othello.GameMatrixCell;
import uk.ac.wlv.cs5006.othello.GameMatrixLocation;
import uk.ac.wlv.cs5006.othello.GamePiece;


class GameMatrixCellTest {

	@Test
    public void testConstructor() {
        
        GamePiece token1 = new GamePiece("WHITE");
        GamePiece token2 = new GamePiece("BLACK");
        
        GameMatrixCell cell1 = new GameMatrixCell(1, 2, token1);
        GameMatrixCell cell2 = new GameMatrixCell(2, 5, token2);
        GameMatrixCell gameMatrixCell = new GameMatrixCell(4, 4, token2);
        GameMatrixLocation gameMatrixLocation = new GameMatrixLocation(4, 4);
        assertTrue(cell1.getGamePiece() == token1);
        assertTrue(cell2.getGamePiece() == token2);
        assertEquals(token2, gameMatrixCell.getGamePiece());
        assertEquals(gameMatrixLocation.getRow(), gameMatrixCell.getLocation().getRow());
        assertEquals(gameMatrixLocation.getCol(), gameMatrixCell.getLocation().getCol());
        assertTrue(cell2.getLocation().getCol() == 5); //Returns the cell2 location
    }

    @Test
    public void testSetValue() {
        GamePiece gamePiece = new GamePiece("BLACK");
        GameMatrixCell gameMatrixCell = new GameMatrixCell(4, 4, gamePiece);
        gameMatrixCell.setValue("BLACK");
        assertEquals(gamePiece.getValue(), gameMatrixCell.getGamePiece().getValue());
    }

    @Test
    public void testSetGamePiece() {
        GamePiece gamePiece = new GamePiece("BLACK");
        GameMatrixCell gameMatrixCell = new GameMatrixCell(4, 4, gamePiece);
        gameMatrixCell.setGamePiece(gamePiece);
        assertEquals(gamePiece, gameMatrixCell.getGamePiece());
    }
    
    @Test
    public void testSetters() {
        GamePiece token1 = new GamePiece("WHITE");
        GamePiece token2 = new GamePiece("BLACK");
        GameMatrixCell cell1 = new GameMatrixCell(1, 2, token1);
        assertTrue(cell1.getGamePiece().getValue() == "WHITE");
        cell1.setGamePiece(token2);
        assertTrue(cell1.getGamePiece().getValue() == "BLACK");
        cell1.setValue("TEST VALUE");
        assertTrue(cell1.getGamePiece().getValue() == "TEST VALUE");
    }
}
