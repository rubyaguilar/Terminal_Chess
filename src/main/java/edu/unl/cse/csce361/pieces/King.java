package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.board.Location;

public class King extends Piece {

	public King(ColorSet color, Location location) {
		super(color, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean move(int row, int column) {
		// TODO Auto-generated method stub
		Location originalocation = this.getLocation();
		int originalRow = originalocation.getRow();
		int originalColumn = originalocation.getColumn();
		if(Math.abs(row-originalRow)==1||Math.abs(column-originalColumn)==1)
			if(Math.abs(row-originalRow)==Math.abs(column-originalColumn))
				return true;
			if(row-originalRow==0||column-originalColumn==0)
				return true;
		return false;
	}

	@Override
	public boolean move(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void kill(Location location) {
		// TODO Auto-generated method stub
		
	}

}
