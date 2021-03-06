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
	 * Method to check if a spot is open If it is, return true If a piece is in the
	 * spot and is the same color as the current piece, return false If a piece is
	 * in the spot and a different color, return true
	 * 
	 * @param location
	 * @return true if you can continue with valid move checking false if already
	 *         definitely invalid move
	 */

	// TODO: Rook/King may have to override this, with their unique move swap
	protected boolean checkIfSpotOpen(Point point) {
		Piece spot = getPiece(point);
		if (spot == null) {
			return true;
		}

		if (spot.color == this.color) {
			return false;
		}

		return true;
	}

	protected boolean checkPathDiagonal(int endRow, int endColumn) {
		Point p = getPoint();
		int currRow = p.getRowNumber();
		int currColumn = p.getColumnLetter();

		// is horizontal direction left or right?
		int horizontalStep = endColumn < currColumn ? -1 : 1;
		// is vertical direction up or down?
		int verticalStep = endRow < currRow ? -1 : 1;

		currRow += verticalStep;
		currColumn += horizontalStep;

		while (currRow != endRow && currColumn != endColumn) {
			Point currPoint = new Point(currRow, currColumn);
			Piece spot = Piece.getPiece(currPoint);

			if (spot != null) {
				return false;
			}

			currRow += verticalStep;
			currColumn += horizontalStep;
		}

		return true;
	}

	protected boolean checkPathVertical(int endRow, int endColumn) {
		Point p = getPoint();
		int currRow = p.getRowNumber();
		int currColumn = p.getColumnLetter();

		// is vertical direction up or down?
		int verticalStep = endRow < currRow ? -1 : 1;

		currRow += verticalStep;

		while (currRow != endRow || currColumn != endColumn) {
			Point currPoint = new Point(currRow, currColumn);
			Piece spot = Piece.getPiece(currPoint);

			if (spot != null) {
				return false;
			}

			currRow += verticalStep;
		}

		return true;
	}

	protected boolean checkPathHorizontal(int endRow, int endColumn) {
		Point p = getPoint();
		int currRow = p.getRowNumber();
		int currColumn = p.getColumnLetter();

		// is horizontal direction left or right?
		int horizontalStep = endColumn < currColumn ? -1 : 1;

		currColumn += horizontalStep;

		while (currRow != endRow || currColumn != endColumn) {
			Point currPoint = new Point(currRow, currColumn);
			Piece spot = Piece.getPiece(currPoint);

			if (spot != null) {
				return false;
			}

			currColumn += horizontalStep;
		}

		return true;
	}

	public static Piece getPiece(Point p) {
		Piece piece = null;
		String str = Board.getSpot(p);
		switch (str) {
		case "\u2654":
			piece = new King(ColorSet.WHITE, p);
			break;
		case "\u2655":
			piece = new Queen(ColorSet.WHITE, p);
			break;
		case "\u2656":
			piece = new Rook(ColorSet.WHITE, p);
			break;
		case "\u2657":
			piece = new Bishop(ColorSet.WHITE, p);
			break;
		case "\u2658":
			piece = new Knight(ColorSet.WHITE, p);
			break;
		case "\u2659":
			piece = new Pawn(ColorSet.WHITE, p);
			break;
		case "\u265A":
			piece = new King(ColorSet.BLACK, p);
			break;
		case "\u265B":
			piece = new Queen(ColorSet.BLACK, p);
			break;
		case "\u265C":
			piece = new Rook(ColorSet.BLACK, p);
			break;
		case "\u265D":
			piece = new Bishop(ColorSet.BLACK, p);
			break;
		case "\u265E":
			piece = new Knight(ColorSet.BLACK, p);
			break;
		case "\u265F":
			piece = new Pawn(ColorSet.BLACK, p);
			break;

		}
		return piece;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
