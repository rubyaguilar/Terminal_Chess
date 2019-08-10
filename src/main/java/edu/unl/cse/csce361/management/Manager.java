package edu.unl.cse.csce361.management;
import edu.unl.cse.csce361.board.*;
import java.util.Scanner;

import edu.unl.cse.csce361.board.Board;
import edu.unl.cse.csce361.board.ColorSet;
import edu.unl.cse.csce361.board.Player;
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
		System.out.println("*************************\n");
	}
	
	
	
	//Using this for the stragety
	public void pieceRun() {
		while(true) {
			
			
			
		}
	}
	
	
	public static void playerTurn(Player p1,Player p2,Board board) {
		int step=1;
		Point piecetoMove;
		Point desiredDestination;
		Point checkedDestination;
		Piece piece;
		while(true) {
		if(step%2==1) {
			piecetoMove = validationMove(p1);
			desiredDestination = validationDestination();
			piece = board.getPiece(piecetoMove);
		    checkedDestination = checkDestination(piece,desiredDestination);
		    board.swap(piecetoMove, checkedDestination);
		    board.printBoard();
		}
		else {
			piecetoMove = validationMove(p2);
			desiredDestination = validationDestination();
			piece = board.getPiece(piecetoMove);
		    checkedDestination = checkDestination(piece,desiredDestination);
		    board.swap(piecetoMove, checkedDestination);
		    board.printBoard();
		}
		step++;
		}
	}
	
	public static Point checkDestination(Piece p, Point d) {
		while(p.move(d.getRowNumber(),d.getColumnLetter())==false) {
			System.out.println("Your step is invalid for the piece you want to move.Please take another valid step!\n");
			Scanner sc= new Scanner(System.in);
			d=validationDestination();	
		}
		return d;
		
	}
	
	public static Point validationMove(Player p) {
		System.out.println(p.getPlayerName()+": which piece would you like to move?");
		Scanner a= new Scanner(System.in);
		String pm = a.nextLine();
		Point piecetoMove = new Point(pm);
		return piecetoMove;
	}
	
	public static Point validationDestination() {
		System.out.println("where would you like to move the piece to?");
		Scanner b= new Scanner(System.in);
		String dd = b.nextLine();
		Point desiredDestination = new Point(dd);
		return desiredDestination;
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
		
		playerTurn(one,two,board);
		
		
		
		
	}
	
}
