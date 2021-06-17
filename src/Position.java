/*
 * Position.java
 * 
 * Feb 27th, 2020
 * Author: Caiya Zhang
 */

public class Position {

	//define two variables
	private int rw;
	private int cl;
	
	/**
	 * constructor for the class;
	 * @param row stored in rw;
	 * @param col stored in cl;
	 */
	public Position(int row, int col) {
		rw = row;
		cl = col;
	}
	
	/**
	 * getter method
	 * @return the value of rw
	 */
	public int getRow() {
		return rw;
	}
	
	/**
	 * getter method
	 * @return the value of cl
	 */
	public int getCol() {
		return cl;
	}
	
	/**
	 * setter method
	 * @param newRow stores the value of newRow in rw 
	 */
	public void setRow(int newRow) {
		rw = newRow;
	}
	
	/**
	 * setter method
	 * @param newCol stores the value of newCol in cl 
	 */
	public void setCol(int newCol) {
		cl = newCol;
	}
	
	/**
	 * 
	 * @param otherPosition
	 * @return true if this Position object and otherPosition 
	 *         have the same values stored in positionRow and positionColumn.
	 */
	public boolean equals(Position otherPosition) {
		if (rw == otherPosition.getRow()) {
			if (cl == otherPosition.getCol()) {
				return true;
			}
		}
		return false;
	}
	
	
	
}





