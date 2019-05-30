package game;

import domain.Position;
import domain.pieces.Piece;

public class Move {
	private final static String LONGCASTLE = "O-O-O";
	private final static String SHORTCASTLE = "O-O";

	private final static char CAPTURE = 'x';
	private final static char CHECK = '+';
	private final static char MATE = '+';
	private final static char PROMOTE = '=';
	private final static char CLEAR = ' ';
	
	private Player player;
	private Position target;
	private Piece piece;
	private char action;
	
	public Move(Player player, Position target, Piece piece, char action) {
		this.player = player;
		this.target = target;
		this.piece = piece;
		this.action = action;
	}

	public Move(Player player, Position pos, Piece piece) {
		this(player, pos, piece, CLEAR);
	}

	@Override
	public String toString() {
		return piece.getClass().getSimpleName().charAt(0) + "" + target;
	}
	
	
	
}
