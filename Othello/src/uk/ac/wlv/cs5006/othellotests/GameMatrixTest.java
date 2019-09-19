package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import uk.ac.wlv.cs5006.othello.GameMatrix;
import uk.ac.wlv.cs5006.othello.GamePiece;

class GameMatrixTest {

	@Test
	public void testDefaultConstructor() {
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		assertEquals(4, gameMatrix.getNumRows());
		assertEquals(4, gameMatrix.getNumColumns());
	}

	@Test
	public void testClear() {
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		gameMatrix.clear();
		for (int i = 0; i < gameMatrix.getNumRows(); i++) {
			for (int j = 0; j < gameMatrix.getNumColumns(); j++) {
				assertEquals("EMPTY", gameMatrix.getGamePiece(i, j).getValue());
			}
		}

	}

	@Test
	public void testSetGamePieceValue() {
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		assertFalse(gameMatrix.setGamePieceValue(-2, -2, "BLACK"));
		assertTrue(gameMatrix.setGamePieceValue(3, 3, "BLACK"));
		assertFalse(gameMatrix.setGamePieceValue(5, 5, "BLACK"));
	}

	@Test
	public void testGetGamePieceValue() {
		GamePiece gPiece = new GamePiece("BLACK");
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		gameMatrix.setGamePieceValue(3, 3, "BLACK");
		assertEquals(gPiece.getValue(), gameMatrix.getGamePiece(3, 3).getValue());
	}

	@Test
	public void testGetGamePieceValueNull() {
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		gameMatrix.setGamePieceValue(3, 3, "BLACK");
		assertEquals(null, gameMatrix.getGamePiece(7, 7));
	}

	@Test
	public void testIsOnMatrix() {
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		assertTrue(gameMatrix.isOnGameMatrix(3, 3));
		assertFalse(gameMatrix.isOnGameMatrix(3, 5));
		assertFalse(gameMatrix.isOnGameMatrix(5, 3));
		assertFalse(gameMatrix.isOnGameMatrix(-2, 3));
	}

	@Test
	public void testGameMatrixIsFull() {
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		for (int i = 0; i < gameMatrix.getNumRows(); i++) {
			for (int j = 0; j < gameMatrix.getNumColumns(); j++) {
				gameMatrix.getGamePiece(i, j).setValue("BLACK");
			}
		}
		assertTrue(gameMatrix.gameMatrixIsFull());
		gameMatrix.clear();
		assertFalse(gameMatrix.gameMatrixIsFull());
	}

	@Test
	public void testGameMatrixHasSingleValue() {
		GameMatrix gameMatrix = new GameMatrix(4, 4);
		gameMatrix.getGamePiece(0, 1).setValue("BLACK");

		assertTrue(gameMatrix.gameMatrixHasSingleValue());
		gameMatrix.getGamePiece(1, 1).setValue("WHITE");
		assertFalse(gameMatrix.gameMatrixHasSingleValue());
	}
	
	@Test
    public void testGettersAndSettersAndClear() {
        GameMatrix boardOne = new GameMatrix(5, 6);
        boardOne.setGamePieceValue(2, 2, "BLACK");
        assertTrue(boardOne.getGamePiece(2, 2).getValue() == "BLACK");
        boardOne.setGamePieceValue(4, 1, "Test Value");
        assertTrue(boardOne.getGamePiece(4, 1).getValue() == "Test Value");
        assertTrue(boardOne.setGamePieceValue(10, 10, "SHOULD FAIL") == false); // This will ensure a value can not be set in an invalid location
        boardOne.clear();// Clears the board
        assertTrue(boardOne.getGamePiece(2, 2).getValue() == "EMPTY"); //testing for empty 
        assertTrue(boardOne.getGamePiece(4, 1).getValue() == "EMPTY");//testing for empty
    }

    @Test
    public void testIsOnGameMatrix() {
        GameMatrix boardOne = new GameMatrix(5, 6);

        boardOne.setGamePieceValue(2, 2, "BLACK");
      
        
        // Testing the validity by inputing small and large numbers 
        assertTrue(boardOne.isOnGameMatrix(0, 0) == true);
        
        //Small Numbers 
        assertTrue(boardOne.isOnGameMatrix(-1, -1) == false);
        assertTrue(boardOne.isOnGameMatrix(1, 1) == true);
        assertTrue(boardOne.isOnGameMatrix(1, -1) == false);
        assertTrue(boardOne.isOnGameMatrix(-1, -1) == false);
        
       // Large Numbers
        assertTrue(boardOne.isOnGameMatrix(10, 11) == false);
        assertTrue(boardOne.isOnGameMatrix(10, 2) == false);
        assertTrue(boardOne.isOnGameMatrix(2, 11) == false);

    }

    @Test
    public void testGameMatrixIsFullandSingleValue() {
        GameMatrix boardOne = new GameMatrix(5, 6);
        boardOne.setGamePieceValue(2, 3, "WHITE");
        boardOne.setGamePieceValue(1, 4, "BLACK");
        
        assertTrue(boardOne.gameMatrixIsFull() == false); // Testing the board with two pieces and it should be false
        
        
        for (int i = 0; i < 5; i++) {					// Filling with board only with white tokens
            for (int j = 0; j < 6; j++) {
                boardOne.setGamePieceValue(i, j, "WHITE");
            }
        }
        
        assertTrue(boardOne.gameMatrixIsFull() == true); // check the whether the board is full
        
        assertTrue(boardOne.gameMatrixHasSingleValue() == true);//  Test the MatrixHasSingleValue() method as the board is filled with white tokens 
        boardOne.setGamePieceValue(2, 3, "BLACK");// Change it so one of them is black again.
        assertFalse(boardOne.gameMatrixHasSingleValue() == true);// Makes sure the same statement is no longer true because they are not all black.
        boardOne.setGamePieceValue(2, 3, "EMPTY");        // Needs to do it for empty as well 
        assertTrue(boardOne.gameMatrixHasSingleValue() == true);// It's true because all white with empty location board still has white tokens

    }

}
