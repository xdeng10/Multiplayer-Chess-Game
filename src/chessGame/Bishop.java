package chessGame;

public class Bishop implements Piece{
	private String color;
	private int row;
	private int col;
	
	Bishop(String color, int row, int col){
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
	 * Bishop can only move diagonally
	 */
	
	public boolean legalMove(int newRow, int newCol, Board chessBoard) {
		if (newRow == this.row && newCol == this.col) {
			return false;
		} else if (chessBoard.getPiece(newRow, newCol) != null && chessBoard.getPiece(newRow, newCol).getColor() == this.color) {
			return false;
		} else if (Math.abs(newRow - this.row) == Math.abs(newCol - this.col)) {
			return diagonalValid(newRow, newCol, chessBoard);
		}

		return false;
	}

	/*
	 * Ensures that there are no pieces between the original position and the destination (diagonal direction)
	 */
	private boolean diagonalValid(int newRow, int newCol, Board chessBoard) {
		if (newRow < this.row && newCol < this.col) {
			for (int i = 1; i < Math.abs(newRow - this.row); i++) {
				if (chessBoard.getPiece(newRow + i, newCol + i) != null) {
					return false;
				}
			}
		} else if (newRow < this.row && newCol > this.col) {
			for (int i = 1; i < Math.abs(newRow - this.row); i++) {
				if (chessBoard.getPiece(newRow + i, newCol - i) != null) {
					return false;
				}
			}
		} else if (newRow > this.row && newCol > this.col) {
			for (int i = 1; i < Math.abs(newRow - this.row); i++) {
				if (chessBoard.getPiece(newRow - i, newCol - i) != null) {
					return false;
				}
			}
		} else if (newRow > this.row && newCol < this.col) {
			for (int i = 1; i < Math.abs(newRow - this.row); i++) {
				if (chessBoard.getPiece(newRow - i, newCol + i) != null) {
					return false;
				}
			}
		}
		return true;
	}

	
	
	public String getEmoji() {
		if(color == "White") {
			return "\u2657";
		}else {
			return "\u265D";
		}
	}
	
	
	public String toString(){
		if(color == "White") {
			return color + " Bishop: \u2657  (B)";
		}else {
			return color + " Bishop: \u265D  (B)";
		}
		
	}

}
