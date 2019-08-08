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
		System.out.println("Example: What piece would you like move?: a6\n");
		System.out.println("2. Select your desired location by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: What where would you like to move?: h8");
		System.out.println("*************************");
	}
	
	public static void getMove() {
		Scanner scan = new Scanner(System.in);
		System.out.print("What piece would you like move?: ");
		String tempPiece = scan.nextLine();
		Point piece = new Point(tempPiece); //piece they want to move
		
		System.out.print("What where would you like to move?: ");
		String desiredMove = scan.nextLine();
		Point move = new Point(desiredMove); //where they want to move 
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Player p1 = new Player(ColorSet.WHITE);
		Player p2 = new Player(ColorSet.BLACK);
		
		
		
		Manager.welcome();
		Manager.getMove();
		Board board = Board.getBoard();
		board.printBoard();
	}
	
}
