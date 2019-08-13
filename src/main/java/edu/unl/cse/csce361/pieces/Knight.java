package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;

public class Knight extends Piece {

	public Knight(ColorSet color, Point Point) {
		super(color, Point);
	}

	@Override
	public boolean move(int row, int column) {
		Point originaPoint = this.getPoint();
		int originalRow = originaPoint.getRowNumber();
		int originalColumn = originaPoint.getColumnLetter();

		if ((Math.abs(row - originalRow)) == 2 && Math.abs(column - originalColumn) == 1
				|| (Math.abs(row - originalRow)) == 1 && Math.abs(column - originalColumn) == 2)
			return true;

		return false;
	}

}
