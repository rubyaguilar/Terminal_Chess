package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;

public class Queen extends Piece {

	public Queen(ColorSet color, Point Point) {
		super(color, Point);
	}

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
		Point originaPoint = this.getPoint();
		int originalRow = originaPoint.getRowNumber();
		int originalColumn = originaPoint.getColumnLetter();

		boolean valid = false;

		if (Math.abs(row - originalRow) == Math.abs(column - originalColumn)) {
			// spot is diagonal, check if pieces obstructing path
			valid = checkPathDiagonal(row, column);
		} else if (row - originalRow == 0) {
			// spot is horizontal, check if pieces obstructing path
			valid = checkPathHorizontal(row, column);
		} else if (column - originalColumn == 0) {
			// spot is vertical, check if pieces obstructing path
			valid = checkPathVertical(row, column);
		}

		// if valid returned true for checking paths, move is valid
		if (valid == true) {
			return true;
		} else {
			// if valid returned false, or did not even check path, move is invalid
			return false;
		}
	}

}
