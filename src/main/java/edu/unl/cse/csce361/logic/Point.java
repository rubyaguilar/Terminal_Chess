package edu.unl.cse.csce361.logic;


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
	private String columnLetter; 
	private int rowNumber;
	
	
	/**
	 * 
	 * The reason for my two constructors is for easy accessibility 
	 * when using the Pointer class. 
	 * 
	 * Will think over to ensure robust 
	 * 
	 * @param userPoint
	 */
	
	public Point(String userPoint) {
		
		//FIXME: If a user enters incorrect input, should this be handled at the Point class?
		//I think so. Inside the validateLocation. Will continue probing for a valid entry
		//Just need to pass the responsibility over to it
		if( !validateLocation(userPoint) ) {
			System.out.println("Please enter a valid location: ");
			
		} else {
			String[] testArr = new String[2];
			testArr = userPoint.split("");
			Point p = new Point(testArr[0], testArr[1]);
		}
	}
	
	/**
	 * 
	 * This is the real constructor, used within the previous constructor
	 *  
	 * 
	 * @param lett
	 * @param num
	 */
	
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
	
	public boolean validateLocation(String point) {
		//FIXME: First test is to make sure there is only two characters 
		
		//FIXME: Next test is to make sure it is within the domain of the 
		
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
			case "a":
				return 0;
			case "b":
				return 1;
			case "c":
				return 2;
			case "d":
				return 3;
			case "e":
				return 4;
			case "f":
				return 5;
			case "g":
				return 6;
			case "h":
				return 7;
		}
		return 0;
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
