/*
 * DoubleList.java
 * 
 * Mar 22nd, 2020
 * Author: Caiya Zhang
 */


//import InvalidPositionException;

public class DoubleList<T> {
	
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;
	
	/**
	 * constructor, create an empty list
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}
	
	/**
	 * store newData in a new node,
	 * and insert this node in the index position of the list 
	 * @param i
	 * @param newData
	 * @throws InvalidPositionException
	 */
	public void addData(int i, T newData) throws InvalidPositionException{
		
		if (i<0 || i>numDataItems) {
			throw new InvalidPositionException("invalid position");
		}
		
		//try to store the node at the head of the list
		DoubleNode<T> newNode = new DoubleNode<T> (newData);
		if (i == 0) {
			//if the list is empty
			if(numDataItems == 0) {
				head = newNode;
				rear = newNode;
				numDataItems++;
				return;
			}
			//if the list is not empty
			else {
				head.setPrev(newNode);
				newNode.setNext(head);
				head = newNode;
				numDataItems++;
				return;
			}
		}
		int num = 0;
		//lastNode is to store the previous node of the temporary one 
		DoubleNode<T> tempNode = head;
		DoubleNode<T> lastNode = null;
		while(i != num) {
			tempNode = tempNode.getNext();
			num++;
			if(num != numDataItems) {
				lastNode = tempNode.getPrev();	
			}
			else {
				lastNode = rear;
			}
		}
		//try to store at the rear
		if(tempNode == null) {
			newNode.setPrev(lastNode);
			lastNode.setNext(newNode);
			rear = newNode;
			numDataItems++;
			return;
		}
		//try to store in intermediate nodes
		newNode.setPrev(lastNode);
		lastNode.setNext(newNode);
		tempNode.setPrev(newNode);
		newNode.setNext(tempNode);
		numDataItems++;
	}
	
	/**
	 * @param i
	 * @return index, the position of the stored node
	 * @throws InvalidPositionException
	 */
	public DoubleNode<T> getNode(int i) throws InvalidPositionException {
	
		if (i<0 || i >= numDataItems) {
			throw new InvalidPositionException("invalid position");
		}
		
		DoubleNode<T> tempNode = head;
		int num = 0;
		while (num != i) {
			tempNode = tempNode.getNext();
			num++;
		}
		return tempNode;
	}
	
	/**
	 * remove the node at index position 
	 * @param i
	 * @throws InvalidPositionException
	 */
	public void removeData(int i) throws InvalidPositionException {
		
		if (i<0 || i>=numDataItems) {
			throw new InvalidPositionException("invalid position");
		}
		
		DoubleNode<T> aimNode = getNode(i);
		//if remove the head
		if (i == 0) {
			//if there is only one node in the list
			if (numDataItems == 1) {
				head = null;
				rear = null;
				return;
			}
			//if there are more than one node in the list
			if (numDataItems > 1) {
				head.setPrev(null);
				head = aimNode.getNext();
				numDataItems--;
				return;
			}
		}
		//if remove the rear
		else if (i == numDataItems-1) {
			rear = aimNode.getPrev();
			rear.setNext(null);
			numDataItems--;
			return;
		}
		//if remove the intermediate nodes
		else {
			aimNode.getPrev().setNext(aimNode.getNext());
			aimNode.getNext().setPrev(aimNode.getPrev());
			numDataItems--;
			return;
		}	
	}
	
	/**
	 * @param i
	 * @return data at index position of the list
	 * @throws InvalidPositionException
	 */
	public T getData(int i) throws InvalidPositionException{
		
		if (i<0 || i >= numDataItems) {
			throw new InvalidPositionException("invalid position");
		}
		
		//let aimNode be the node at index position
		DoubleNode aimNode = getNode(i);
		return (T) aimNode.getData();
		
	}
	
	/**
	 * change data stored at index position in the list
	 * @param i
	 * @param newData
	 * @throws InvalidPositionException
	 */
	public void setData(int i, T newData) throws InvalidPositionException{
		
		if (i<0 || i >= numDataItems) {
			throw new InvalidPositionException("invalid position");
		}
		
		//let aimNode be the node at index position
		DoubleNode aimNode = getNode(i);
		aimNode.setData(newData);
	}
		
	
	
	
}
