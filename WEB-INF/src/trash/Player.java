package trash;


import java.util.List;

import domain.pieces.Pawn;
import domain.pieces.Piece;

public class Player {
	private String name;
	private boolean inCheck;
	private final boolean lightPlayer;
	private int score;
	
	public Player(String name, boolean lightPlayer) {
		this.name = name;
		this.lightPlayer = lightPlayer;
		this.score = 0;
	}

	public boolean isInCheck() {
		return inCheck;
	}

	public void setInCheck(boolean inCheck) {
		this.inCheck = inCheck;
	}

	public boolean isLightPlayer() {
		return lightPlayer;
	}
	
	public boolean hasMoves(Board board) {
		List<Piece> pieces = board.getPlayersPieces(this);
		int sum = 0;
		for(Piece p : pieces) {
			sum += p.getPossibleMoves(board).size();
			if(sum > 0)
				return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int points) {
		score += points;
	}
	
	public void promote(Pawn pawn) {
		
	}
	
}
