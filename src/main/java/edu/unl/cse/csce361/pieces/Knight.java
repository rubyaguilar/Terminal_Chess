package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.logic.Point;


public class Knight extends Piece {

	public Knight(ColorSet color, Point Point) {
		super(color, Point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean move(int row, int column) {
		// TODO Auto-generated method stub
		Point originaPoint = this.getPoint();
		int originalRow = originaPoint.getRowNumber();
		int originalColumn = originaPoint.getColumnLetter();
		if((Math.abs(row-originalRow))==2&&Math.abs(column-originalColumn)==1||(Math.abs(row-originalRow))==1&&Math.abs(column-originalColumn)==2)
			return true;
		return false;
	}

	@Override
	public boolean move(Point Point) {
		// TODO Auto-generated method stub
		return false;
	}

}
