package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;


public class Pawn extends Piece {
	private boolean firstStep;
	public Pawn(ColorSet color, Point Point) {
		super(color, Point);
		this.firstStep=true;
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
			
		if(this.firstStep==true) {
			if(x==1&&y==0||x==2&&y==0)
				return true;
			this.firstStep=false;
		}
		else {
			if(x==1&&y==0)
				return true;
		}
	
		return false;
	}

	@Override
	public boolean move(Point Point) {
		// TODO Auto-generated method stub
		return false;
	}
}
