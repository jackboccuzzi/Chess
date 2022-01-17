public class Rook extends ChessPiece {
	
	/*
	 * Constructor
	 */ 
	public Rook(){
		chessPiece = "-r-";
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

		// move vertically
		if (currentRow == newRow && (currentCol >= 0 || currentCol <= 7)) {
			return true;
		}
		// move horizontally
		else if (currentCol == newCol && (currentRow >= 0 || currentRow <= 7)) {
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
		return "-r-";
	}
}