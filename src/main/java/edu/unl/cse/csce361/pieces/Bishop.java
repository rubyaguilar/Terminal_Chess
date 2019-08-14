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
//	public boolean move(Point p) {
//		int row = p.getRowNumber();
//		int column = p.getColumnLetter();
//		
//		Point originalocation = this.getPoint();
//		int originalRow = originalocation.getRowNumber();
//		int originalColumn = originalocation.getColumnLetter();
//		
//		if(Math.abs(row-originalRow)==Math.abs(column-originalColumn))
//			return true;
//		
//		return false;
//	}
	public boolean move(Point p) {
		// check if the spot is open
		// if it isn't, is it an opposing players piece?
		// if returns false, cannot move
		if (!checkIfSpotOpen(p)) {
			return false;
		}

		int row = p.getRowNumber();
		int column = p.getColumnLetter();

		// check if valid direction
		Point originalPoint = this.getPoint();
		int originalRow = originalPoint.getRowNumber();
		int originalColumn = originalPoint.getColumnLetter();

		boolean valid = false;

		if (Math.abs(row-originalRow)==Math.abs(column-originalColumn)) {
			// spot is diagonal, check if pieces obstructing path
			valid = checkPathDiagonal(row, column);
		}
		
		if (valid == true) {
			return true;
		} 
		else {
			// if valid returned false, or did not even check path, move is invalid
			return false;
		}
	}


}
