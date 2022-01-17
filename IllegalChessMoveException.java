public class IllegalChessMoveException extends Exception {
	
	/* 
	 * Exception for an illegal chess piece movement (pawn trying to move diagonally, etc.)
	 */

	/* 
	 * Default Constructor
	 */	
	public IllegalChessMoveException() {
		super();
	}

	/* 
	 * Constructor
	 */
	public IllegalChessMoveException(String message) {
		super(message);
	}

}