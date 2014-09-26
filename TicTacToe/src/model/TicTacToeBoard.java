package model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {

	private List<Cell> cells= new ArrayList<Cell>();

	public TicTacToeBoard() {
		generateCells();
	}

	
	private void generateCells(){
		for(int x=0;x < 3;x++)
			generateRow(x);
	}
	
	private void generateRow(int x){
		for(int y=0;y < 3;y++)
			cells.add(new Cell(x,y));
	}
	
	private boolean cellsAreEmpty(){
		return cells.stream().allMatch(cell -> cell.isEmpty());
	}
	
	public boolean isEmpty() {
		return cellsAreEmpty();
	}

	
	
}
