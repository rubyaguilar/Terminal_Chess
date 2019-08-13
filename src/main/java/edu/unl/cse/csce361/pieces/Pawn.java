package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.logic.Point;
import edu.unl.cse.csce361.board.Board;


public class Pawn extends Piece {
	private boolean firstStep;
	public Pawn(ColorSet color, Point Point) {
		super(color, Point);
		if(Point.getRowNumber() == 6 || Point.getRowNumber() == 2) {
			this.firstStep = true;
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean move(int row, int column) {
		// TODO Auto-generated method stub
		Point originaPoint = this.getPoint();
		int originalRow = originaPoint.getRowNumber();
		int originalColumn = originaPoint.getColumnLetter();
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

	@Override
	public boolean move(Point Point) {
		// TODO Auto-generated method stub
		return false;
	}
}
