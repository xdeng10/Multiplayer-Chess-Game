package chessGame;

public class Pawn implements Piece {
	private String color;
	private int row;
	private int col;
	private boolean firstMove;

	Pawn(String color, int row, int col){
		this.color = color;
		this.row = row;
		this.col = col;
		this.firstMove = true;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public String getColor() {
		return color;
	}
	public boolean getFirstMove() {
		return firstMove;
	}

	public boolean legalMove(int newRow, int newCol, Board chessBoard) {
		if (newRow == this.row && newCol == this.col) {
			return false;
		} else if (this.color == "Black") {
			if(newCol == this.col) {
				if(newRow-this.row == 2 && this.firstMove == true && chessBoard.getPiece(newRow, newCol) == null) {
					return true;
				}else if(newRow-this.row == 1 && chessBoard.getPiece(newRow, newCol) == null) {
					return true;
				}
				return false;
			}else if((newRow-this.row)==1 && Math.abs(newCol-this.col)==1 && chessBoard.getPiece(newRow, newCol) != null) {
				if(chessBoard.getPiece(newRow, newCol).getColor() != this.color) {
					return true;
				}
				return false;
			}
		} else if (this.color == "White") {
			if(newCol == this.col) {
				if(newRow-this.row == -2 && this.firstMove == true && chessBoard.getPiece(newRow, newCol) == null) {
					return true;
				}else if(newRow-this.row == -1 && chessBoard.getPiece(newRow, newCol) == null) {
					return true;
				}
				return false;
			}else if((newRow-this.row)==-1 && Math.abs(newCol-this.col)==1 && chessBoard.getPiece(newRow, newCol) != null) {
				if(chessBoard.getPiece(newRow, newCol).getColor() != this.color) {
					return true;
				}
				return false;
			}
			
		}
		return false;
	}
	
	
	public String getEmoji() {
		if(color == "White") {
			return "\u2659";
		}else {
			return "\u265F";
		}
	}

	public String toString() {
		if (color == "White") {
			return color + " Pawn: \u2659  (P)";
		} else {
			return color + " Queen: \u265F (P)";
		}

	}

}
