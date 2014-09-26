package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.InvalidMovementException;
import model.TicTacToeMovement;

public class TicTacToeBoard {

	private List<Cell> cells= new ArrayList<Cell>();

	public TicTacToeBoard() {generateCells();}

	public boolean isEmpty() {
		return cells.stream().allMatch(cell -> cell.isEmpty());
	}

	public void newMovement(Mark mark, Point position) throws InvalidMovementException {
		new TicTacToeMovement(cells,position,mark);
	}
	
	public List<Cell> diagonalRow() {
		List<Cell> diagonalRow=new ArrayList<Cell>();
		for(int i=0;i<3;i++)
			diagonalRow.add(getCell(i,i));
		return diagonalRow;
	}

	public List<List<Cell>> horizontalRows() {
		List<List<Cell>> rows= new ArrayList<List<Cell>>();
		for(int x=0;x<3;x++)
			rows.add(horizontalRow(x));
		return rows;
	}
	
	public List<List<Cell>> verticalRows(){
		List<List<Cell>> rows= new ArrayList<List<Cell>>();
		for(int y=0;y<3;y++)
			rows.add(verticalRow(y));
		return rows;
	}

	
	private void generateCells(){
		for(int x=0;x < 3;x++)
			generateRow(x);
	}
	
	private void generateRow(int x){
		for(int y=0;y < 3;y++)
			cells.add(new Cell(x,y));
	}
	
	
	private Cell getCell(int x,int y){
		return cells.stream().filter(cell -> 
				cell.inTheSamePosition(new Point(x,y))).findAny().get();
	}
	
	private List<Cell> verticalRow(int y) {
		return cells.stream().filter(cell -> cell.y() == y).collect(Collectors.toList());
	}
	

	private List<Cell> horizontalRow(int x) {
		return cells.stream().filter(cell -> cell.x()==x).collect(Collectors.toList());
	}


}
