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
	private String columnLetter; 
	private int rowNumber;
	
	
	/**
	 * 
	 * The reason for my two constructors is for easy accessibility 
	 * when using the Pointer class. 
	 * 
	 * Point(String userPoint) is intended to be used when entering 
	 * a user's raw input. It will then call validateLocation method 
	 * 
	 * If validateLocation is successful, then it will 
	 * construct an actual Point object using the following constructor
	 * 
	 * 
	 * @param userPoint
	 */
	
	public Point(String userPoint) {
		
		//FIXME: If a user enters incorrect input, should this be handled at the Point class?
		//Answer: Yes, check comments above validateLocation method
		
		if( validateLocation(userPoint) ) {
			String[] testArr = new String[2];
			testArr = userPoint.split("");
			Point p = new Point(testArr[0], testArr[1]);
		} 
	
		
	}
	
	public Point(String lett, String num) {
		this.columnLetter = lett.toLowerCase();
		this.rowNumber = Integer.parseInt(num); 
	}
	
	/**
	 * 
	 * This will take in the raw user input, used in Point(String s) 
	 * and ensure that it is valid 
	 * 
	 * @param point
	 * @return an array 
	 */
	
	//If the user enters a wrong input, they should continue to be probed for a valid input 
	//through the validLocation because a wrong input does nothing for anyone. 
	//It's best to encapsulate that responsibility into the validLocation method
	//The alternative is data validation at a higher level, which just sounds ugly 
	
	public boolean validateLocation(String point) {
		boolean valid = false;
		
		while (valid == false) {
			
		}
		
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
	
	public int getColumnLetter() {
		switch (this.columnLetter) {
			case "a": return 0;
			case "b": return 1;
			case "c": return 2;
			case "d": return 3;
			case "e": return 4;
			case "f": return 5;
			case "g": return 6;
			case "h": return 7;
			default: return -1; //Is this a good idea?
		}
	}
	
	/**
	 * 
	 * The board is conceptually represented by a 
	 * number-based horizontal axis. The 2D-array 
	 * can be accessed by the returned value. 
	 * 
	 * @return
	 */
	
	public int getRowNumber() {
		return this.rowNumber-1;
	}
}
