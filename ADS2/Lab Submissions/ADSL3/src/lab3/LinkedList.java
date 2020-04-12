package lab3;

public class LinkedList {
	protected Node head;
	protected long size;
	public LinkedList(Node head, long size) {
		this.head = null;
		this.size = 0;
	}
	public boolean addNode(Node n){
		if(this.head == null) {
			this.head = n;
		}
		else {
			this.head.setNext(n);
			this.head = n;
		}
		this.size++;
		return true;
	}
	
	public boolean deleteNode(){
		if(head == null) {
			return false;
		}
		else{
			Node t = head;
			head = head.getNext();
			t.setNext(null);
			this.size--;
			return true;
		}
	}	
}
