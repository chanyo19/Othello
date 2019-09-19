package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import uk.ac.wlv.cs5006.othello.Controller;
import uk.ac.wlv.cs5006.othello.GamePiece;
import uk.ac.wlv.cs5006.othello.OthelloModel;

class OthelloModelTest {

	@Test
	public void testSetInitialState() {

		OthelloModel modelOne = new OthelloModel(4, 4);
		
		modelOne.setInitialState();// Starting the game by positioning the tokens 2 blacks and 2 whites diagonally
		assertTrue(modelOne.getGamePiece(1, 1).getValue() == "BLACK");
		assertTrue(modelOne.getGamePiece(2, 2).getValue() == "BLACK");
		assertTrue(modelOne.getGamePiece(1, 2).getValue() == "WHITE");
		assertTrue(modelOne.getGamePiece(2, 1).getValue() == "WHITE");
		
		assertTrue(modelOne.getGamePiece(0, 0).getValue() == "EMPTY"); // Other pieces locations are empty 
		assertTrue(modelOne.getGamePiece(3, 3).getValue() == "EMPTY");

		assertEquals("BLACK", modelOne.getGamePiece(1, 1).getValue());

	}

	@Test
	public void testGettersAndAttemptPlay() {
	
		OthelloModel model = new OthelloModel(4, 4); // copied the code from the ControllerTest which has already been tested
		assertTrue(model.getOpponent("WHITE") == "BLACK");
		assertTrue(model.getOpponent("BLACK") == "WHITE");
		assertTrue(model.getOpponent("invalid") == "EMPTY");
		GamePiece tokenOne = new GamePiece("WHITE");
		assertTrue(model.getWinner() == "NONE");// should be draw as the starting tokens
		model.attemptPlay(0, 1, tokenOne);// Checking with a token piece at the location of (0,1)
		assertTrue(model.getWinner() == "WHITE");	// This should return white as the winner 
		GamePiece tokenTwo = new GamePiece("BLACK");		// Checking with a black token
		assertTrue(model.attemptPlay(2, 0, tokenTwo) == true);// Checking with a second black token and considered as a winner 
		assertTrue(model.attemptPlay(0, 2, tokenTwo) == true);
		assertTrue(model.getWinner() == "BLACK");
		assertTrue(model.attemptPlay(0, 2, null) == false);// Testing using illegal attempts to check the.
		assertTrue(model.attemptPlay(55, 55, tokenOne) == false);
		GamePiece tokenThree = new GamePiece("EMPTY");// Invalid token
		assertTrue(model.attemptPlay(0, 2, tokenThree) == false);
	}

	@Test
	public void testAttemptPlay() {
		OthelloModel model = new OthelloModel(4, 4);
		GamePiece gamePiece = new GamePiece("WHITE");
		assertTrue(model.attemptPlay(3, 2, gamePiece));
		assertFalse(model.attemptPlay(1, 2, gamePiece));
	}

	@Test
	public void testAttemptPlayTokenNull() {
		OthelloModel othelloModel = new OthelloModel(4, 4); // creating the model
		assertFalse(othelloModel.attemptPlay(1, 2, null));

	}

	@Test
	public void testAttemptPlayNotInMatix() {
		OthelloModel othelloModel = new OthelloModel(4, 4); // creating the model
		GamePiece gamePiece = new GamePiece("WHITE");
		assertFalse(othelloModel.attemptPlay(6, 5, gamePiece));

	}

	@Test
	public void testGameMatrixHasFullandSingleValue() {

		OthelloModel model = new OthelloModel(4, 4);
	
		assertTrue(model.gameMatrixIsFull() == false);	// This false as half filled and considered as a new game
	
		assertTrue(model.gameMatrixHasSingleValue() == false);	// Output has to be 2 black and white tokens, so this is considered as false
		
		for (int i = 0; i < 4; i++) {					// Running loop to set all the values to white 
			for (int j = 0; j < 4; j++) {
				model.getGamePiece(i, j).setValue("WHITE");
			}
		}
		assertTrue(model.gameMatrixIsFull() == true);// should be all filled 
		assertTrue(model.gameMatrixHasSingleValue() == true);// Should be filled with white tokens 
	}

	@Test
	public void testGetWinnerWhite() {

		OthelloModel othelloModel = new OthelloModel(4, 4);
		Controller controller = new Controller(othelloModel);
		GamePiece gamePiece = new GamePiece("WHITE");
		controller.attemptPlay(3, 2, gamePiece);
		assertEquals("WHITE", othelloModel.getWinner());

	}

	@Test
	public void testGetWinnerBlack() {

		OthelloModel model = new OthelloModel(4, 4);
		Controller controllerOne = new Controller(model);
		GamePiece tokenTwo = new GamePiece("BLACK");
		assertTrue(controllerOne.getWinner() == "NONE");	//Should be draw as the 2 black and white tokens are present
		controllerOne.attemptPlay(2, 0, tokenTwo);
		controllerOne.attemptPlay(0, 2, tokenTwo);// Even though it is an illegal play it wins when plays with a second black token
		assertTrue(controllerOne.getWinner() == "BLACK");
		controllerOne.attemptPlay(3, 1, tokenTwo);
		assertEquals("BLACK", model.getWinner());
	}

	@Test
	public void testGetWinnerNone() {
		OthelloModel othelloModel = new OthelloModel(4, 4);
		assertEquals("NONE", othelloModel.getWinner());
	}

	@Test
	public void testGetOpponentAndWinner() {
		OthelloModel model = new OthelloModel(4, 4);
		assertTrue(model.getOpponent("BLACK") == "WHITE");
		assertTrue(model.getOpponent("WHITE") == "BLACK");
		assertTrue(model.getOpponent("invalid") == "EMPTY");
		assertEquals("EMPTY", model.getOpponent("EMPTY"));
		GamePiece tokenOne = new GamePiece("WHITE");
		GamePiece tokenTwo = new GamePiece("BLACK");
		model.attemptPlay(0, 1, tokenOne);
		assertTrue(model.getWinner() == "WHITE");	
		model.attemptPlay(2, 0, tokenTwo);// Plays with a black token
		model.attemptPlay(0, 2, tokenTwo);//  Even though it is an illegal play it wins when plays with a second black token
		assertTrue(model.getWinner() == "BLACK");				
	}

	@Test
	public void testNotSuccessfullAttempt() {
		OthelloModel othelloModel = new OthelloModel(4, 4);
		Controller controller = new Controller(othelloModel);
		GamePiece gamePiece = new GamePiece("BLACK");
		assertFalse(controller.attemptPlay(3, 2, gamePiece));
	}	

	@Test
    public void testIllegalMove() {
        OthelloModel model = new OthelloModel(8, 8);
        GamePiece tokenTwo = new GamePiece("BLACK");
        
        // This returns an incorrect output for as the illegal moves are considered as valid, After fixing the OthelloModel adjacent boolean is false when there is no counter next to it
        //which consided as the correct statemet 

        assertTrue(model.attemptPlay(7, 3, tokenTwo) == false);
    }
}
