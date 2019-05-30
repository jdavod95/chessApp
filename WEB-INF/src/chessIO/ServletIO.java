package chessIO;

import java.util.Map;

import domain.Position;
import domain.pieces.Piece;
import trash.Board;

public class ServletIO implements IOService{

	@Override
	public Position askTarget() {
		Position pos = new Position('A','1');
		return pos;
	}

	@Override
	public Position askPiece() {
		Position pos = new Position('A','1');
		return pos;
	}

	@Override
	public void gameOver(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTable(Map<Position, Piece> pieces) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Position, Piece> getPieces(Board board) {
		return board.getPieces();
	}

}
