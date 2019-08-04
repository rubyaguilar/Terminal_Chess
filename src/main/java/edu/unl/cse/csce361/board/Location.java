package edu.unl.cse.csce361.board;
import  edu.unl.cse.csce361.pieces.*;
public class Location {
	int row;
	int column;
	Piece piece;
	
	public Location(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
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
