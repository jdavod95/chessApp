package domain.pieces;

import java.util.ArrayList;
import java.util.List;

import domain.Position;
import trash.Board;
import trash.Player;

public class King extends Piece{
	private final static int COST = 0;
	public King(Position pos, Player owner) {
		super(pos, COST, owner);
	}

	@Override
	protected List<Position> getMoves(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = -1; i < 1; i++) {
			for (int j = -1; j < 1; j++) {
				pos = new Position(
						getPos().getFileAsNumber() + j,
						getPos().getRowAsNumber() + i
						);
				if(board.isOccupied(pos)) {
					if(board.isOpposing(pos, getOwner())) 
						moves.add(pos);
					break;
				} else {
					moves.add(pos);
				}
			}
		}
		List<Piece> pieces = board.getOpponentPieces(getOwner());
		for(Piece p : pieces)
			for (Position move : moves) {
				List<Position> opponentMoves = p.getPossibleMoves(board);
				if(opponentMoves.contains(move))
					moves.remove(move);
			}
		return moves;
	}

	@Override
	protected List<Position> getMovesInCheck(Board board) {
		return null;
	}

}
