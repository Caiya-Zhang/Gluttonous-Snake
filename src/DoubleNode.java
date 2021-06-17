/*
 * DoubleNode.java
 * 
 * Mar 22nd, 2020
 * Author: Caiya Zhang
 */


public class DoubleNode<T> {
	
	private DoubleNode<T> prev;
	private DoubleNode<T> next;
	private T data;
	
	/**
	 * constructor, create an empty node
	 */
	public DoubleNode() {
		prev = null;
		next = null;
		data = null;
	}
	
	/**
	 * constructor, create a node storing the given data
	 * @param newData
	 */
	public DoubleNode(T newData) {
		prev = null;
		next = null;
		data = newData;
	}

	/**
	 * getter method, return the value of prev
	 */
	public DoubleNode<T> getPrev() {
		return prev;
	}
	
	/**
	 * getter method, return the value of next
	 */
	public DoubleNode<T> getNext() {
		return next;
	}
	
	/**
	 * getter method, return the value of data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * setter method, store prevNode in prev
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}
	
	/**
	 * setter method, store nextNode in next
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}
	
	/**
	 * setter method, store newData in data
	 */
	public void setData(T newData) {
		data = newData;
	}
	
	
	
	
	
	
	
	
}
