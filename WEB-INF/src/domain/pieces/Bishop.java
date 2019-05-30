package domain.pieces;

import java.util.ArrayList;
import java.util.List;

import domain.Position;
import trash.Board;
import trash.Player;

public class Bishop extends Piece{
	private final static int COST = 3;
	public Bishop(Position pos, Player owner) {
		super(pos, COST, owner);
	}

	@Override
	protected List<Position> getMoves(Board board) {
		List<Position> moves = new ArrayList<>();
		moves.addAll(getMovesNorthWest(board));
		moves.addAll(getMovesSouthWest(board));
		moves.addAll(getMovesNorthEast(board));
		moves.addAll(getMovesSouthEast(board));
		return moves;
	}
	
	@Override
	protected List<Position> getMovesInCheck(Board board) {
		return null;
	}
	//code dupe nation
	private List<Position> getMovesSouthEast(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getFile(); i < Position.FILE_MAX; i++) {
			try {
				pos = new Position(
						getPos().getFileAsNumber() + i - Position.FILE_MIN,
						getPos().getRowAsNumber() - i - Position.FILE_MIN
						);
				if(board.isOccupied(pos)) {
					if(board.isOpposing(pos, getOwner())) 
						moves.add(pos);
					break;
				} else {
					moves.add(pos);
				}
			} catch(Exception e) {}
		}
		return moves;
	}

	private List<Position> getMovesNorthEast(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getFile(); i < Position.FILE_MAX; i++) {
			try {
				pos = new Position(
						getPos().getFileAsNumber() + i - Position.FILE_MIN,
						getPos().getRowAsNumber() + i - Position.FILE_MIN 
						);
				if(board.isOccupied(pos)) {
					if(board.isOpposing(pos, getOwner())) 
						moves.add(pos);
					break;
				} else {
					moves.add(pos);
				}
			} catch(Exception e) {}
		}
		return moves;
	}

	private List<Position> getMovesSouthWest(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getFile(); i > Position.FILE_MIN; i--) {
			try {
				pos = new Position(
						getPos().getFileAsNumber() - i - Position.FILE_MIN,
						getPos().getRowAsNumber() - i - Position.FILE_MIN 
						);
				if(board.isOccupied(pos)) {
					if(board.isOpposing(pos, getOwner())) 
						moves.add(pos);
					break;
				} else {
					moves.add(pos);
				}
			} catch(Exception e) {}
		}
		return moves;
	}

	private List<Position> getMovesNorthWest(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getFile(); i < Position.FILE_MAX; i++) {
			try {
				pos = new Position(
						getPos().getFileAsNumber() + i - Position.FILE_MIN,
						getPos().getRowAsNumber() - i - Position.FILE_MIN
						);
				if(board.isOccupied(pos)) {
					if(board.isOpposing(pos, getOwner())) 
						moves.add(pos);
					break;
				} else {
					moves.add(pos);
				}
			} catch(Exception e) {}
		}
		return moves;
	}

}
