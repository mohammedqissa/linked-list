
public class Node {
	
	private Student data;
	private Node next;
	
	public Node(Student data) {
	
		this.data = data;
		
	}

	public Student getData() {
		return data;
	}

	public void setData(Student data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString(){
		return this.data.toString();
	}
	
	
	public boolean equals(Object s){
		if(this.data.getId() == ((Student)s).getId() )
			return true;
		return false;
	}
	

}
