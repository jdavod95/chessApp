package domain.pieces;

import java.util.List;
import java.util.Map;

import domain.Position;
import trash.Player;

public abstract class Piece {
	
	private final Player owner;
	private final int cost;
	private Position pos;
	
	public Piece(Position pos, int cost, Player owner) {
		super();
		this.pos = pos;
		this.owner = owner;
		this.cost = cost;
	}

	public Player getOwner() {
		return owner;
	}

	public int getCost() {
		return cost;
	}

	public Position getPos() {
		return pos;
	}

	private void setPos(Position pos) {
		this.pos = pos;
	}
	
	public final void moveTo(Position pos) {
		setPos(pos);
	}

	public final List<Position> getPossibleMoves(Map<Piece, Position> map){
		List<Position> moves;
		if(!getOwner().isInCheck()) {
			moves = getMoves(map);
		} else {
			moves = getMovesInCheck(map);
		}
		return moves;
	}

	protected abstract List<Position> getMoves(Map<Piece, Position> map);
	protected abstract List<Position> getMovesInCheck(Map<Piece, Position> map);
}
