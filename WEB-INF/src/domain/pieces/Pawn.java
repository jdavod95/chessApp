package domain.pieces;

import java.util.ArrayList;
import java.util.List;

import domain.Position;
import trash.Board;
import trash.Player;

public class Pawn extends Piece{
	private final static int COST = 1;
	private final Position startPos;
	public Pawn(Position pos, Player owner) {
		super(pos, COST, owner);
		startPos = pos;
	}

	@Override
	protected List<Position> getMoves(Board board) {
		List<Position> moves = new ArrayList<>();
		int rowStep = 1;
		if(!getOwner().isLightPlayer())
			rowStep = -1;
		Position pos;
		if(startPos == getPos()) {
			pos = rushMove(board, rowStep);
			if(pos != getPos())
				moves.add(pos);
		}
		pos = step(board, rowStep);
		if(pos != getPos())
			moves.add(pos);
		
		pos = leftAttack(board, rowStep);
		if(pos != getPos())
			moves.add(pos);
		
		pos = rightAttack(board, rowStep);
		if(pos != getPos())
			moves.add(pos);
		
		return moves;
	}
	
	@Override
	protected List<Position> getMovesInCheck(Board board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Position rightAttack(Board board, int rowStep) {
		try {
			Position pos = new Position(
					getPos().getFileAsNumber() + 1, 
					getPos().getRowAsNumber() + rowStep);
			if(board.isOccupied(pos) && board.isOpposing(pos, getOwner())) 
				return pos;
		} catch (Exception e) {}
		return getPos();
	}

	private Position leftAttack(Board board, int rowStep) {
		try {
			Position pos = new Position(
					getPos().getFileAsNumber() - 1, 
					getPos().getRowAsNumber() + rowStep);
			if(board.isOccupied(pos) && board.isOpposing(pos, getOwner())) 
				return pos;
		} catch (Exception e) {}
		return getPos();
	}
	
	private Position step(Board board, int rowStep) {
		try {
			Position pos = new Position(
					getPos().getFileAsNumber(), 
					getPos().getRowAsNumber() + rowStep);
			if(!board.isOccupied(pos))
				return pos;
		} catch (Exception e) {}
		return getPos();
	}
	
	private Position rushMove(Board board, int rowStep) {
		Position pos = new Position(
				getPos().getFileAsNumber(), 
				getPos().getRowAsNumber() + rowStep*2);
		if(!board.isOccupied(pos))
			return pos;
		return getPos();
	}
	
}
