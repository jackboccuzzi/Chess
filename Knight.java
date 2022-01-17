public class Knight extends ChessPiece {

	/* 
	 * Constructor
	 */	
	public Knight() {
		chessPiece = "-h-";
	}

	/*
	 * Move Method -
	 * Checks to see if move from (coord1, coord2) to (newCoord1, newCoord2) is valid
	 */
	public boolean move(int coord1, int coord2, int newCoord1, int newCoord2) {
		int currentRow = Math.abs(7 - coord2);
		int currentCol = coord1;
		int newRow = Math.abs(7 - newCoord2);
		int newCol = newCoord1;

		// left 2, up/down 1
		if (newRow == currentRow - 2) {
			if ((newCol == currentCol + 1) || (newCol == currentCol - 1)) {
				return true;
			}
		}
		// right 2, up/down 1
		else if (newRow == currentRow + 2) {
			if ((newCol == currentCol + 1) || (newCol == currentCol - 1)) {
				return true;
			}
		}
		// up 2, left/right 1
		else if (newCol == currentCol + 2) {
			if ((newRow == currentRow + 1) || (newRow == currentRow - 1)) {
				return true;
			}
		}
		// down 2, left/right 1
		else if (newCol == currentCol - 2) {
			if ((newRow == currentRow + 1) || (newRow == currentRow - 1)) {
				return true;
			}
		}
		// anything else (invalid move)
		else {
			return false;
		}

		return false;

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
		return "-h-";
	}
}