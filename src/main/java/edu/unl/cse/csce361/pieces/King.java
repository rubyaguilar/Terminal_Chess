package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;

public class King extends Piece {

	public King(ColorSet color, Point Point) {
		super(color, Point);
	}

	@Override
	public boolean move(Point p) {
		// check if the spot is open
		// if it isn't, is it an opposing players piece?
		// if returns false, cannot move
		if(!checkIfSpotOpen(p)) {
			return false;
		}
		
		int row = p.getRowNumber();
		int column = p.getColumnLetter();
		
		// check if valid direction
		Point originalPoint = this.getPoint();
		int originalRow = originalPoint.getRowNumber();
		int originalColumn = originalPoint.getColumnLetter();

		if (Math.abs(row - originalRow) == 1 || Math.abs(column - originalColumn) == 1) {
			if (Math.abs(row - originalRow) == Math.abs(column - originalColumn))
				return true;
			if (row - originalRow == 0 || column - originalColumn == 0)
				return true;
		}
		
		return false;
	}

}
