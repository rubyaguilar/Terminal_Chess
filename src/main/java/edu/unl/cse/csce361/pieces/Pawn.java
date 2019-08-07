package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.board.Location;

public class Pawn extends Piece {
	private boolean firstStep;
	public Pawn(ColorSet color, Location location) {
		super(color, location);
		this.firstStep=true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean move(int row, int column) {
		// TODO Auto-generated method stub
		Location originalocation = this.getLocation();
		int originalRow = originalocation.getRow();
		int originalColumn = originalocation.getColumn();
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
	public boolean move(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void kill(Location location) {
		// TODO Auto-generated method stub
		
	}

}
