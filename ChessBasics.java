import java.io.*;
import java.util.*;

public class ChessBasics {

	public static ChessPiece thePieceType(String pieceName) {
		ChessPiece thePiece = new Pawn();
	    if (pieceName.equals("pawn")) {
	    	thePiece = new Pawn();
	    }
	    else if (pieceName.equals("bishop")) {
	    	thePiece = new Bishop();
	    }
	    else if (pieceName.equals("knight")) {
	    	thePiece = new Knight();
	    }
	    else if (pieceName.equals("rook")) {
	    	thePiece = new Rook();
	    }
	    else if (pieceName.equals("king")){
	    	thePiece = new King();
	    }
	    else if (pieceName.equals("queen")) {
	    	thePiece = new Queen();
	    }

		// returns Object of specifc type of piece
		return thePiece;
	}

	public static void main(String[] args) throws FileNotFoundException, OutOfBoardException, IllegalChessMoveException {
	   	Scanner scan = new Scanner(new File("game.txt"));
	   	String line;
	   	String[] lineSegment;
	    // used to store file components in ArrayList for easy access
	    ArrayList<ArrayList<String>> fileList = new ArrayList<ArrayList<String>>();

	    // create Exceptions
	    OutOfBoardException outsideOfBoard = new OutOfBoardException("Invalid Board Position.");
	    IllegalChessMoveException badChessMove = new IllegalChessMoveException("Invalid Chess Piece Movement.");

	    // read in the file
	   	while(scan.hasNextLine())
	   	{
	      	line = scan.nextLine();
	       	lineSegment = line.split(" "); // stores all input in array of Strings
			if (lineSegment.length == 3 || lineSegment.length == 5) {
		       	// puts info from file into an ArrayList and then another ArrayList for access
		       	ArrayList<String> fileInfoList = new ArrayList<String>(Arrays.asList(lineSegment));
		       	fileList.add(fileInfoList);
		    }
	   	}

	   	// create and print the board
	    ChessBoard board = new ChessBoard(); 

	    System.out.println();
		System.out.println("     HERE IS THE STARTING BOARD  ");
		System.out.println("====================================");
	    System.out.println(board);

	    // create a new arrayList to store the current chess pieces being used
	    ArrayList<ChessPiece> theChessPieces = new ArrayList<ChessPiece>();

	    // Take information from File ArrayList and create Pieces/Objects
	    // set the pieces on the board as well
	    for (int i = 0; i < fileList.size(); i++) {
	    	if (fileList.get(i).size() == 3) {
		    	String piece = fileList.get(i).get(0);
		    	ChessPiece aPiece = thePieceType(piece);
		    	theChessPieces.add(aPiece);
		    	int coord1 = Integer.parseInt(fileList.get(i).get(1));
		    	int coord2 = Integer.parseInt(fileList.get(i).get(2));
		    	board.setPiece(aPiece.getChessPiece(), coord1, coord2);
		    }
	    }

	    System.out.println();
		System.out.println("     THE PIECES HAVE BEEN PLACED  ");
		System.out.println("====================================");
	    System.out.println(board);
	    System.out.println();

	    for (ArrayList<String> theMoves : fileList) { // get the moves from the file
	    	String startMoves = theMoves.get(0);
	    	if (startMoves.equals("move")) {
	    		int movePieceRow = Integer.parseInt(theMoves.get(1)); // the piece that has to be moved's row
	    		int movePieceCol = Integer.parseInt(theMoves.get(2)); // the piece that has to be moved's col

	    		int pieceCounter = 0; // help iterate through ArrayList of just ChessPieces
	    		for (ArrayList<String> thePiece : fileList) { // iterate from the beginning
	    			if (thePiece.size() == 3) { // look for only the pieces
	    				int thePieceRow = Integer.parseInt(thePiece.get(1)); // current piece's row position
	    				int thePieceCol = Integer.parseInt(thePiece.get(2)); // current piece's col position

	    				// if the file's move coordinates match the current piece coordinates, update them in the ArrayList
	    				if (movePieceRow == thePieceRow && movePieceCol == thePieceCol) { 
	    					try {
		    					System.out.println("" + thePiece.get(0).toUpperCase() + ": (" + movePieceRow + "," + movePieceCol + ") (" + theMoves.get(3) + "," + theMoves.get(4) + ")");
		    					int tryToMoveRow = Integer.parseInt(theMoves.get(3));
		    					int tryToMoveCol = Integer.parseInt(theMoves.get(4));
		    					if ( (tryToMoveRow > board.getSize()-1 || tryToMoveRow < 0) || (tryToMoveCol > board.getSize()-1 || tryToMoveCol < 0) ) {
		    						throw new OutOfBoardException("Invalid Board Position.");
		    					}

		    					try {
			    					if (theChessPieces.get(pieceCounter).move(movePieceRow, movePieceCol, Integer.parseInt(theMoves.get(3)), Integer.parseInt(theMoves.get(4)))) {
			    						System.out.print("Moved!");
										System.out.println(" (" + movePieceRow + "," + movePieceCol + ")" + " (" + theMoves.get(3) + "," + theMoves.get(4) + ")");

				    					thePiece.set(1, theMoves.get(3));
				    					thePiece.set(2, theMoves.get(4));

				    					System.out.println("========================================");
				    					board.setPiece("---", thePieceRow, thePieceCol);
				    					board.setPiece(theChessPieces.get(pieceCounter).getChessPiece(), Integer.parseInt(theMoves.get(3)), Integer.parseInt(theMoves.get(4)));
				    					System.out.println(board);
				    					System.out.println();
			    					}
			    					else { // invalid move
			    						throw new IllegalChessMoveException("Illegal Chess Move.");
			    					}
			    				} 
			    				catch (IllegalChessMoveException exception) {
			    					System.out.println(exception.getMessage() + " (" + movePieceRow + "," + movePieceCol + ") (" + theMoves.get(3) + "," + theMoves.get(4) + ")");
			    					System.out.println("========================================");
			    					System.out.println(board);
			    					System.out.println();
			    					
			    				}
			    			}
		    				catch (OutOfBoardException exception) {
		    					System.out.println(exception.getMessage() + " (" + movePieceRow + "," + movePieceCol + ") (" + theMoves.get(3) + "," + theMoves.get(4) + ")");
		    					System.out.println("========================================");
		    					System.out.println(board);
		    					System.out.println();
		    					
		    				}

	    				}
	    				pieceCounter++;
	    			} 

	    		} // end nested for loop

	    	}

		}
	}

} 



