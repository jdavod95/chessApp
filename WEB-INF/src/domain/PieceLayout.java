package domain;

import java.util.HashMap;
import java.util.Map;

import domain.pieces.Piece;
import domain.pieces.Rook;
import trash.Player;

public class PieceLayout {
	
	/*
	 * a1 light	rook
	 * b1 		knight
	 * c1	 	bishop
	 * d1 		queen
	 * e1 		king
	 * f1 		bishop
	 * g1 		knight
	 * h1 		rook
	 * a2 - h2 white pawn
	 * 
	 * a8 dark	rook
	 * b8 		knight
	 * c8	 	bishop
	 * d8 		queen
	 * e8 		king
	 * f8 		bishop
	 * g8 		knight
	 * h8 		rook
	 * a7 - h7 dark pawn
	 * 
	 * */
	public static Map<Position, Piece> initPieces(Player lightPlayer, Player darkPlayer){
		Map<Position, Piece> pieces = new HashMap<>();
		pieces.putAll(getLightPieces(lightPlayer));
		pieces.putAll(getDarkPieces(darkPlayer));
		return pieces;
	}
	
	private static Map<Position, Piece> getLightPieces(Player player){
		Map<Position, Piece> pieces = new HashMap<>();
		Position pos;
		pos = new Position('A','1');
		pieces.put(pos, new Rook(pos, player));
		return pieces;
	}
	
	private static Map<Position, Piece> getDarkPieces(Player player){
		Map<Position, Piece> pieces = new HashMap<>();
		Position pos;
		pos = new Position('A','8');
		pieces.put(pos, new Rook(pos, player));
		return pieces;
	}
}
