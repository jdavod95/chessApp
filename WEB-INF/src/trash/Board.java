package trash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.PieceLayout;
import domain.Position;
import domain.pieces.Piece;

public class Board {

	private Map<Position, Piece> pieces;
	
	public Board(Player lightPlayer, Player darkPlayer) {
		this.pieces = PieceLayout.initPieces(lightPlayer, darkPlayer);
	}

	public boolean isOccupied(Position pos) {
		return pieces.containsKey(pos);
	}
	
	public boolean isOpposing(Position pos, Player owner) {
		return getPiece(pos).getOwner().equals(owner);
	}
	
	public Piece getPiece(Position pos) {
		return pieces.get(pos);
	}
	
	public List<Piece> getOpponentPieces(Player player){
		List<Piece> pieces = new ArrayList<>();
		pieces.addAll(this.pieces.values());
		for(Piece p : pieces)
			if(!p.getOwner().equals(player))
				pieces.remove(p);
		return pieces;
	}
	
	public List<Piece> getPlayersPieces(Player player){
		List<Piece> pieces = new ArrayList<>();
		pieces.addAll(this.pieces.values());
		for(Piece p : pieces)
			if(p.getOwner().equals(player))
				pieces.remove(p);
		return pieces;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void updatePieces(Position pos, Piece piece) {
		pieces.remove(piece);
		if(pieces.replace(pos, piece) == null)
			pieces.put(pos, piece);
		
	}

	public Map<Position, Piece> getPieces() {
		return new HashMap<Position, Piece>(pieces);
	}
	
	
}
