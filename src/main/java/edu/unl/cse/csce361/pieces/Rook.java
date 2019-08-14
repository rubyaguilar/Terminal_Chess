package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;

public class Rook extends Piece {

	public Rook(ColorSet color, Point Point) {
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

		if (originalRow != row && originalColumn != column)
			return false;

		return false;
	}

}
