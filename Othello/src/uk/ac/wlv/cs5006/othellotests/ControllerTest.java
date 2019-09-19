package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import uk.ac.wlv.cs5006.othello.Controller;
import uk.ac.wlv.cs5006.othello.GamePiece;
import uk.ac.wlv.cs5006.othello.OthelloModel;

class ControllerTest {

	@Test
	public void testConstructorBlack() {

		OthelloModel othelloModel = new OthelloModel(4, 4);
		GamePiece token1 = new GamePiece("BLACK");
		GamePiece token2 = new GamePiece("WHITE");
		Controller controller = new Controller(othelloModel);

		assertTrue(controller.attemptPlay(0, 2, token1) == true);
		assertFalse(controller.attemptPlay(1, 2, token2));
		assertTrue(controller.attemptPlay(3, 3, token1) == false); // 3, 3 is not valid and it should be false
		assertTrue(controller.attemptPlay(0, 1, token2) == true);//testing with a white spot
		assertTrue(controller.attemptPlay(0, 0, token2) == false);//position of the white spot is invalid 

	}

	@Test
	public void testAttemptPlay() {
		OthelloModel othelloModel = new OthelloModel(4, 4);
		Controller con1 = new Controller(othelloModel);
		GamePiece token1 = new GamePiece("BLACK");
		GamePiece token2 = new GamePiece("WHITE");

		assertTrue(con1.attemptPlay(0, 2, token1) == true);// 0, 2 should be a valid position for black to move to on a
															// 4 by 4
		assertTrue(con1.attemptPlay(3, 3, token1) == false);// 3, 3 should not be valid and it should be false
		assertTrue(con1.attemptPlay(0, 1, token2) == true); // trying with a valid white spot
		assertTrue(con1.attemptPlay(0, 0, token2) == false);// position of the the white spot is invalid
	}

	@Test
	public void testgetOpponent() {

		OthelloModel othelloModel = new OthelloModel(4, 4);
		Controller controller = new Controller(othelloModel);
		assertEquals("BLACK", controller.getOpponent("WHITE"));
		assertEquals("WHITE", controller.getOpponent("BLACK"));
		assertEquals("EMPTY", controller.getOpponent("EMPTY"));
		assertTrue(controller.getOpponent("invalid") == "EMPTY");

	}

	@Test
	public void testGetWinner() {

		OthelloModel OthelloModel = new OthelloModel(4, 4);
		Controller controller = new Controller(OthelloModel);
		GamePiece gamePiece = new GamePiece("WHITE");
		controller.attemptPlay(3, 2, gamePiece);
		assertEquals("WHITE", controller.getWinner());
	}

}
