package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;


public class Knight extends Piece {

	public Knight(ColorSet color, Point Point) {
		super(color, Point);
		// TODO Auto-generated constructor stub
	}

//	public boolean move(int row, int column) {
//		// TODO Auto-generated method stub
//		Point originaPoint = this.getPoint();
//		int originalRow = originaPoint.getRowNumber();
//		int originalColumn = originaPoint.getColumnLetter();
//		if((Math.abs(row-originalRow))==2&&Math.abs(column-originalColumn)==1||(Math.abs(row-originalRow))==1&&Math.abs(column-originalColumn)==2)
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
		// it can move over another piece, don't need to check the path
		if((Math.abs(row-originalRow))==2&&Math.abs(column-originalColumn)==1||(Math.abs(row-originalRow))==1&&Math.abs(column-originalColumn)==2)
			return true;
		return false;

		
	}

}
