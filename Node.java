package assignment2;
/*
Matriculation Number -  Name
 761318      : Bishal Karki
 */

public class Node {

	private Song data;
	private Node previous = null, next = null;

	public Node(Song song) {
		this.data = song;
		//this.next = null;
		//this.previous = null;
	}

	public Song getData() {
		return data;
	}

	public void setData(Song data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node node) {
		this.next = node;
	}
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node node) {
		this.previous = node;
	}



	}
