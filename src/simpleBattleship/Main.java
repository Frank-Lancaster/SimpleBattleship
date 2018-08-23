package simpleBattleship;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		game.getBoardSize();
		game.getGuesses();
		game.guessSpot();
	}

}
