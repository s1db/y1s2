package lab3;

public class Node {
	private String element;
	private Node next;
	public Node(String s, Node n) {
		this.element = s;
		this.next = n;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
