package edu.unl.cse.csce361.board;

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
	private static String[][] boardLayout = new String[8][8];
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

	public static void resetBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (i == 1) {
					// when on second row, set whole row to white pawns
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

}
