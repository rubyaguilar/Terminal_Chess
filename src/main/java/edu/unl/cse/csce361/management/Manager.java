package edu.unl.cse.csce361.management;

import java.util.Scanner;
import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.logic.Player;
import edu.unl.cse.csce361.logic.Point;
import edu.unl.cse.csce361.pieces.Piece;

public class Manager {
	public static void welcome() {
		System.out.println("*************************");
		System.out.println("Welcome to CSCE361 Chess!");
		System.out.println("*************************");
		System.out.println("To begin, decide who the first player is. \nFirst player, select the piece you'd like to move.\n");
		System.out.println("Instructions: \n1. Select a piece by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: What piece would you like move?: a2 (equal to a pawn)\n");
		System.out.println("2. Select your desired location by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: What where would you like to move?: a3 (moving the pawn forward one)");
	}

	public static Player createPlayer(Player player, int count) {
		Scanner scan = new Scanner(System.in);
		String name;
		if (count == 1) {
			System.out.print("\nEnter first (white) player's name: ");
			name = scan.next();
		} else {
			System.out.print("Enter second (black) player's name: ");
			name = scan.next();
		}
		player.setPlayerName(name);

		return player;
	}

	public static Point getdesiredDestination() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWhere would you like to move? ");
		String stringMove = scan.nextLine();
		Point desiredMove = new Point(stringMove); 
		scan.close();
		return desiredMove;
	}

	public static Point validationPiece(Player p) {
		Scanner a = new Scanner(System.in);
		System.out.print("\n" + p.getPlayerName() + ", which piece would you like to move? ");
		String pm = a.nextLine();
		Point piecetoMove = new Point(pm);
		while (Piece.getPiece(piecetoMove).getColor() != p.getColor() ) {
			System.out.print("Not your piece. Please select a valid piece: ");
			pm = a.nextLine();
			piecetoMove = new Point(pm);
		}
		return piecetoMove;
	}
	
	public static Point validationDestination() {
		Scanner b = new Scanner(System.in);
		System.out.print("Where would you like to move the piece to? ");
		String dd = b.nextLine();
		Point desiredDestination = new Point(dd);
		return desiredDestination;
	}

	public static Point checkDestination(Piece p, Point d) {
		Scanner sc = new Scanner(System.in);
		while (p.move(d) == false) {
			System.out.print("\nYour move is invalid. Please take a valid step: ");
			sc = new Scanner(System.in);
			d = validationDestination();
		}
		return d;
	}
	
	public static void playerTurn(Player p1, Player p2, Board board) {
		int step = 1;
		Point piecetoMove;
		Point desiredDestination;
		Point checkedDestination;		
		while (true) {
			if (step % 2 == 1) {
				piecetoMove = validationPiece(p1);
				desiredDestination = validationDestination();
				checkedDestination = checkDestination(Piece.getPiece(piecetoMove), desiredDestination);
				board.swap(piecetoMove, checkedDestination);
				board.printBoard();
			} else {
				piecetoMove = validationPiece(p2);
				desiredDestination = validationDestination();
				checkedDestination = checkDestination(Piece.getPiece(piecetoMove), desiredDestination);
				board.swap(piecetoMove, checkedDestination);
				board.printBoard();
			}
			step++;
		}
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
