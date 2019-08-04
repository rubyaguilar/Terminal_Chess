package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.board.Location;

public class Knight extends Piece {

	public Knight(ColorSet color, Location location) {
		super(color, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean move(int row, int column) {
		// TODO Auto-generated method stub
		Location originalocation = this.getLocation();
		int originalRow = originalocation.getRow();
		int originalColumn = originalocation.getColumn();
		if((Math.abs(row-originalRow))==2&&Math.abs(column-originalColumn)==1||(Math.abs(row-originalRow))==1&&Math.abs(column-originalColumn)==2)
			return true;
		return false;
	}

	@Override
	public boolean move(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

}
