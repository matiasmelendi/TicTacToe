package model;

import java.awt.Point;

public class Cell {

	private Point position;
	private Mark mark;
	
	public Cell(int x, int y) {
		position= new Point(x,y);
		mark= new Unmarked();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return mark.isUnmarked();
	}

}
