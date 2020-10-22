package chessGame;

public class Knight implements Piece{
	private String color;
	private int row;
	private int col;
	
	Knight(String color, int row, int col){
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
	
	/*
	 * Knight can move two squares vertically and one square horizontally OR
	 * move two squares horizontally and one square vertically.
	 */
	
	public boolean legalMove(int newRow, int newCol, Board chessBoard) {
		if (newRow == this.row && newCol == this.col) {
			return false;
		}else if(Math.abs(newRow-this.row)==2 && Math.abs(newCol-this.col)==1 && 
				(chessBoard.getPiece(newRow, newCol) == null || chessBoard.getPiece(newRow, newCol).getColor() != this.color)) {
			return true;
		}else if(Math.abs(newRow-this.row)==1 && Math.abs(newCol-this.col)==2 && 
				(chessBoard.getPiece(newRow, newCol) == null || chessBoard.getPiece(newRow, newCol).getColor() != this.color)) {
			return true;
		}
		return false;
	}
	
	
	public String getEmoji() {
		if(color == "White") {
			return "\u2658";
		}else {
			return "\u265E";
		}
	}
	
	
	public String toString(){
		if(color == "White") {
			return color + " Knight: \u2658  (N)";
		}else {
			return color + " Knight: \u265E  (N)";
		}	
	}
}
