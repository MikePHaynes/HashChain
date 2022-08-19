public class LinkedList {
	private Node head;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Node head() {
		return head;
	}
	
	public void add(Node n) {
		if(size == 0) head = n;
		else {
			Node cur = head;
			while(cur.getNext() != null) cur = cur.getNext();				
			cur.setNext(n);			
		}
		size++;
	}
	
	public void remove(Node n) {
		if(size == 0) return;
		if(size == 1) head = null;					
		else if(head == n) head = head.getNext();								
		else {
		Node cur, prev = null;
		for(cur = head; cur != n; cur = cur.getNext()) prev = cur;					
		prev.setNext(cur.getNext());		
		}
		size--;
	}
}
