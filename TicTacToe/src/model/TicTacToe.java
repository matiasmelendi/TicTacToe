package model;

public class TicTacToe {
	
	Player player;
	Player oponent;
	TicTacToeBoard board;

	public TicTacToe(Player player1, Player player2) {
		player=player1;
		oponent=player2;
		board= new TicTacToeBoard();
	}

	public boolean boardIsEmpty() {
		return board.isEmpty();
	}

}
