package edu.unl.cse.csce361.pieces;

import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.board.ColorSet;
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
	
	public abstract boolean move(int row, int column);
	public abstract boolean move(Point location);
	
	/*kill an opponent's piece which on that space where the piece can move to
	 * the Pawn may override this method*/
	public void kill(Point point) {
		// TODO Auto-generated method stub
		if(point.getPiece().getColor()!=this.getColor())
			point.getPiece().setStatus(false);
	}
	
	public ColorSet getColor() {
		return color;
	}
	
	public Point getPoint() {
		return point;
	}
	
	/**
	 * Method to help break up the valid move checking
	 * @param location
	 * @return 	true if you can continue with valid move checking
	 * 			false if already definitely invalid move
	 */
	// TODO: Rook/King may have to override this, with their unique move swap
	protected boolean checkIfSpotOpen(Point point) {
		String spot = Board.getBoard().getSpot(point);
		
		// split string on "" and will give each individual character
		// "A6" array.size == 2
		// if you split unicode character like that array.size == 1
		boolean isUnicode = spot.split("").length == 1 ? true : false;
		
		// if the spot isn't unicode, must just be a string dictating the spot is "E3" or something
		// which means you can move on with your move validity checking
		// just return true
		if(!isUnicode) {
			return true;
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
