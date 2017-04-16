
public class LinkedList {

	private Node head=null;
	
	

	public void print(){
		Node pos = head;
		if(pos==null){
			System.out.println("NO Nodes !!");
		}
		else{
			while(pos != null){
				System.out.println(pos.toString());
				pos=pos.getNext();
			}
		}
	}
	
	public int length(){
		Node pos = head;
		int count=0;
		while(pos != null){
			++count;
			pos=pos.getNext();
		}
		return count;
	}
	
	public boolean isEmpty(){
		if(head==null)
			return true;
		else
			return false;
	}
	
	public boolean add(Student value,int index){
		Node pos=head;
		Node newNode = new Node(value);
		
		if(index==0){
			newNode.setNext(head);
			head = newNode;
			
			return true;
		}
		else{
			
			if(index > this.length() || index < 0)
				return false;
			
			for(int count=0;count<index-1;++count){
				pos=pos.getNext();
			}
			newNode.setNext(pos.getNext());
			pos.setNext(newNode);
			
			return true;
		}
	}
	
	public void add(Student value){
//		Node pos=head;
//		Node newNode = new Node(value);
//		while(pos.getNext()!=null){
//			pos=pos.getNext();
//		}
//		newNode.setNext(pos.getNext());
//		pos.setNext(newNode);
//		return true;

        add(value,getSortedIndex(value,this));
		
	}
	
	public boolean remove(int index){
		if(index > this.length() || index <0 || this.isEmpty()){
			return false;
		}
		
		Node pos =head;
		
		if(index==0){
			head = head.getNext();
			return true;
		}
		else{
			for(int count=0;count<index-1;++count){
				pos=pos.getNext();
			}
			pos.setNext(pos.getNext().getNext());
			return true;
		}
		
	}
	
	public int find(Student s){
		Node pos=head;
		int count=0;
		
		while(pos.getNext() != null){
			if(pos.equals(s))
				return count;
			++count;
			pos=pos.getNext();
		}
		
		return -1;
	}

//	public Student get(int index){
//		Node pos=head;
//
//		while(pos.getNext() != null){
//			if(pos.getData().getId() == id)
//				return pos.getData();
//
//			pos=pos.getNext();
//		}
//
//		return null;
//	}

    public Student get(int index) {

	    if (index < length() && index >= 0){

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
	    }
        else
            return null;
    }

    private static int getSortedIndex (Student student, LinkedList list) {

        for (int i=0; i < list.length(); i++) {
            if (student.compareTo(list.get(i)) < 0) {
                return i;
            }
        }
        // name should be inserted at end.
        return list.length();
    }
	


}
