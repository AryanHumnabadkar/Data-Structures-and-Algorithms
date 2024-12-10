

class Node {
	
	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;

	}

	public void setData(int data) {
		 this.data = data;

	}
	public Node getNext() {
		return this.next;

	}
	public void setNext(Node next) {
		 this.next = next;

	}
	
}




public class LinkedListInsertion {

	private Node head;
	private int size;
	
	
	public LinkedListInsertion() {
		super();
		this.size = 0;
	}
	
	
	public boolean insertNode(int data, int pos) {
		
		Node newNode = new Node(data);
		
		if ( ( pos > size + 1) || pos <= 0) {
			System.out.println("Invalid Pos");
			return false;
		}
		
		// Valid POS = 1 to size + 1
		
		//POS = 1
		if ( pos == 1) {
			newNode.setNext(head);
			head = newNode;
			size ++;                  
			return true;
		}
		
		
		//pos = n
		Node temp = head;
		for ( int i = 1; i < pos - 1 ; i++) {
			temp = temp.getNext();
			if ( temp == null) {
				return false;
			}
		}
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		size ++;
		return true;
		
	}
	
	public void diaplay() {
		Node temp = head;
		while ( temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		LinkedListInsertion l1 = new LinkedListInsertion();
		
		l1.insertNode(10, -1);
		l1.diaplay();
		
		l1.insertNode(10, 0);
		l1.diaplay();
		
		l1.insertNode(10, 1);
		l1.diaplay();
		
		l1.insertNode(20, 2);
		l1.diaplay();
		
		l1.insertNode(30, 3);
		l1.diaplay();
		
		l1.insertNode(40, 5);
		l1.diaplay();
		
		l1.insertNode(40, 4);
		l1.diaplay();
		
		l1.insertNode(50, 5);
		l1.diaplay();

	}
}

