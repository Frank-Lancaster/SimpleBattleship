package simpleBattleship;

import java.util.Scanner;

public class Game {
	
	int boardSize;
	Board board = new Board();
	int guesses = 5;
	
	public void getBoardSize() {
		while(true) {
			try {
				Scanner reader = new Scanner(System.in);
				System.out.println("What size do you want the board to be (Enter a number, minimum 3 maximum 10)? ");
				boardSize = reader.nextInt();
				if (boardSize < 3) {
					System.out.println("That's too small. Making the board size 3.");
					boardSize = 3;
				} else if (boardSize > 10) {
					System.out.println("That's too big. Making the board size 10.");
					boardSize = 10;
				}
				break;
			} catch (Exception e) {
				System.out.println("That's not a number!");
			}
		}
		board.generateBoard(boardSize);
		System.out.println();
		board.printBoard();
	}
	
	
	public void getGuesses() {
		System.out.println("\nYou have " + guesses + " shots left\n");
	}
	
	public void guessSpot() {
		while(guesses != 0) {
			int x = guessSpotX();
			System.out.println();
			int y = guessSpotY();
			board.checkSpot(x, y);
			System.out.println();
			board.printBoard();
			guesses--;
			getGuesses();
		}
		System.out.println("You've run out of ammo! Game over.");
	}
	
	public int guessSpotX() {
		int xCord;
		while(true) {
			try {
				Scanner reader = new Scanner(System.in);
				System.out.println("Which X coordinate? ");
				xCord = reader.nextInt() - 1;
				break;
			} catch (Exception e) {
				System.out.println("That's not a number!");
			}
		}
		return xCord;
	}
	
	public int guessSpotY() {
		while(true) {
			try {
				Scanner reader = new Scanner(System.in);
				System.out.println("Which Y coordinate? ");
				int yCord = reader.nextInt() - 1;
				return yCord;
			} catch (Exception e) {
				System.out.println("That's not a number!");
			}
		}
	}
}
