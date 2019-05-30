package chessIO;

import java.util.Map;

import domain.Position;
import domain.pieces.Piece;
import trash.Board;

public interface IOService {
	public Position askTarget();
	public Position askPiece();
	public void updateTable(Map<Position, Piece> pieces);
	public void gameOver(String msg);
	public Map<Position, Piece> getPieces(Board board);
}
