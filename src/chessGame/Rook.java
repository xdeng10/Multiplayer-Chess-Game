package chessGame;

public class Rook implements Piece{
	private String color;
	private int row;
	private int col;
	
	Rook(String color, int row, int col){
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
		} else if (newRow == this.row) {
			return linearRowValid(newCol, chessBoard);
		} else if (newCol == this.col) {
			return linearColValid(newRow, chessBoard);
		} 
		return false;
	}
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

	
	public String getEmoji() {
		if(color == "White") {
			return "\u2656";
		}else {
			return "\u265C";
		}
	}
	
	
	public String toString(){
		if(color == "White") {
			return color + " Rook: \u2656  (R)";
		}else {
			return color + " Rook: \u265C  (R)";
		}
	}

	

}
