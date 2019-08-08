package edu.unl.cse.csce361.board;

import edu.unl.cse.csce361.logic.Point;

/**
 * 	Bare bones to a player class
 */

public class Player {
	private static ColorSet color;
	private static Point pieceToMove;
	private static Point desiredDestination;
	
	
	// TODO: Add more than this, just added this to illustrate what I mean (eewalt 8/3/2019)
	public Player(ColorSet color) {
		this.color = color;
	}


	public static Point getPieceToMove() {
		return pieceToMove;
	}


	public static void setPieceToMove(Point pieceToMove) {
		Player.pieceToMove = pieceToMove;
	}


	public static Point getDesiredDestination() {
		return desiredDestination;
	}


	public static void setDesiredDestination(Point desiredDestination) {
		Player.desiredDestination = desiredDestination;
	}
	
	
}
