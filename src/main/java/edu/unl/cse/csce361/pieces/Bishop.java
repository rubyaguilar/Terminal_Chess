package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;

public class Bishop extends Piece {

	public Bishop(ColorSet color, Point location) {
		super(color, location);
	}

	@Override
	/*check if the piece can move to the direction that the player wants to be
	 * so for the bishop piece, it can move any distance*/
	public boolean move(int row, int column) {
		Point originalocation = this.getPoint();
		int originalRow = originalocation.getRowNumber();
		int originalColumn = originalocation.getColumnLetter();
		
		if(Math.abs(row-originalRow)==Math.abs(column-originalColumn))
			return true;
		
		return false;
	}

}
