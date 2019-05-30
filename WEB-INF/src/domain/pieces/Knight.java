package domain.pieces;

import java.util.ArrayList;
import java.util.List;

import domain.Position;
import trash.Board;
import trash.Player;

public class Knight extends Piece{
	private final static int COST = 3;
	public Knight(Position pos, Player owner) {
		super(pos, COST, owner);
	}
	@Override
	protected List<Position> getMoves(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				if(Math.abs(i) + Math.abs(j) == 3) {
					try {
						pos = new Position(
								getPos().getFileAsNumber() + i ,
								getPos().getRowAsNumber() + j);
						if(!board.isOccupied(pos) || board.isOpposing(pos, getOwner())) 
								moves.add(pos);
					} catch(Exception e) {}
				}
			}
		}
		return moves;
	}
	@Override
	protected List<Position> getMovesInCheck(Board board) {
		return null;
	}

}
