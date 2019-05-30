package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Position;
import domain.pieces.Piece;

public class Game {

	private Player lightPlayer;
	private Player darkPlayer;
	private List<Move> moves;
	private Player currentPlayer;
	
	public Game(Player lightPlayer, Player darkPlayer) {
		this.lightPlayer = lightPlayer;
		this.darkPlayer = darkPlayer;
		moves = new ArrayList<Move>();
		currentPlayer = lightPlayer;
	}
	
	public boolean makeMove(Piece piece, Position pos) {
		checkGameOver();
		if(!validMove(piece, pos))
			return false;
		piece.moveTo(pos);
		moves.add(new Move(currentPlayer, pos, piece));
		switchTurn();
		return true;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private boolean validMove(Piece piece, Position pos) {
		if(!piece.getOwner().equals(currentPlayer))
			return false;
		if(!piece.getPossibleMoves(getAllPieces()).contains(pos))
			return false;
		return true;
	}

	private Map<Piece, Position> getAllPieces() {
		HashMap<Piece, Position> pieces = new HashMap<Piece, Position>();
		pieces.putAll(darkPlayer.getPieces());
		pieces.putAll(lightPlayer.getPieces());
		return pieces;
	}

	private void switchTurn() {
		if(lightsTurn())
			currentPlayer = darkPlayer;
		else 
			currentPlayer = lightPlayer;
	}
	
	public boolean lightsTurn() {
		return lightPlayer.equals(currentPlayer);
	}
	
	private void checkGameOver() {
		if(!currentPlayer.hasMoves(getAllPieces()))
			if(currentPlayer.isChecked()) {
				if(lightsTurn())
					gameOver(darkPlayer.getName());
				else
					gameOver(lightPlayer.getName());
			} else 
				gameOver("draw");
	}
	
	private void gameOver(String string) {
		if(string.equals("draw"))
			return;
		else
			return;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	
}
