public class OutOfBoardException extends Exception {
	
	/* 
	 * Exception for a move whose destination is outside of the playing board
	 */

	/* 
	 * Default Constructor
	 */
	public OutOfBoardException() {
		super();
	}

	/* 
	 * Constructor
	 */
	public OutOfBoardException(String message) {
		super(message);
	}

	
}