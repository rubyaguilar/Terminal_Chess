package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.board.Location;

abstract class Piece {
	private ColorSet color;
	private Location location;
	
	public Piece(ColorSet color, Location location) {
		this.color = color;
		this.location = location;
	}
	
	public abstract boolean move(int row, int column);
	public abstract boolean move(Location location);
	
	public ColorSet getColor() {
		return color;
	}
	
	public Location getLocation() {
		return location;
	}
}
