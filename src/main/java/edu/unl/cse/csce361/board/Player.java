package edu.unl.cse.csce361.board;

import edu.unl.cse.csce361.logic.Point;

/**
 * 	Bare bones to a player class
 */

public class Player {
	private static final Player instances[] = new Player[2];
	private static int index;
	private ColorSet color;
	private String playerName;
	private Point pieceToMove;
	private Point desiredDestination;
	static {
		instances[0] = new Player(ColorSet.WHITE);
		instances[1] = new Player(ColorSet.BLACK);
	}
	
	private Player(ColorSet color) {
		this.color = color;
	}
	
	public static Player getInstance() {
		return instances[(index++)%2];
	}
	
	public ColorSet getColor() {
		return color;
	}

	public void setColor(ColorSet color) {
		this.color = color;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Point getPieceToMove() {
		return this.pieceToMove;
	}


	public void setPieceToMove(Point pieceToMove) {
		this.pieceToMove = pieceToMove;
	}


	public Point getDesiredDestination() {
		return this.desiredDestination;
	}


	public void setDesiredDestination(Point desiredDestination) {
		this.desiredDestination = desiredDestination;
	}
	
	
}
