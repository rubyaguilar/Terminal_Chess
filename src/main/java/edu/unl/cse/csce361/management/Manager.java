package edu.unl.cse.csce361.management;

import java.util.Scanner;

import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.board.Player;
import edu.unl.cse.csce361.logic.Point;

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
		System.out.println("*************************\n");
	}
	
	public static void startGame() {
		
		
	}
	
	public static Point getPieceMove() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWhat piece would you like move?: ");
		String stringPiece = scan.nextLine();
		Point pieceMove = new Point(stringPiece); //piece they want to move
		
		return pieceMove;
	}
	
	public static Point getdesiredDestination() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWhere would you like to move?: ");
		String stringMove = scan.nextLine();
		Point desiredMove = new Point(stringMove); //piece they want to move
		scan.close();
		return desiredMove;
	}
	
	
	/**
	 * I will use this to implement the strategy
	 * design for the pieces class. 
	 * 
	 */
	
	public void pieceRun() {
		while(true) {
			
		}
	}
	
	public static void main(String[] args) {
		Manager.welcome();	
		Board board = Board.getBoard();
		board.printBoard();
		Manager.getPieceMove();
		
	}
	
	
}
