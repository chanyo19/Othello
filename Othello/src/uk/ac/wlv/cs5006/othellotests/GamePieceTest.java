package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import uk.ac.wlv.cs5006.othello.GamePiece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


class GamePieceTest {

    @Test
    public void testConstructor() {
        GamePiece gamePiece = new GamePiece("BLACK");
        assertEquals("BLACK", gamePiece.getValue());
    }

    @Test
    public void testGamePieceSet() {
        GamePiece gamePiece = new GamePiece("BLACK");
        gamePiece.setValue("WHITE");
        assertEquals("WHITE", gamePiece.getValue());
    }

    @Test
    public void testEqualsTrue() {
        GamePiece gamePiece = new GamePiece("BLACK");
        GamePiece gamePieceOther = new GamePiece("BLACK");
        assertTrue(gamePiece.equals(gamePieceOther));
    }

    @Test
    public void testEqualsFalse() {
        GamePiece gamePiece = new GamePiece("BLACK");
        GamePiece gamePieceOther = new GamePiece("WHITE");
        assertFalse(gamePiece.equals(gamePieceOther));
    }
    
    @Test
    public void testWhiteConstructor() {
        GamePiece whitePiece = new GamePiece("WHITE");
        assertTrue(whitePiece.getValue() == "WHITE");
    }

    @Test
    public void testBlackConstructor() {
        GamePiece blackPiece = new GamePiece("BLACK");
        assertTrue(blackPiece.getValue() == "BLACK");
    }

    @Test
    public void testSetValue() {
        GamePiece piece = new GamePiece("BLACK");// getValue method is working and confirmed by the above tests.
        piece.setValue("WHITE");
        assertTrue(piece.getValue() == "WHITE");//setValue works it will it will get equal to white ones 
        assertEquals(piece.getValue(), "WHITE"); 
        assertFalse(piece.getValue() == "BLACK"); // test passed 
    }

    @Test
    public void testEquals() {
        GamePiece pieceOne = new GamePiece("BLACK");
        GamePiece pieceTwo = new GamePiece("BLACK");
        GamePiece pieceThree = new GamePiece("WHITE");

        assertTrue(pieceOne.equals(pieceTwo));
        assertTrue(pieceTwo.equals(pieceOne));
        assertFalse(pieceThree.equals(pieceOne));
    }

}
