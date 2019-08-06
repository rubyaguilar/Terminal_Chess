package edu.unl.cse.csce361.logic;
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
		//FIXME: The logic for the getters should be used for the setters! duh! 
		if( validateLocation(userPoint) ) {
			String[] inputArr = new String[2]; //If it's valid the splitting it won't be a problem.
			inputArr = userPoint.split("");
			
			setRowNumber(inputArr[1]); //setting the row number for point
			
		} 
	}
	
	
	/**
	 * 
	 * This will take in the raw user input, used in Point(String s) 
	 * and ensure that it is valid (Two characters and within domain and range of board
	 * 
	 * @param point
	 * @return an array 
	 */
	
	//The first reason is: why not? 
	//The second is: if the user enters a wrong input, they should continue to be probed for a valid input 
	//through the validLocation because a wrong input does nothing for anyone. 
	//It's best to encapsulate that responsibility into the validLocation method
	//The alternative is data validation at a higher level, which just sounds ugly 
	
	public boolean validateLocation(String rawPoint) {
		boolean valid = false;
		//FIXME: First test is to make sure there is only two characters 
		
		//FIXME: Next test is to make sure two characters are within the domain and range of board
		
		return false;
	}
	
	/**
	 * 
	 * The board is conceptually represented by a 
	 * letter-based vertical axis. The 2D-array 
	 * can be accessed by the returned value. 
	 * 
	 * @return
	 */
	
	public void setColumnLetter(String stringLetter) {
		//FIXME: Index the letter to the correct matrix value
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
	 * number-based horizontal axis. The 2D-array 
	 * can be accessed by the returned value. 
	 * 
	 * @return
	 */

	public void setRowNumber(String stringNumber) {
		this.rowNumber = Integer.parseInt(stringNumber);
		this.rowNumber -= 1; //Indexing to the array
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
