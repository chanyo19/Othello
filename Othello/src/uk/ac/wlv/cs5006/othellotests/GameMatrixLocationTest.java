package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import uk.ac.wlv.cs5006.othello.GameMatrixLocation;

class GameMatrixLocationTest {

	@Test
	public void testDefaultInvalid() {
		GameMatrixLocation locationOne = new GameMatrixLocation();
		assertTrue(locationOne.isInvalid() == true);// It should be true as empty constructor ,-1 -1 is an invalid location
	}

	@Test
	public void testDefaultConstructor() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation();
		assertEquals(-1, gameMatrixLocation.getRow());
		assertEquals(-1, gameMatrixLocation.getCol());
	}

	@Test
	public void testParameterisedConstructor() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation(4, 4);
		assertEquals(4, gameMatrixLocation.getRow());
		assertEquals(4, gameMatrixLocation.getCol());
	}

	@Test
	public void testInvalidRowCol() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation(-1, -1);
		assertTrue(gameMatrixLocation.isInvalid());
	}

	@Test
	public void testParamConstructorAndGetSet() {
		// sets up the constructors
		GameMatrixLocation locationOne = new GameMatrixLocation(3, 4);
		// Makes sure it's valid + makes sure the false route has been tested.
		assertTrue(locationOne.isInvalid() == false);

		// Creates more locations.
		GameMatrixLocation locationTwo = new GameMatrixLocation(2, 1);
		GameMatrixLocation locationThree = new GameMatrixLocation(1, 6);
		// Tests the constructor and the getter
		assertTrue(locationOne.getCol() == 4);
		assertTrue(locationTwo.getCol() == 1);
		assertTrue(locationThree.getRow() == 1);
	}

	@Test
	public void testGettersAndSetters() {
		GameMatrixLocation locationOne = new GameMatrixLocation(1, 6);
		locationOne.setRow(2);
		assertFalse(locationOne.getRow() == 1);
		assertTrue(locationOne.getRow() == 2);

		locationOne.setCol(4);
		assertFalse(locationOne.getCol() == 6);
		assertTrue(locationOne.getCol() == 4);
	}
	
	@Test
    public void testSetInvalid() {
        GameMatrixLocation locationOne = new GameMatrixLocation(1, 6);
        locationOne.setInvalid();
        assertTrue(locationOne.getRow() == -1);
        assertTrue(locationOne.getCol() == -1);
    }

	@Test
	public void testValidRowCol() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation(4, 4);
		assertFalse(gameMatrixLocation.isInvalid());
	}

	@Test
	public void testValidRow() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation(-1, 4);
		assertTrue(gameMatrixLocation.isInvalid());
	}

	@Test
	public void testValidCol() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation(4, -1);
		assertTrue(gameMatrixLocation.isInvalid());
	}

	@Test
	public void testSetRow() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation();
		gameMatrixLocation.setRow(4);
		assertEquals(4, gameMatrixLocation.getRow());
	}

	@Test
	public void testSetCol() {
		GameMatrixLocation gameMatrixLocation = new GameMatrixLocation();
		gameMatrixLocation.setCol(4);
		assertEquals(4, gameMatrixLocation.getCol());
	}

}
