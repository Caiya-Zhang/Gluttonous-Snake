/*
 * SnakeLinked.java
 * 
 * Mar 22nd, 2020
 * Author: Caiya Zhang
 */


public class SnakeLinked {
	
	private int snakeLength;
	private DoubleList<Position> snakeBody;
	
	/**
	 * constructor
	 * @param row
	 * @param col
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		Position tempPosi = new Position(row, col);
		snakeBody.addData(0, tempPosi);
	}
	
	/**
	 * getter method
	 * return the length of the snake
	 */
	public int getLength() {
		return snakeLength;
	}
	
	/**
	 * @param i
	 * @return the position object stored in the node
	 * of the list with given index
	 */
	public Position getPosition(int i) {
		if (i<0 || i >= snakeLength) {
			return null;
		}
		return snakeBody.getNode(i).getData();
	}
	
	/**
	 * @param position
	 * @return true if position is in the list of snakeBody,
	 * and return false otherwise.
	 */
	public boolean snakePosition(Position position) {
		
		DoubleNode<Position> tempNode;
		tempNode = snakeBody.getNode(0);
		
		while(tempNode != null) {
			if(tempNode.getData().equals(position)) {
				return true;
			}
			tempNode = tempNode.getNext();
		}	
		return false;
	}
	
	 /**
	  * @param dire
	  * @return new position that the head of the snake 
	  * would occupy if the snake moved in the direction 
	  * specified by the parameter dire
	  */
	public Position newHeadPosition(String dire) {
		Position cur = new Position(snakeBody.getData(0).getRow(), snakeBody.getData(0).getCol());
		if (dire.equals("up")) {
			cur.setRow(cur.getRow()-1);
		}
		else if (dire.equals("down")) {
			cur.setRow(cur.getRow()+1);
		}
		else if (dire.equals("left")) {
			cur.setCol(cur.getCol()-1);
		}
		else if (dire.equals("right")) {
			cur.setCol(cur.getCol()+1);
		}
		return cur;
	}
	
	/**
	 * @param dire
	 * moves the snake in the specified direction
	 */
	public void moveSnakeLinked(String dire) {
		snakeBody.addData(0,  newHeadPosition(dire));
		snakeBody.removeData(snakeLength);
	}
	
	public void shrink() {
		snakeLength--;
		snakeBody.removeData(snakeLength);
	}
	
	public void grow(String dire) {
		snakeLength++;
		snakeBody.addData(0,  newHeadPosition(dire));
	}
	
	
	
}
