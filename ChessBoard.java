public class ChessBoard {

	private int size;
    private String[][] board;

    /*
	 * Constructor 
	 */ 
    public ChessBoard() {

    	board = new String[8][8];
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			board[i][j] = "---";
    		}
    	}
    }

    public void setPiece(String piece, int coord1, int coord2) {
    	// Had to figure out how to Flip the board around
    	board[Math.abs(7-coord2)][coord1] = piece;
    }

    /*
     * Get Size of the board
     */
    public int getSize() {
        return board.length;
    }

    /*
	 * Get the piece 
	 */ 
    public String getPiece(int i, int j) {
    	return board[i][j];
    }

    /*
	 * toString Method to Print the board
	 */ 
    @Override
    public String toString() {
    	String output = "";
    	int count = 7;

    	for (int i = 0; i < 8; i++) {
    		output += "=" + count + "= ";
    		for (int j = 0; j < 8; j++) {
    			output += board[i][j] + " ";
    		}
			output += "\n";
    		count--;
    	}

    	// print the last row
    	count = 0;
    	output += "===";
    	for (int i = 0; i < 8; i++) {
    		output += " =" + count + "=";
    		count++;
    	}

    	return output;
    }

}