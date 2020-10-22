package chessGame;

public class Queen implements Piece {
	private String color;
	private int row;
	private int col;

	Queen(String color, int row, int col) {
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
	 * Queen can be moved in a straight line vertically, horizontally, or diagonally.
	 */
	
	public boolean legalMove(int newRow, int newCol, Board chessBoard) {
		if (newRow == this.row && newCol == this.col) {
			return false;
		} else if (chessBoard.getPiece(newRow, newCol) != null && chessBoard.getPiece(newRow, newCol).getColor() == this.color) {
			return false;
		} else if (newRow == this.row) {
			return linearRowValid(newCol, chessBoard);
		} else if (newCol == this.col) {
			return linearColValid(newRow, chessBoard);
		} else if (Math.abs(newRow - this.row) == Math.abs(newCol - this.col)) {
			return diagonalValid(newRow, newCol, chessBoard);
		}
		return false;
	}
	
	/*
	 * Ensures that there are no pieces between the original position and the destination
	 * One method to verify rows
	 * One method to verify columns
	 * One method to verify diagonals
	 */

	private boolean linearRowValid(int newCol, Board chessBoard) {
		if (newCol < this.col) {
			for (int i = newCol + 1; i < this.col; i++) {
				if (chessBoard.getPiece(this.row, i) != null) {
					return false;
				}
			}
		} else if (newCol > this.col) {
			for (int i = newCol - 1; i > this.col; i--) {
				if (chessBoard.getPiece(this.row, i) != null) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean linearColValid(int newRow, Board chessBoard) {
		if (newRow < this.row) {
			for (int i = newRow + 1; i < this.row; i++) {
				if (chessBoard.getPiece(i, this.col) != null) {
					return false;
				}
			}
		} else if (newRow > this.row) {
			for (int i = newRow - 1; i > this.row; i--) {
				if (chessBoard.getPiece(i, this.col) != null) {
					return false;
				}
			}
		}
		return true;
	}

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
		if (color == "White") {
			return "\u2655";
		} else {
			return "\u265B";
		}
	}

	public String toString() {
		if (color == "White") {
			return color + " Queen: \u2655  (Q)";
		} else {
			return color + " Queen: \u265B  (Q)";
		}
	}
}