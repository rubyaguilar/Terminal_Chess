package edu.unl.cse.csce361.management;

import edu.unl.cse.csce361.board.*;
import java.util.Scanner;

import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.logic.Player;
import edu.unl.cse.csce361.logic.Point;
import edu.unl.cse.csce361.pieces.Piece;

public class Manager {
	
	private Piece piece;
	
	public static void welcome() {
		System.out.println("*************************");
		System.out.println("Welcome to CSCE361 Chess!");
		System.out.println("*************************");
		System.out.println(
				"To begin, decide who the first player is. \nFirst player, select the piece you'd like to move.\n");
		System.out.println(
				"Instructions: \n1. Select a piece by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: What piece would you like move?: a2 (equal to a pawn)\n");
		System.out.println(
				"2. Select your desired location by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: What where would you like to move?: a3 (moving the pawn forward one)");
		System.out.println("*************************");
	}

	public static Point getPieceMove() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWhat piece would you like move?: ");
		String stringPiece = scan.nextLine();
		Point pieceMove = new Point(stringPiece); // piece they want to move

		return pieceMove;
	}

	public static Point getdesiredDestination() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWhere would you like to move?: ");
		String stringMove = scan.nextLine();
		Point desiredMove = new Point(stringMove); // piece they want to move
		scan.close();
		return desiredMove;
	}

	/**
	 * I will use this to implement the strategy design for the pieces class.
	 * 
	 */

	public void pieceRun() {
		while (true) {
			//FIXME: How to inherit piece from user selection? 
			
		}
	}

	public static void playerTurn(Player p1, Player p2, Board board) {
		int step = 1;
		Point piecetoMove;
		Point desiredDestination;
		Point checkedDestination;
		Piece piece;
		while (true) {
			if (step % 2 == 1) {
				piecetoMove = validationMove(p1);
				desiredDestination = validationDestination();
				piece = board.getPiece(piecetoMove);
				checkedDestination = checkDestination(piece, desiredDestination);
				board.swap(piecetoMove, checkedDestination);
				board.printBoard();
			} else {
				piecetoMove = validationMove(p2);
				desiredDestination = validationDestination();
				piece = board.getPiece(piecetoMove);
				checkedDestination = checkDestination(piece, desiredDestination);
				board.swap(piecetoMove, checkedDestination);
				board.printBoard();
			}
			step++;
		}
	}

	public static Point validationMove(Player p) {
		System.out.println(p.getPlayerName() + ": which piece would you like to move?");
		Scanner a = new Scanner(System.in);
		String pm = a.nextLine();
		Point piecetoMove = new Point(pm);
		//FIXME: Could allow for the Piece type to be inherited at this step
		
		return piecetoMove;
	}

	public static Point checkDestination(Piece p, Point d) {
		while (p.move(d.getRowNumber(), d.getColumnLetter()) == false) {
			System.out
					.println("Your step is invalid for the piece you want to move. Please take another valid step!\n");
			Scanner sc = new Scanner(System.in);
			d = validationDestination();
		}
		return d;

	}

	public static Point validationDestination() {
		System.out.println("where would you like to move the piece to?");
		Scanner b = new Scanner(System.in);
		String dd = b.nextLine();
		Point desiredDestination = new Point(dd);
		return desiredDestination;
	}

	public static Player createPlayer(Player player, int count) {
		Scanner scan = new Scanner(System.in);
		String name;
		if (count == 1) {
			System.out.print("\nEnter first (white) player's name: ");
			name = scan.next();
		} else {
			System.out.print("\nEnter second (black) player's name: ");
			name = scan.next();
		}
		player.setPlayerName(name);

		return player;
	}

	public static void main(String[] args) {
		Board board = Board.getBoard();
		Player playerOne = Player.getInstance();
		Player playerTwo = Player.getInstance();

		Manager.welcome();
		board.printBoard();

		Manager.createPlayer(playerOne, 1);
		Manager.createPlayer(playerTwo, 2);
		playerTurn(playerOne, playerTwo, board);

	}

}
