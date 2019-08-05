package edu.unl.cse.csce361.logic;

import java.util.Scanner;

public class Tester {
	
	/**
	 * 
	 * This will 
	 * 
	 * @param letter
	 * @param number
	 */
	
	public static void welcome() {
		System.out.println("Welcome to CSCE361 Chess!\n");
		System.out.println("To begin, decide who the first player is. First player, select the piece you'd like to move\n");
		System.out.println("Instructions: \n1. Select a piece by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: a6\n");
		System.out.println("2. Select your desired location by entering its associated vertical letter followed by its associated horizontal number");
		System.out.println("Example: h8\n");
	}
	
	
	public static void start() {
		welcome();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("What piece would you like move?: ");
		String tempPiece = scan.nextLine();
		
		Point piece = new Point(tempPiece);
			
		
		
				
			
		System.out.print("\nWhat where would you like to move?: ");
		String desiredMove = scan.next();
		Point move = new Point(desiredMove); //where they want to move 
		
		
	}
	
	/**
	 * 
	 * Convert method will validate that the user 
	 * piece and move are within the domain and range of the board
	 * before 
	 * 
	 * @param letter
	 * @param number
	 */
	
	public static String[] convert(String s) {
		String[] tempArray = new String[2];
		//tempArray[0] = row
		//tempArray[1] = column
			
		return tempArray;
	}

	public static void main(String[] args) {
		start();
	}
}
