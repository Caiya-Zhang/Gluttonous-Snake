/*
 * Snake.java
 * 
 * Feb 28th, 2020
 * Author: Caiya Zhang
 */

public class Snake {
	
	//define the length of snake
	private int snakeLength;
	//define the square that store the snake length
	private Position[] snakeBody;
	
	/**
	 * constructor for the class
	 * @param row
	 * @param col
	 */
	public Snake(int row, int col) {
		snakeBody = new Position[5];
		snakeLength = 1;
		Position headPos = new Position(row, col);
		snakeBody[0] = headPos;
	}
	
	/**
	 * getter method
	 * @return the value of snakeLength
	 */
	public int getLength() {
		return snakeLength;
	}
	
	/**
	 *  
	 * @param idx
	 * @return the Position object stored in snakeBody[index],
	 *  and return null if index < 0 or index >= snakeLength.
	 */
	public Position getPosition(int idx) {
		if (idx<0 || idx >= snakeLength) {
			return null;
		}
		return snakeBody[idx];
	}
	
	/**
	 * decrease the value of snakeLength by 1
	 */
	public void shrink() {
		snakeLength -= 1;
	}
	
	/**
	 * 
	 * @param pos
	 * @return true if pos is in array snakeBody, and it returns false otherwise
	 */
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < snakeLength; i ++) {
			if (snakeBody[i].equals(pos)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param direction
	 * @return the new position of the head of the snake when it moves in specified direction
	 */
	public Position newHeadPosition(String direction) {
		Position c = new Position(snakeBody[0].getRow(),snakeBody[0].getCol());
		
		if (direction.equals("right")) {
			c.setCol(c.getCol()+1);
		}
		else if (direction.equals("left")) {
			c.setCol(c.getCol()-1);
		}
		else if (direction.equals("up")) {
			c.setRow(c.getRow()-1);
		}
		else if (direction.equals("down")) {
			c.setRow(c.getRow()+1);
		}
		return c;
	}
	
	/**
	 * move the snake in specified direction
	 * @param direction
	 */
	public void moveSnake(String direction) {
		Position lst = snakeBody[0];
		Position newpos;
		for (int i = 1; i<snakeLength;i++) {
			newpos = snakeBody[i];
			snakeBody[i] = lst;
			lst = newpos;
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	
	/**
	 * double the size of snakeBody array
	 */
	private void increaseArraySize() {
		Position[] newarr = new Position [snakeBody.length*2];
		for (int i = 0; i < snakeBody.length;i++) {
			newarr[i] = snakeBody[i];
		}
		snakeBody = newarr;
	}
	
	/**
	 * increase the snake length by 1,
	 * and move the snake head in specified direction
	 * @param direction
	 */
	public void grow(String direction) {
		snakeLength += 1;
		if (snakeLength == snakeBody.length) {
			increaseArraySize();
		}
		Position lst = snakeBody[0];
		Position newpos;
		for (int i = 1; i<snakeLength; i++) {
			newpos = snakeBody[i];
			snakeBody[i] = lst;
			lst = newpos;
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	
	
	
}










