package trash;

import chessIO.IOService;
import domain.Position;

public class Game {
	private Player light;
	private Player dark;
	private Board board;
	private IOService io;
	
	public Game(IOService io, Player player1, Player player2) {
		this.light = player1;
		this.dark = player1;
		this.io = io;
		if(player2.isLightPlayer())
			light = player2;
		else
			dark = player2;
		
		this.board = new Board(light, dark);
	}
	
	public void start() {
		while(true) {
			if(!light.hasMoves(board)) {
				if(light.isInCheck()) 
					win(dark);
				else
					draw();
				break;
			} else {
				move(light);
			}
			
			if(!dark.hasMoves(board)) {
				if(dark.isInCheck()) 
					win(light);
				else
					draw();
				break;
			} else {
				move(dark);
			}
		}
	}
	
	private void move(Player player) {
		// gets 2 positions
		// the first is the vpiece wich has to be moved
		// second is the target
		// if the first pos is invalid (not owned by the player or non existing pos)
		// asks another for another pos
		
		Position piecePos = null;
		Position target = null; 
		boolean validTarget = false;
		
		while(validTarget) {
			piecePos = io.askPiece();
			if(!board.getPiece(piecePos).getOwner().equals(player))
				continue;
			target = io.askTarget(); 
			if(board.getPiece(piecePos).getPossibleMoves(board).contains(target))
				validTarget = true;
		}
		board.getPiece(piecePos).moveTo(target, board);
		io.updateTable(board.getPieces());
	}
	
	private void draw() {
		io.gameOver("Draw game!");
	}
	private void win(Player player) {
		io.gameOver(player.getName()+" wins the game!");
	}

	public Board getBoard() {
		return board;
	}
}
