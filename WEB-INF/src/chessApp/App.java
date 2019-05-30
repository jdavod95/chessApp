package chessApp;

import chessIO.IOService;
import trash.Board;
import trash.Game;
import trash.Player;

public class App {
	private Game game;
	public void main(IOService io, Player p1, Player p2) {
		game = new Game(io, p1, p2);
		game.start();
	}

	public Board getBoard() {
		return game.getBoard();
	}
}
