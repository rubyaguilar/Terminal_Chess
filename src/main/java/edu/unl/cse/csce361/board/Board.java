package edu.unl.cse.csce361.board;

import edu.unl.cse.csce361.logic.Point;
import edu.unl.cse.csce361.pieces.*;


/**
 * Class utilizing the singleton pattern to represent a chess board
 */

public class Board {
	private static Board instance;
	private static final String[] LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H" };
	private static final String[] NUMBERS = { "1", "2", "3", "4", "5", "6", "7", "8" };

	/**
	 * Two 2D arrays to represent the chess board
	 * 
	 * @boardLayout represents a chess board with no pieces, all spaces being
	 *              represented by their letter-number combo (i.e., E6, D3)
	 * @currentBoard represents the current board with the chest pieces currently in
	 *               play
	 */
	private static final String[][] boardLayout = new String[8][8];
	private static String[][] currentBoard = new String[8][8];

	private Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boardLayout[i][j] = LETTERS[j] + NUMBERS[i];
			}
		}

		resetBoard();
	}

	public static Board getBoard() {
		if (instance == null) {
			instance = new Board();
		} 
		return instance;
	}

	public static Board getInstance() {
		return instance;
	}

	public static void resetBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (i == 1) {
					// when on second row, set whole row to white pawns
					//put player2 points-piece into their map
					currentBoard[i][j] = "\u2659";
				} else if (i == 6) {
					// when on second to last row, set whole row to black pawns
					currentBoard[i][j] = "\u265F";
				} else if(i == 0 && (j == 0 || j == 7)) {
					// place white rooks in the corners
					currentBoard[i][j] = "\u2656";
				} else if(i == 7 && (j == 0 || j == 7)) {
					// place black rooks in the corners
					currentBoard[i][j] = "\u265C";
				} else if(i == 0 && (j == 1 || j == 6)) {
					// place white knights next to the rooks
					currentBoard[i][j] = "\u2658";
				} else if(i == 7 && (j == 1 || j == 6)) {
					// place black knights next to the rooks
					currentBoard[i][j] = "\u265E";
				} else if(i == 0 && (j == 2 || j == 5)) {
					// place white bishops next to the knights
					currentBoard[i][j] = "\u2657";
				} else if(i == 7 && (j == 2 || j == 5)) {
					// place black bishops next to the knights
					currentBoard[i][j] = "\u265D";
				} else if (i == 0 && j == 3) {
					// place white queen
					currentBoard[i][j] = "\u2655";
				} else if(i == 7 && j == 3) {
					// place black queen
					currentBoard[i][j] = "\u265B";
				} else if(i == 0 && j == 4) {
					// place white king
					currentBoard[i][j] = "\u2654";
				} else if(i == 7 && j == 4) {
					// place white king
					currentBoard[i][j] = "\u265A";
				}
				else {
					currentBoard[i][j] = LETTERS[j] + NUMBERS[i];
				}
			}
		}
	}

	public static void printBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(currentBoard[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * Given 2 coordinates on the board, swap the objects on the board
	 * @param row1 		- row of the original piece
	 * @param column1	- column of the original piece
	 * @param row2		- row of the end spot
	 * @param column2	- column of the end spot
	 */
	public void swap(int row1, int column1, int row2, int column2) {
		currentBoard[row2][column2] = currentBoard[row1][column1];
		currentBoard[row1][column1] = boardLayout[row1][column1];
	}

	/**
	 * Given 2 coordinates on the board, swap the objects on the board
	 * @param l1 - coordinates of the original piece
	 * @param l2 - coordinates of the end spot
	 */
	public void swap(Point p1, Point p2) {
		int row1 = p1.getRowNumber();
		int column1 = p1.getColumnLetter();
		int row2 = p2.getRowNumber();
		int column2 = p2.getColumnLetter();
		this.swap(row1, column1, row2, column2);
	}
	
	/** 
	 * Given these coordinates, return the string at that spot
	 */
	public String getSpot(Point p) {
		return currentBoard[p.getRowNumber()][p.getColumnLetter()];
	}

	public Piece getPiece(Point p)
	{
		Piece piece = null;
		String str = getSpot(p);
		switch(str) {
		case "\u2654":
			piece = new King(ColorSet.WHITE,p);
		case "\u2655":
			piece = new Queen(ColorSet.WHITE,p);
		case "\u2656":
			piece = new Rook(ColorSet.WHITE,p);
		case "\u2657":
			piece = new Bishop(ColorSet.WHITE,p);
		case "\u2658":
			piece = new Knight(ColorSet.WHITE,p);
		case "\u2659":
			piece = new Pawn(ColorSet.WHITE,p);
		case "\u265A":
			piece = new King(ColorSet.BLACK,p);
		case "\u265B":
			piece = new Queen(ColorSet.BLACK,p);
		case "\u265C":
			piece = new Rook(ColorSet.BLACK,p);
		case "\u265D":
			piece = new Bishop(ColorSet.BLACK,p);
		case "\u265E":
			piece = new Knight(ColorSet.BLACK,p);
		case "\u265F":
			piece = new Pawn(ColorSet.BLACK,p);
		
		}
		return piece;
	}
}
