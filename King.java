public class King extends ChessPiece {

	/* 
	 * Constructor
	 */
	public King() {
		chessPiece = "-K-";
	}

	/* 
	 * Move Method
	 */
	public boolean move(int coord1, int coord2, int newCoord1, int newCoord2) {
		int currentRow = Math.abs(7 - coord2);
		int currentCol = coord1;
		int newRow = Math.abs(7 - newCoord2);
		int newCol = newCoord1;

		// up/down 1
		if ((newRow == currentRow - 1) || (newRow == currentRow + 1)) { 
			return true;
		}
		// left/right 1
		else if ((newCol == currentCol - 1) || (newCol == currentCol + 1)) { 
			return true;
		}
		// make sure diagonal is only 1 space
		else if ((newCol - currentCol == 1) && (newRow - currentRow == 1)) {
			if((newCol - currentCol) == (newRow - currentRow)) {
				return true;
			}
		}
		// make sure diagonal is only 1 space
		else if ((newCol - currentCol == 1) && (newRow - currentRow == 1)) {
			if ((newCol - currentCol) == (-1 * (newRow - currentRow))) {
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}

	/* 
	 * Getter Method
	 */
	public String getChessPiece() {
		return chessPiece;
	}	

	/*
	 * toString Method
	 */ 
	@Override
	public String toString() {
		return "-K-";
	}

}