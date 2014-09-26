package model;

public abstract class Player {

	private Mark assignedMark;
	
	public Player(Mark mark) {
		assignedMark=mark;
	}

	public Mark mark() {
		
		return assignedMark;
	}

}
