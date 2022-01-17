public class Pawn extends ChessPiece {
	private int moveCount;

	/*
	 * Constructor 
	 */ 
	public Pawn() {
		moveCount = 0;
		chessPiece = "-p-";
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

		if ((moveCount == 0) && (newRow == currentRow - 2) || (newRow == currentRow - 1)) { // "-" because on board, row is decreasing
			moveCount++;
			return true;
		}
		else if (newRow == currentRow - 1) {
			moveCount++;
			return true;
		}
		else if ((moveCount == 0) && (newRow == currentRow + 2) || (newRow == currentRow + 1)) {
			return true;
		}
		else if (newRow == currentRow + 1) {
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
		return "-p-";
	}

}
