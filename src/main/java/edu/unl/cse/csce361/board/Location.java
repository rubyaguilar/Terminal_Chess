package edu.unl.cse.csce361.board;

public class Location {
	int row;
	int column;
	
	public Location(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void setLocation(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}