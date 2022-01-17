public class Bishop extends ChessPiece {
	
	/*
	 * Constructor
	 */
	public Bishop() {
		chessPiece = "-b-";
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

		// bottom left to top right DIAGONAL
		// makes sure the num of rows moved == num of cols moved to ensure its a diagonal move
		if ((newCol - currentCol) == (newRow - currentRow)) {
			return true;
		}
		// top left to bottom right DIGONAL
		// the difference between the two will always be one POSITIVE and one NEGATIVE
		// so * -1 to balance them out. 
		else if ((newCol - currentCol) == (-1 * (newRow - currentRow))) {
			return true;
		}
		else {
			return false;
		}

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
		return "-b-";
	}

}