package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;
import edu.unl.cse.csce361.board.Board;

public class Pawn extends Piece {
	private boolean firstStep;

	public Pawn(ColorSet color, Point Point) {
		super(color, Point);
<<<<<<< HEAD

		if(Point.getRowNumber() == 6 || Point.getRowNumber() == 2) {
			this.firstStep = true;
		}
		// TODO Auto-generated constructor stub

		this.firstStep=true;
=======
		this.firstStep = true;
		if (Point.getRowNumber() == 6 || Point.getRowNumber() == 2) {
			this.firstStep = true;
		}
>>>>>>> 4aaf5d1775b8b077fe34ba0bd5bc344e83ac536a

	}

	@Override
	public boolean move(int row, int column) {
		Point originaPoint = this.getPoint();
		int originalRow = originaPoint.getRowNumber();
		int originalColumn = originaPoint.getColumnLetter();
<<<<<<< HEAD
		int x = Math.abs(row-originalRow);
		int y = Math.abs(column-originalColumn);
		
		if(this.firstStep == true && x == 2 && y == 0) {
			return true;
		}else {
			if(x == 1 && y == 0) {
				return true;
			}
		}
		return false;
	}
=======
		int x = Math.abs(row - originalRow);
		int y = Math.abs(column - originalColumn);

		if (this.firstStep == true && x == 2 && y == 0) {
			return true;
		} else {
			if (x == 1 && y == 0) {
				return true;
			}
		}
>>>>>>> 4aaf5d1775b8b077fe34ba0bd5bc344e83ac536a

		return false;
	}

}
