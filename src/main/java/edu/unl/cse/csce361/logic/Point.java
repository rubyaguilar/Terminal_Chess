package edu.unl.cse.csce361.logic;
import java.util.Scanner;

import  edu.unl.cse.csce361.pieces.Piece;

/**
 * 
 * The point class will be an object for handling the user's
 * selected point and their desired move destination. 
 * 
 * 
 * @author rubenaguilar
 *
 */


public class Point {
	Piece piece;
	private int columnLetter; 
	private int rowNumber;
	
	
	/**
	 * 
	 * 
	 * Point(String userPoint) is intended to be used when entering 
	 * a user's raw input. It will then call validateLocation method 
	 * 
	 * If validateLocation is successful, then it will 
	 * construct an actual Point object using the setters
	 * 
	 * 
	 * @param userPoint
	 */
	
	public Point(String userPoint) {
			String[] inputArr = new String[2]; //If it's valid the splitting it won't be a problem.
			inputArr = validateLocation(userPoint);
			setColumnLetter(inputArr[0]); //setting the indexed column letter 
			setRowNumber(inputArr[1]); //setting the indexed row number
	}
	
	
	/**
	 * 
	 * This will take in the raw user input, used in Point(String s) 
	 * and ensure that it is valid (Two characters and within domain and range of board
	 * 
	 * @param point
	 * @return an array 
	 */
	public String[] validateLocation(String rawPoint) {
		String regex ="^[a-h][1-8]$";
		String againPoint = null;
		String testArr[] = null;
		testArr = rawPoint.split("");
		boolean valid=false;
		
		while(valid==false) {
			Scanner sc = new Scanner(System.in);
			if( testArr.length <= 0){ 
				System.out.println("Your input is null. Please enter a vaild input:");
			} 
			else if( testArr.length > 2) {
				System.out.println("Your input length is out of range. Please enter a vaild input:");
			}
			else if (testArr.length != 2) {
				System.out.println("Your input length isn't match the 2D rules. Please enter a vaild input:");
			}
			else if( testArr.length == 2 && againPoint.matches(regex)==false)
				System.out.println("Your input is invaild. Please enter a vaild input:");
				
			else {
				valid = true;
				return testArr;
			}
			againPoint = sc.nextLine();
			testArr = againPoint.split("");
		}
		return testArr;
	}
	
	public void incorrectInput() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		do {
			System.out.println("Please enter a valid input: ");
			input = scan.nextLine();
		} while(input.isEmpty());
		validateLocation(input);
		scan.close();
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public void setPoint(int row, int column) {
		this.rowNumber = row;
		this.columnLetter = column;
	}
	
	/**
	 * 
	 * The board is conceptually represented by a 
	 * letter-based vertical axis. columnLetter is set 
	 * with respect to the 2D array board structure
	 * 
	 * @return
	 */
	
	public void setColumnLetter(String stringLetter) {
		switch (stringLetter) {
		case "a":
			setColumnLetter(0);
			break;
		case "b":
			setColumnLetter(1);
			break;
		case "c":
			setColumnLetter(2);
			break;
		case "d":
			setColumnLetter(3);
			break;
		case "e":
			setColumnLetter(4);
			break;
		case "f":
			setColumnLetter(5);
			break;
		case "g":
			setColumnLetter(6);
			break;
		case "h":
			setColumnLetter(7);
			break;
		//Default isn't necessary because validateLocation already ensured validity
		}
	}
	
	public void setColumnLetter(int columnLetter) {
		this.columnLetter = columnLetter;
	}
	
	/**
	 * 
	 * The board is conceptually represented by a 
	 * number-based horizontal axis. rowNumber is set 
	 * with respect to the 2D array board structure 
	 * 
	 * @return
	 */

	public void setRowNumber(String stringNumber) {
		this.rowNumber = Integer.parseInt(stringNumber);
		this.rowNumber -= 1; //Indexing for array
	}
	
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	
	public int getColumnLetter() {
		return this.columnLetter;
	}
	
	public int getRowNumber() {
		return this.rowNumber;
	}
	
	
}
