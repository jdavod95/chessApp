package game;

import java.util.HashMap;
import java.util.Map;

import domain.Position;
import domain.pieces.Pawn;
import domain.pieces.Piece;

public class Player {
	private Map<Piece, Position> tray;
	private Map<Piece, Position> pieces;
	private String name;
	private int score;
	
	public Map<Piece, Position> getPieces() {
		return new HashMap<Piece, Position>(pieces);
	}

	public boolean hasMoves(Map<Piece, Position> map) {
		int sum = 0;
		for(Piece p : pieces.keySet()) {
			sum += p.getPossibleMoves(map).size();
			if(sum > 0)
				return true;
		}
		return false;
	}

	public boolean isChecked() {
		return false;
	}

	public String getName() {
		return name;
	}
	
	public void promote(Pawn pawn) {
		
	}
}
