package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

	Player player1;
	Player player2;
	TicTacToe ticTacToe;
	Mark knot;
	Mark cross;
	
	@Before
	public void setUp() throws Exception {
		knot= new Knot();
		cross= new Cross();
		player1= new HumanPlayer(knot);
		player2= new HumanPlayer(cross);
		ticTacToe=new TicTacToe(player1,player2);
	}

	@Test
	public void testTicTacToeStartEmpty() {
		assertTrue(ticTacToe.boardIsEmpty());
	}
	
	@Test
	public void testIfAPlayerDoAMovementTheBoardIsntEmpty(){
		Point position= new Point(1,2);
		ticTacToe.play(player1,position);
		assertFalse(ticTacToe.boardIsEmpty());
	}

}
