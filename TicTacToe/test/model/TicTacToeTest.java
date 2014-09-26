package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

	Player player1;
	Player player2;
	
	@Before
	public void setUp() throws Exception {
		player1= new HumanPlayer();
		player2= new HumanPlayer();
	}

	@Test
	public void testTicTacToeStartEmpty() {
		assertTrue(new TicTacToe(player1,player2).boardIsEmpty());
	}

}
