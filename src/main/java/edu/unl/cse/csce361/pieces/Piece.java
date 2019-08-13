package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.logic.ColorSet;
import edu.unl.cse.csce361.logic.Point;

public abstract class Piece {
	private ColorSet color;
	private Point point;
	private boolean status;
	
	public Piece(ColorSet color, Point location) {
		this.color = color;
		this.point = location;
		this.status = true;
	}
		
	public abstract boolean move(Point location);
	
	public ColorSet getColor() {
		return color;
	}
	
	public Point getPoint() {
		return point;
	}
	
	/**
	 * Method to check if a spot is open 
	 * If it is, return true 
	 * If a piece is in the spot and is the same color as the current piece, return false 
	 * If a piece is in the spot and a different color, return true
	 * 
	 * @param location
	 * @return true if you can continue with valid move checking false if already
	 *         definitely invalid move
	 */
	// TODO: Rook/King may have to override this, with their unique move swap
	protected boolean checkIfSpotOpen(Point point) {
		Piece spot = Board.getBoard().getPiece(point);
		
		if(spot == null) {
			return true;
		}
		
		if(spot.color == this.color) {
			return false;
		}
		
		return true;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
