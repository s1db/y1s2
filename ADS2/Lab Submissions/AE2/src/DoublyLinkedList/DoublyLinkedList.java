package DoublyLinkedList;

public class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	public DoublyLinkedList() {
		this.size = 0;
	}

	public boolean add(int d) {
		
		if(!hasElement(d)||head == null) {
			Node new_Node = new Node(d); 
	        new_Node.next = head; 
	        new_Node.prev = null; 
	        if (head != null) 
	            head.prev = new_Node;
	        if(tail == null)
	        	tail = new_Node;
	        head = new_Node;
	        size++;
	        return true;
		}
		return false;
	}
	
	public boolean deleteElement(int d) {
		Node iterator = this.head;
//		System.out.println(iterator.data);
        while (iterator != null) { 
            if(iterator.data == d) {
            	deleteNode(iterator);
            	this.size--;
            	return true;
            }
            iterator = iterator.next; 
        } 
		return false;
	}
	public Node deleteNode(Node del) { 
        // base case 
        if (this.head == null || del == null) 
            return null; 
  
        // If node to be deleted is head node 
        if (this.head == del) 
            head = del.next; 
  
        // Change next only if node to be  
        // deleted is NOT the last node 
        if (del.next != null) 
            del.next.prev = del.prev; 
  
        // Change prev only if node to be  
        // deleted is NOT the first node 
        if (del.prev != null) 
            del.prev.next = del.next; 
  
        del = null; 
  
        return head; 
    } 

	public boolean hasElement(int d) {
		Node iterator = this.head;
		while (iterator != null) {
			if (iterator.getData() == d)
				return true;
			iterator = iterator.getNext();
		}
		return false;
	}
	
	public void printInorder() {
		Node iterator = head;
		while (iterator != null) {
			System.out.print(iterator.data+" ");
			iterator = iterator.getNext();
		}
	}

	public boolean isEmpty() {
		if (this.size == 0)
			return true;
		else
			return false;
	}

	public int getSize() {
		return this.size;
	}

	public DoublyLinkedList unionOfLists(DoublyLinkedList list1, DoublyLinkedList list2) {
		Node headOfList1 = list1.head;
		Node headOfList2 = list2.head;
		DoublyLinkedList listResult = new DoublyLinkedList();
		while (headOfList1 != null) {
			listResult.add(headOfList1.getData());
			headOfList1 = headOfList1.getNext();
		}
		while (headOfList2 != null) {
			int temp = headOfList2.getData();
			listResult.add(temp);
			headOfList2 = headOfList2.getNext();
		}

		return listResult;

	}

	public DoublyLinkedList intersectionOfLists(DoublyLinkedList list1, DoublyLinkedList list2) {
		Node headOfList1 = list1.head;
		Node headOfList2 = list2.head;
		DoublyLinkedList listResult = new DoublyLinkedList();
		while (headOfList1 != null) {
			while(headOfList2 != null) {
				if (headOfList1.getData() == headOfList2.getData()) 
					listResult.add(headOfList2.getData());
				headOfList2 = headOfList2.getNext();
			}
			headOfList1 = headOfList1.getNext();
		}
		return listResult;

	}
	public boolean isSubset(DoublyLinkedList list1) {
		Node headOfList2 = this.head;
		while (headOfList2 != null) {
			if(!list1.hasElement(headOfList2.getData())) return false;
			headOfList2 = headOfList2.getNext();
		}
		return true;
	}

	public DoublyLinkedList differenceOfLists(DoublyLinkedList list1, DoublyLinkedList list2) {
		Node headOfList1 = list1.head;
		Node headOfList2 = list2.head;
		DoublyLinkedList listResult = new DoublyLinkedList();
		listResult.printInorder();
		while (headOfList1 != null) {
			int temp1 = headOfList1.getData();
			if (!list2.hasElement(temp1)) 
				listResult.add(temp1);			
			headOfList1 = headOfList1.getNext();
		}
		while(headOfList2 != null) {
			int temp2 = headOfList2.getData();
			if (!list1.hasElement(temp2)) 
				listResult.add(temp2);
			headOfList2 = headOfList2.getNext();
		}

		return listResult;

	}

}
