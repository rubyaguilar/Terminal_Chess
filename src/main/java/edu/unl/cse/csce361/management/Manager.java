package edu.unl.cse.csce361.management;
import edu.unl.cse.csce361.board.*;
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
	
	
	
	//Using this for the stragety
	public void pieceRun() {
		while(true) {
			
		}
	}
	
	public void playerTurn() {
		
	}
	
	
	
	
	public static void main(String[] args) {
		welcome();
		
		Board board = Board.getBoard();
		board.printBoard();
		Player one = Player.getInstance();
		one.setPlayerName("Ruben");
		System.out.println(one.getColor() + one.getPlayerName());
		
		Player two = Player.getInstance();
		two.setPlayerName("Aguilar");
		System.out.println(two.getColor() + two.getPlayerName());
		
		System.out.println(one.getPlayerName()+": which piece would you like to move?");
		Scanner sc= new Scanner(System.in);
		Point piecetoMove = new Point(sc.nextLine());
		System.out.println("which the desired destination would you like this piece to move to?");
		Point desiredDestination = new Point(sc.nextLine());
		
		
		

	
		
		
		
		
		
		
		
	}
	
}
