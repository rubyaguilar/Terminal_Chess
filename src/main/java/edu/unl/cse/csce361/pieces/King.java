package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;


public class King extends Piece {

	public King(ColorSet color, Point Point) {
		super(color, Point);
	}

	@Override
	public boolean move(int row, int column) {
		Point originaPoint = this.getPoint();
		int originalRow = originaPoint.getRowNumber();
		int originalColumn = originaPoint.getColumnLetter();
		
		if(Math.abs(row-originalRow)==1||Math.abs(column-originalColumn)==1) {
			if(Math.abs(row-originalRow)==Math.abs(column-originalColumn))
				return true;
			if(row-originalRow==0||column-originalColumn==0)
				return true;
		}
		
		return false;
	}

}
