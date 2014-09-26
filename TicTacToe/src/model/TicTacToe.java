package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidMovementException;

public class TicTacToe {
	
	private Player player;
	private Player oponent;
	private TicTacToeBoard board;

	public TicTacToe(Player player1, Player player2) {
		player=player1;
		oponent=player2;
		board= new TicTacToeBoard();
	}

	public boolean boardIsEmpty() {
		return board.isEmpty();
	}

	public void play(Player player1,Point position) throws InvalidMovementException {
		board.newMovement(player1.mark(),position);
	}

	public boolean theWinnerIs(Player player) {
		return anyRowCompleteWith(player.mark());
	}

	private boolean anyRowCompleteWith(Mark mark) {
		return posiblesRows().stream().anyMatch(row -> completeWith(row,mark));
	}

	private boolean completeWith(List<Cell> row, Mark mark) {
		return row.stream().allMatch(cell -> cell.mark().equals(mark));
	}

	private List<List<Cell>> posiblesRows() {
		List<List<Cell>> rows= new ArrayList<List<Cell>>();
		rows.addAll(board.verticalRows());
		rows.addAll(board.horizontalRows());
		rows.add(board.diagonalRow());
		
		return rows;
	}

	

}
