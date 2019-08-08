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
		System.out.println("Example: What piece would you like move?: a2\n");
		System.out.println("2. Select your desired location by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: What where would you like to move?: h8");
		System.out.println("*************************\n");
	}
	
	public Point getPieceMove() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWhat piece would you like move?: ");
		String stringPiece = scan.nextLine();
		Point pieceMove = new Point(stringPiece); //piece they want to move
		return pieceMove;
	}
	
	public Point getdesiredDestination() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWhat piece would you like move?: ");
		String stringMove = scan.nextLine();
		Point desiredMove = new Point(stringMove); //piece they want to move
		return desiredMove;
	}
	
	
	public static void main(String[] args) {
		//TODO: Will need to change between player move. 
		Player p1 = new Player(ColorSet.WHITE);
		Player p2 = new Player(ColorSet.BLACK);
		
		
		
		
		
	}
	
}
