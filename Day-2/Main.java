
public class Main {

	public static void main(String[] args) {
		//LinkedListInsertion l1 = new LinkedListInsertion();
		
		LinkedListDel l1 = new LinkedListDel();
//		l1.insertNode(10, -1);
//		l1.diaplay();
		
//		l1.insertNode(10, 0);
//		l1.diaplay();
		
		l1.insertNode(10, 1);
		l1.diaplay();
		
		l1.insertNode(20, 2);
		l1.diaplay();
		
		l1.insertNode(30, 3);
		l1.diaplay();
		
//		l1.insertNode(40, 5);
//		l1.diaplay();
		
		l1.insertNode(40, 4);
		l1.diaplay();
		
		
		l1.insertNode(50, 5);
		l1.diaplay();
		
		l1.delete(1);
		l1.diaplay();
		
		l1.insertNode(10, 1);
		l1.diaplay();
		
		l1.delete(3);
		l1.diaplay();
		
		l1.insertNode(60, 3);
		l1.diaplay();
		
		l1.delete(4);
		l1.diaplay();
		
		l1.deleteByVal(60);
		l1.diaplay();
	}

}
