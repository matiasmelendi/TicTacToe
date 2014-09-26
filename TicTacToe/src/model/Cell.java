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

	public Point position() {
		// TODO Auto-generated method stub
		return position;
	}

	public boolean inTheSamePosition(Point position2) {
		// TODO Auto-generated method stub
		return position().equals(position2);
	}

	public void mark(Mark mark) {
		// TODO Auto-generated method stub
		this.mark=mark;
	}

}
