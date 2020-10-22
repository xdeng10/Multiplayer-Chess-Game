package chessGame;

public class King implements Piece {
	private String color;
	private int row;
	private int col;
	
	King(String color, int row, int col){
		this.color = color;
		this.row = row;
		this.col = col;
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
	

	public boolean legalMove(int newRow, int newCol, Board chessBoard) {
		if (newRow == this.row && newCol == this.col) {
			return false;
		} else if (chessBoard.getPiece(newRow, newCol) != null && chessBoard.getPiece(newRow, newCol).getColor() == this.color) {
			return false;
		} else if(Math.abs(newRow-this.row) <= 1 && Math.abs(newCol-this.col) <= 1) {
			if(chessBoard.getPiece(newRow, newCol) == null) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String getEmoji() {
		if(color == "White") {
			return "\u2654";
		}else {
			return "\u265A";
		}
	}

	public String toString() {
		if (color == "White") {
			return color + " King: \u2654  (K)";
		} else {
			return color + " King: \u265A  (K)";
		}

	}

}
