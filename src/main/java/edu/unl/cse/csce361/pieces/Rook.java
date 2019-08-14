package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;


public class Rook extends Piece {

	public Rook(ColorSet color, Point Point) {
		super(color, Point);
		// TODO Auto-generated constructor stub
	}


//	public boolean move(int row, int column) {
//		// TODO Auto-generated method stub
//		Point originaPoint = this.getPoint();
//		int originalRow = originaPoint.getRowNumber();
//		int originalColumn = originaPoint.getColumnLetter();
//		if(originalRow==row||originalColumn==column)
//			return true;
//		return false;
//	}

	@Override
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

		if (originalRow==row&&originalColumn!=column) {
			// spot is horizontal, check if pieces obstructing path
			valid = checkPathHorizontal(row, column);
		} else if (originalRow!=row&&originalColumn==column) {
			// spot is vertical, check if pieces obstructing path
			valid = checkPathVertical(row, column);
		}

		// if valid returned true for checking paths, move is valid
		if (valid == true) {
			return true;
		} 
		else {
			// if valid returned false, or did not even check path, move is invalid
			return false;
		}
	}

}
