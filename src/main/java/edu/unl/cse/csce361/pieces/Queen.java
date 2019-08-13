package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;


public class Queen extends Piece {

	public Queen(ColorSet color, Point Point) {
		super(color, Point);
	}

	@Override
	public boolean move(int row, int column) {
		Point originaPoint = this.getPoint();
		int originalRow = originaPoint.getRowNumber();
		int originalColumn = originaPoint.getColumnLetter();
		
		if(Math.abs(row-originalRow)==Math.abs(column-originalColumn))
			return true;
		if(originalRow==row||originalColumn==column)
			return true;
		
		return false;
	}

	@Override
	public boolean move(Point Point) {
		// TODO Auto-generated method stub
		return false;
	}

}
