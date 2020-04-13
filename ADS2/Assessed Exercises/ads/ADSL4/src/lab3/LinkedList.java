package lab3;

public class LinkedList<Item>{
	private Node<Item> head;
	private static class Node<Item>{
		private Item key;
		private Node<Item> next;
	}
	public LinkedList(){
		head = null;
	}
	public void Insert(LinkedList<Item> L, Node<Item> x){
		x.next = L.head;
		L.head = x;
	}
	public LinkedList<Item> merge(LinkedList<Item> a, LinkedList<Item> b) {
		if(a == null) {
			return b;
		}
		else if(b == null) {
			return a;
		}
		LinkedList<Item> x = null;
		if(a.key <= b.key) {
			x = a;
			x.next = merge(a.next, b)
		}
		else{
			x = b;
			x.next = merge(b.next, a)
		}
		return a;
	}
}