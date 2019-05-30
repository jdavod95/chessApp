package domain;

public class Position {
	public final static char FILE_MIN = 'A';
	public final static char FILE_MAX = 'H';
	public final static char ROW_MIN = '1';
	public final static char ROW_MAX = '8';

	private char file;
	private char row;

	public Position(char file, char row) {
		checkBounds(file, row);
		this.file = file;
		this.row = row;
	}
	public Position(int file, int row) {
		this((char)(file + FILE_MIN), (char)(row + ROW_MIN));
	}
	
	private void checkBounds(char file, int row) {
		if((file < FILE_MIN || file > FILE_MAX) || 
			(row < ROW_MIN || row > ROW_MAX)) {
			throw new RuntimeException(
				"Position must be between "
				+FILE_MIN + ROW_MIN + " and "
				+FILE_MAX + ROW_MAX);
		}
	}
	
	public char getFile() {
		return file;
	}

	public void setFile(char file) {
		this.file = file;
	}

	public char getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}
	
	public int getFileAsNumber() {
		return file - FILE_MIN;
	}
	
	public int getRowAsNumber() {
		return row - ROW_MIN;
	}

	@Override
	public String toString() {
		return file + "" + row;
	}
	
	
}
