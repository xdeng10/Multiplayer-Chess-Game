package chessGame;

public class Board {
	private Piece[][] board = new Piece[8][8];
	
	//Initializing a new Chess Board
	Board(){
		this.board[0][0] = new Rook("Black", 0, 0);
		this.board[0][1] = new Knight("Black", 0, 1);
		this.board[0][2] = new Bishop("Black", 0, 2);
		this.board[0][3] = new Queen("Black", 0, 3);
		this.board[0][4] = new King("Black", 0, 4);
		this.board[0][5] = new Bishop("Black", 0, 5);
		this.board[0][6] = new Knight("Black", 0, 6);
		this.board[0][7] = new Rook("Black", 0, 7);
		
		this.board[1][0] = new Pawn("Black", 1, 0);
		this.board[1][1] = new Pawn("Black", 1, 1);
		this.board[1][2] = new Pawn("Black", 1, 2);
		this.board[1][3] = new Pawn("Black", 1, 3);
		this.board[1][4] = new Pawn("Black", 1, 4);
		this.board[1][5] = new Pawn("Black", 1, 5);
		this.board[1][6] = new Pawn("Black", 1, 6);
		this.board[1][7] = new Pawn("Black", 1, 7);
		
		this.board[6][0] = new Pawn("White", 6, 0);
		this.board[6][1] = new Pawn("White", 6, 1);
		this.board[6][2] = new Pawn("White", 6, 2);
		this.board[6][3] = new Pawn("White", 6, 3);
		this.board[6][4] = new Pawn("White", 6, 4);
		this.board[6][5] = new Pawn("White", 6, 5);
		this.board[6][6] = new Pawn("White", 6, 6);
		this.board[6][7] = new Pawn("White", 6, 7);
		
		this.board[7][0] = new Rook("White", 7, 0);
		this.board[7][1] = new Knight("White", 7, 1);
		this.board[7][2] = new Bishop("White", 7, 2);
		this.board[7][3] = new Queen("White", 7, 3);
		this.board[7][4] = new King("White", 7, 4);
		this.board[7][5] = new Bishop("White", 7, 5);
		this.board[7][6] = new Knight("White", 7, 6);
		this.board[7][7] = new Rook("White", 7, 7);
	}
	
	//Get the piece of a certain position
	public Piece getPiece(int row, int col) {
		if(this.board[row][col] != null) {
			return this.board[row][col];
		}
		return null;
	}
	
	/*
	 * Allows pieces to move around the chess board, while ensuring that the moves are legal.
	 */
	public boolean movePiece(int currRow, int currCol, int newRow, int newCol) {
		Piece currPiece = this.getPiece(currRow, currCol);
		if(currPiece.legalMove(newRow, newCol, this)) {
			if(this.getPiece(newRow, newCol) != null) {
				Piece oldPiece = this.board[newRow][newCol];
				System.out.println(oldPiece.toString() + " was eaten by " + currPiece.toString());
				oldPiece.setCol(-1);
				oldPiece.setRow(-1);
			}
			currPiece.setRow(newRow);
			currPiece.setCol(newCol);
			this.board[newRow][newCol] = currPiece;
			this.board[currRow][currCol] = null;
			
			return true;
		}
		return false;
	}
	
	
	//Print chess board with chess pieces using unicode.
	public void printBoard() {
		System.out.printf("    (0)  (1)  (2)  (3)  (4)  (5)  (6)  (7)\n");
		for(int i=0; i<8; i++) {
			System.out.printf("(%d)",i);
			for(int j=0; j<8; j++) {
				if(board[i][j]==null) {
					System.out.printf("[   ]");
				}else {
					System.out.printf("[ %s ]",board[i][j].getEmoji());
				}
			}
			System.out.printf("\n");
		}
		System.out.println();
	}
	
	
	

}
