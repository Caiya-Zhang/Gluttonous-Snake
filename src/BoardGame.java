/*
 * BoardGame.java
 * 
 * Feb 26th, 2020
 * Author: Caiya Zhang
 */

public class BoardGame {
	
	//define the variables
	private int board_length;  //the number of columns of the grid 
	private int board_width;  //the number of rows of the grid
	private Snake theSnake;  //the object of the class Snake representing the snake
	
	/**
	 * define a 2-dimensional matrix, 
	 * storing the content of each one of the squares of the grid.
	 */
	private String[][] matrix;
	
	/**
	 * constructor of this class
	 * @param boardFile contains the dimension of game board,
	 * including snake position and objects
	 */
	public BoardGame(String boardFile) {
		
		//open the file with the class MyFileReader
		MyFileReader readFile = new MyFileReader(boardFile);
		readFile.readInt();
		readFile.readInt();
		
		/**
		 * store the integer read from the file,
		 * in board_length and the board_width
		 */
		board_length = readFile.readInt();
		board_width = readFile.readInt();
		
		matrix = new String[board_width][board_length];
		theSnake = new Snake(readFile.readInt(), readFile.readInt());
		
		/**
		 * rows and columns indexed start from 0,
		 * and entries initialize from "empty"
		 */
		for (int i=0; i<board_width; i++) {
			for (int j=0; j<board_length; j++) {
				matrix[i][j] = "empty";
			}	
		}
		
		//define two variables
		int num1 = readFile.readInt();
		int num2;
		
		//store the two variables in the matrix
		while(num1 != -1) {
			num2 = readFile.readInt();
			matrix[num1][num2] = readFile.readString();
			num1 = readFile.readInt();
		}		
	}
	
	/**
	 * getter method
	 * @param row
	 * @param col
	 * @return the string in matrix
	 */
	public String getObject(int row, int col) {
		return matrix[row][col];
	}
	
	/**
	 * getter method
	 * @return board_length
	 */
	public int getLength() {
		return board_length;
	}
	
	/**
	 * getter method
	 * @return board_width
	 */
	public int getWidth() {
		return board_width;
	}
	
	/**
	 * getter method
	 * @return theSnake
	 */
	public Snake getSnake() {
		return theSnake;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public String getType(int row, int col) {
		return matrix[row][col];
	}
	
	/**
	 * setter method
	 * @param newSnake
	 * store the value of newSnake in theSnake
	 */
	public void setSnake(Snake newSnake) {
		theSnake = newSnake;
	}
	
	/**
	 * setter method
	 * @param row
	 * @param col
	 * @param newObject stores newObject in the matrix
	 */
	public void setObject(int row, int col, String newObject) {
		matrix[row][col] = newObject; 
	}
	
}
