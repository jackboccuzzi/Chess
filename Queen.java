public class Queen extends ChessPiece {

	/*
	 * Constructor
	 */ 
	public Queen() {
		chessPiece = "-Q-";
	}

	/*
	 * Move Method
	 */ 
	public boolean move(int coord1, int coord2, int newCoord1, int newCoord2) {
		int currentRow = Math.abs(7 - coord2);
		int currentCol = coord1;
		int newRow = Math.abs(7 - newCoord2);
		int newCol = newCoord1;

		// move vertically
		if (currentRow == newRow && (currentCol >= 0 || currentCol <= 7)) {
			return true;
		}
		// move horizontally
		else if (currentCol == newCol && (currentRow >= 0 || currentRow <= 7)) {
			return true;
		}
		// bottom left to top right DIAGONAL
		else if ((newCol - currentCol) == (newRow - currentRow)) {
			return true;
		}
		// top left to bottom right DIGONAL
		else if ((newCol - currentCol) == (-1 * (newRow - currentRow))) {
			return true;
		}
		else {
			return false;
		}
	}

	/*
	 * Get the Chess Piece
	 */ 
	public String getChessPiece() {
		return chessPiece;
	}	

	/*
	 * toString Method
	 */ 
	@Override
	public String toString() {
		return "-Q-";
	}
}