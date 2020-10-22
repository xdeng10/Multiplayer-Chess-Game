package chessGame;

public interface Piece {
	public boolean legalMove(int newRow, int newCol, Board chessBoard); 
	public String getEmoji();
	public void setRow(int row);
	public void setCol(int col);
	public int getRow();
	public int getCol();
	public String getColor();
}
