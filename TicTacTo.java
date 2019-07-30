package com.game;

import java.util.Scanner;

public class TicTacTo {

	private static final Scanner s = new Scanner(System.in);
	private static String board[][] = new String[3][3];
	
	public static void main(String[] args) {
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length;  j++) {
				board[i][j] = "-";
			}
		}
		System.out.println("*********** TICTACTO ***********");
		printBoard();
		System.out.println("Player one choose your pan:");
		String p1 = s.next();
		System.out.println("Player two choose your pan:");
		String p2 = s.next();
		while(true) {
			String[] player1Ip = null;
			do {
				System.out.println("Player one Enter your loction to place the pan(ex: 1,2):");
				player1Ip = s.next().split(",");
				if(isValidLocation(Integer.parseInt(player1Ip[0]), Integer.parseInt(player1Ip[1]))) {
					placePanOnboard(Integer.parseInt(player1Ip[0]), Integer.parseInt(player1Ip[1]), p1);
				} else {
					System.out.println("Location is already taken.");
					player1Ip = null;
				}
			} while(player1Ip == null);
			
			if(checkIfPlayerWon(p1, board.length)) {
				System.out.println("Player one won the game :)");
				break;
			} else if(isGameDraw()) {
				System.out.println("Game ended as draw. You both are really too good :)");
				break;
			}
			
			String[] player2Ip = null;
			do {
				System.out.println("Player two Enter your loction to place the pan(ex: 1,2):");
				player2Ip = s.next().split(",");
				if(isValidLocation(Integer.parseInt(player2Ip[0]), Integer.parseInt(player2Ip[1]))) {
					placePanOnboard(Integer.parseInt(player2Ip[0]), Integer.parseInt(player2Ip[1]), p2);
				} else {
					System.out.println("Location is already taken.");
					player2Ip = null;
				}
			} while(player2Ip == null);
			
			if(checkIfPlayerWon(p2, board.length)) {
				System.out.println("Player two won the game :)");
				break;
			} else if(isGameDraw()) {
				System.out.println("Game ended as draw. You both are really too good :)");
				break;
			}
		}
		

	}

	private static boolean isGameDraw() {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length;  j++) {
				if(board[i][j] == "-")
					return false;
			}
		}
		return true;
	}

	private static boolean checkIfPlayerWon(String pan, int l) {
		// Initially we think the player won.
		boolean isWon = true;
		
		// check left diagonal.
		for(int i=0; i<l; i++) {
			if(board[i][i] != pan) {
				isWon = false;
				break;
			}
			
		}
		
		// Check if he won
		if(isWon)
			return true;
		else
			isWon = true;
		
		// check right diagonal.
		for(int i=0; i<l; i++) {
			if(board[l-i-1][i] != pan) {
				isWon = false;
				break;
			}
		}
		
		// Check if he won.
		if(isWon)
			return true;
		else
			isWon = true;
		
		// check all rows.
		for(int i=0; i<l; i++) {
			for(int j=0; j<l;  j++) {
				if(board[i][j] != pan) {
					isWon = false;
					break;
				}
			}
			if(isWon)
				return true;
			else
				isWon = true;
		}
		return false;
	}

	private static boolean isValidLocation(int row, int col) {
		return board[row][col] == "-" ? true : false;
	}

	private static void placePanOnboard(int row, int col, String pan) {
		board[row][col] = pan;
		printBoard();
	}

	private static void printBoard() {
		System.out.println("  0 1 2");
		for(int i=0; i<board.length; i++) {
			System.out.print(i+" ");
			for(int j=0; j<board.length;  j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
