/*
 * BoardGameLinked.java
 * 
 * Mar 23rd, 2020
 * Author: Caiya Zhang
 */


//import InvalidPositionException;

public class BoardGameLinked {
	
	private int boardLength;
	private int boardWidth;
	private SnakeLinked theSnake;
	DoubleList<String>[] board;
	
	/**
	 * constructor
	 * @param boardFile
	 */
	public BoardGameLinked(String boardFile) {
		
		MyFileReader readFile = new MyFileReader (boardFile);
		readFile.readInt();
		readFile.readInt();
		boardLength = readFile.readInt();
		boardWidth = readFile.readInt();
		theSnake = new SnakeLinked (readFile.readInt(), readFile.readInt());
		
		board = new DoubleList[boardWidth];
		
		for (int i = 0; i<boardWidth; i=i+1) {
			DoubleList<String> row = new DoubleList<String>();
			board[i] = row;
		}
		for (int i = 0; i<boardWidth; i=i+1) {
			for (int j = 0; j<boardLength; j=j+1) {
				board[i].addData(j, "empty");
			}
		}
		int num1 = readFile.readInt();
		int num2;
		while(num1 != -1) {
			num2 = readFile.readInt();
			board[num1].setData(num2,  readFile.readString());
			num1 = readFile.readInt();
		}
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return string stored in the node with index equals col 
	 * of the list referenced by board[row]
	 * @throws InvalidPositionException
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		
		if (row<0 || col<0 || row>=boardWidth || col>=boardLength) {
			throw new InvalidPositionException("invalid position");
		}
		
		return board[row].getData(col);
	}
	
	/**
	 * @param row
	 * @param col
	 * @param newObj
	 * @throws InvalidPositionException
	 */
	public void setObject(int row, int col, String newObj) throws InvalidPositionException {
		
		if (row<0 || col<0 || row>=boardWidth || col>=boardLength) {
			throw new InvalidPositionException("invalid position");
		}
		board[row].setData(col,  newObj);
	}

	/**
	 * @return theSnake
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}
	
	/**
	 * @param newSnake
	 * stores the value of newSnake in theSnake
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}
	
	public int getLength() {
		return boardLength;
	}
	
	public int getWidth() {
		return boardWidth;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
