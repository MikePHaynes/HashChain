public class Node {
	private int id;
	private String name;
	private Node next;
	
	public Node(int id, String name, Node next) {
		this.id = id;
		this.name = name;
		this.next = next;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
}
