package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.board.Location;

public class Bishop extends Piece {

	public Bishop(ColorSet color, Location location) {
		super(color, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	/*check if the piece can move to the direction that the player wants to be
	 * so for the bishop piece, it can move any distance*/
	public boolean move(int row, int column) {
		// TODO Auto-generated method stub
		Location originalocation = this.getLocation();
		int originalRow = originalocation.getRow();
		int originalColumn = originalocation.getColumn();
		if(Math.abs(row-originalRow)==Math.abs(column-originalColumn))
			return true;
		return false;
	}

	@Override
	public boolean move(Location location) {
		// TODO Auto-generated method stub
		
		return true;
	}

	

}
