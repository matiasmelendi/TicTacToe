package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.InvalidMovementException;

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
	public void testAPlayerDoAMovementInTheBoardIsntEmpty() throws InvalidMovementException{
		Point position= new Point(1,2);
		ticTacToe.play(player1,position);
		assertFalse(ticTacToe.boardIsEmpty());
	}
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	//The movements should be between(0,0) and (2,2)
	@Test
	public void testAPlayerDoAnInvalidMovementInTheBoard() throws InvalidMovementException{
		Point invalidPosition= new Point(10,2);
		/*expect*/thrown.expect(InvalidMovementException.class);
		/*when*/ ticTacToe.play(player1,invalidPosition);
		assertTrue(ticTacToe.boardIsEmpty());
	}
	
	//The movements should be between(0,0) and (2,2)
	@Test
	public void testAPlayerDoAMarkInAMarkedCell() throws InvalidMovementException{
		Point position= new Point(0,0);
		ticTacToe.play(player1,position);
		/*expect*/thrown.expect(InvalidMovementException.class);		
		/*when*/ ticTacToe.play(player2, position);
	}
	
	@Test
	public void testTwoHumansPlayingAndOneWin() throws InvalidMovementException{
		ticTacToe.play(player1,new Point(0,0));
		ticTacToe.play(player1,new Point(1,0));
		ticTacToe.play(player1,new Point(2,0));
		
		assertTrue(ticTacToe.theWinnerIs(player1));
	}
	
	@Test
	public void testTwoHumansPlayingAndOneLose() throws InvalidMovementException{
		ticTacToe.play(player1,new Point(0,0));
		ticTacToe.play(player1,new Point(1,0));
		ticTacToe.play(player1,new Point(2,0));
		
		assertFalse(ticTacToe.theWinnerIs(player2));
	}
	
	@Test
	public void testTwoHumansPlayingAndNobodyWin() throws InvalidMovementException{
		ticTacToe.play(player1,new Point(0,0));
		ticTacToe.play(player1,new Point(1,0));
		ticTacToe.play(player1,new Point(0,1));
	
		assertFalse(ticTacToe.theWinnerIs(player2));
		assertFalse(ticTacToe.theWinnerIs(player1));
	}

}
