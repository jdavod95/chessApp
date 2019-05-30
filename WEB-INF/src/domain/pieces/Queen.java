package domain.pieces;

import java.util.ArrayList;
import java.util.List;

import domain.Position;
import trash.Board;
import trash.Player;

public class Queen extends Piece{
	private final static int COST = 9;
	public Queen(Position pos, Player owner) {
		super(pos, COST, owner);
	}

	@Override
	protected List<Position> getMoves(Board board) {
		List<Position> moves = new ArrayList<>();
		moves.addAll(getDiagonalMoves(board));
		moves.addAll(getStraightMoves(board));
		return moves;
	}
	
	@Override
	protected List<Position> getMovesInCheck(Board board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Position> getDiagonalMoves(Board board) {
		List<Position> moves = new ArrayList<>();
		moves.addAll(getMovesNorthWest(board));
		moves.addAll(getMovesSouthWest(board));
		moves.addAll(getMovesNorthEast(board));
		moves.addAll(getMovesSouthEast(board));
		return moves;
	}

	private List<Position> getStraightMoves(Board board) {
		List<Position> moves = new ArrayList<>();
		moves.addAll(getMovesEast(board));
		moves.addAll(getMovesWest(board));
		moves.addAll(getMovesNorth(board));
		moves.addAll(getMovesSouth(board));
		return moves;
	}

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

	private List<Position> getMovesSouth(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getRow(); i > Position.ROW_MIN; i--) {	
			pos = new Position(getPos().getFileAsNumber(), i - Position.ROW_MIN);
			if(board.isOccupied(pos)) {
				if(board.isOpposing(pos, getOwner())) 
					moves.add(pos);
				break;
			} else {
				moves.add(pos);
			}
		}
		return moves;
	}

	private List<Position> getMovesNorth(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getRow(); i < Position.ROW_MAX; i++) {	
			pos = new Position(getPos().getFileAsNumber(), i - Position.ROW_MIN);
			if(board.isOccupied(pos)) {
				if(board.isOpposing(pos, getOwner())) 
					moves.add(pos);
				break;
			} else {
				moves.add(pos);
			}
		}
		return moves;
	}
	
	private List<Position> getMovesWest(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getFile(); i > Position.FILE_MIN; i--) {	
			pos = new Position(i - Position.FILE_MIN, getPos().getRowAsNumber());
			if(board.isOccupied(pos)) {
				if(board.isOpposing(pos, getOwner())) 
					moves.add(pos);
				break;
			} else {
				moves.add(pos);
			}
		}
		return moves;
	}

	private List<Position> getMovesEast(Board board) {
		List<Position> moves = new ArrayList<>();
		Position pos;
		for (int i = getPos().getFile(); i < Position.FILE_MAX; i++) {
			pos = new Position(i - Position.FILE_MIN, getPos().getRowAsNumber());
			if(board.isOccupied(pos)) {
				if(board.isOpposing(pos, getOwner())) 
					moves.add(pos);
				break;
			} else {
				moves.add(pos);
			}
		}
		return moves;
	}
}
