package simpleBattleship;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

	private String[][] board;
	int shipX;
	int shipY;
	
	public void generateBoard(int boardSize) {
		board = new String[boardSize][boardSize];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = "~";
			}
		}
		shipX = ThreadLocalRandom.current().nextInt(0, boardSize);
		shipY = ThreadLocalRandom.current().nextInt(0, boardSize);
	}
	
	public void printBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void checkSpot(int x, int y) {
		if(x == shipX && y == shipY) {
			System.out.println("You hit my ship!");
			System.out.println("You win!");
			System.exit(0);
		} else if (x < 0 || x > board.length || y < 0 || y > board.length) {
			System.out.println("Wow, that's not even on the board!");
		} else {
			System.out.println("You missed...");
			board[x][y] = "X";
		}
	}
	
	
}
