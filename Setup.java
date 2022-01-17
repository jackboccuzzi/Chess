import java.io.*;
import java.util.*;

public class Setup {

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

    // returns Object of specifc type of piece
    return thePiece;
  }

	public static void main(String[] args) throws FileNotFoundException {
   	Scanner scan = new Scanner(new File("input1.txt"));
   	String line;
   	String[] lineSegment;
    // used to store file components in ArrayList for easy access
    ArrayList<ArrayList<String>> fileList = new ArrayList<ArrayList<String>>();

   	while(scan.hasNextLine())
   	{
      	line = scan.nextLine();
       	lineSegment = line.split(" "); // stores all input in array of Strings
			 System.out.println(lineSegment[0]);

       // puts info from file into an ArrayList and then another ArrayList for access
       ArrayList<String> fileInfoList = new ArrayList<String>(Arrays.asList(lineSegment));
       fileList.add(fileInfoList);

   	}

    ChessBoard board = new ChessBoard(); // creating board 
    System.out.println(board);

    // Take information from File ArrayList and create Pieces/Objects
    // set the pieces on the board as well
    for (int i = 0; i < fileList.size(); i++) {
      String piece = fileList.get(i).get(0);
      ChessPiece aPiece = thePieceType(piece);
      int coord1 = Integer.parseInt(fileList.get(i).get(1));
      int coord2 = Integer.parseInt(fileList.get(i).get(2));
      board.setPiece(aPiece.getChessPiece(), coord1, coord2);
    }

    System.out.println();
    System.out.println(board);


	}

}
