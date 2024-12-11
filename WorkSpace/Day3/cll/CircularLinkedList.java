package cll;

class Node{
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}

class CircularLinkedList {

    private Node head;

    public boolean insert(int data){

        Node newNode = new Node(data);
        Node last = head;

        if ( newNode == null){
            System.out.println("New Node Cannot Be Created !");
            return false;
        }

        //Case 1 : Empty List
        if ( head == null){
            head = newNode;
            newNode.setNext(head);
            return true;
        }

        //case 2 : Non-Empty List
        //Step 1 : Locate Last Node
        while(last.getNext()!= head){ //Here, do not compare with null otherwise infinite loop.
            last = last.getNext();
        }

        //Step 2 : Add new Node
        last.setNext(newNode);
        newNode.setNext(head);
        return true;
    }

    public boolean insert(int data , int pos){

        //Step 1 : Validate Pos
        if ( pos <=0 || (head == null && pos >1)){
            System.out.println("Invalid Position");
            return false;
        }

        //Step 2 : add Node
        Node newNode = new Node(data);

        //case 1 : empty list => add at pos 1
        if (head == null){
            head = newNode;
            newNode.setNext(head);
            return true;
        }

        //case 2 : Non-Empty List
        Node prev = head;
        Node last = head;

        //subcase 1 : POS = 1
        if ( pos == 1 ){
            while (last.getNext()!=head){
                last=last.getNext();
            }
            last.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
            return true;
        }
        //subcase 2 : POS ! = 1
        for ( int i = 1; i < pos -1 ; i++){ //CurrentNodePos = No. of Iteration + 1
            prev = prev.getNext();
            //System.out.println(i+" position");
            if(prev == head){
                System.out.println("Pos greater than current size");
                return false;
            }
        }
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        return true;

    }

    public void display(){
        Node curr = head;

        //case 1 : Empty List
        if ( head == null){
            System.out.println("Empty List");
            return;
        }

        //case 2 : Non-Empty List
        //if while loop used last Node will never get printed ( Looping Condition will get false)
        do{
            System.out.print(curr.getData()+" ");
            curr = curr.getNext();
            //curr.getNext()!= head => This condition in while will not print last node when list has total 2 Nodes.
        }while (curr!=head);
        System.out.println();
    }

    public boolean deleteByPos(int pos){
        //Step 1 : Validate POS & Empty List Condition
        if ( pos <= 0 ||  head == null ){
            System.out.println("Invalid Pos");
            return false;
        }

        //Step 2 : Delete Node
        //Case : POS = 1
        if ( pos == 1) {
            //subcase : Single Node List
            if (head.getNext()==head) {
                head = null;
                return false;
            }
            //subcase : Multi Node List
            Node last = head;
            while(last.getNext()!=head){
                last = last.getNext();
            }
            head = head.getNext();
            last.setNext(head);
            return true;
        }

        //Case : POS != 1
        Node prev = head;
        //1st Iteration => 2nd POS
        //Iteration + 1 => POS
        //To reach X position => i < X
        for ( int i = 1;i < pos - 1; i++){
            prev = prev.getNext();
            if ( prev == head){
                System.out.println("Pos Greater than Current Size");
                return false;
            }
        }
        prev.setNext(prev.getNext().getNext());
        return true;
    }

    public boolean deleteByVal(int val){

        //Step 1: Validate List
        if ( head == null){
            System.out.println("Invalid Delete Operation on Empty List");
            return false;
        }

        //Step 2 : Locate the required Node
        //Case: Val at head ( POS = 1)
        if (head.getData()==val) {
            //subcase : Single Node List
            if (head.getNext() == head){
                head = null;
                return true;
            }
            //subcase : Multi Node List
            Node last = head;
            while( last.getNext()!=head) {
                last = last.getNext();
            }
            head = head.getNext();
            last.setNext(head);
            return true;
        }
        //Case : Val Not at Head ( POS !=1 )
        //subcase : Single Node list ( Invalid Value )
        if ( head.getNext()==head){
            System.out.println("Invalid Value, Not Present in the list");
        }
        //subcase : Multi Node List
        Node curr = head;
        Node prev = head;
        while (curr.getData() != val){
            prev = curr;
            curr = curr.getNext();
            if (curr == head){
                System.out.println("Iteration Complete => Invalid Val");
                return false;
            }
        }
        prev.setNext(curr.getNext());
        return true;
    }

}

class Main {

    public static void main(String[] args) {

        CircularLinkedList l1 = new CircularLinkedList();

        System.out.println("----Display Empty List----");
        l1.display();
        System.out.println("----Adding Nodes----");
        l1.insert(10);
        l1.insert(20);
        l1.insert(30);
        l1.insert(40);
        l1.insert(50);
        l1.display();
        System.out.println("----Node Addition at POS = 1----");
        l1.insert(80,1);
        l1.display();
        System.out.println("----Node Addition at POS = 5----");
        l1.insert(70,5);
        l1.display();
        System.out.println("----Node Addition at invalid POS----");
        l1.insert(100,100);
        l1.display();
        System.out.println("----Node Deletion at POS = 1----");
        l1.deleteByPos(1);
        l1.display();
        System.out.println("----Node Deletion at POS = 5----");
        l1.deleteByPos(5);
        l1.display();
        System.out.println("----Node Deletion at POS = 40----");
        l1.deleteByPos(40);
        l1.display();
        l1.insert(10);
        System.out.println("----Node Deletion by Valid Value----");
        l1.deleteByVal(10);
        l1.display();
        System.out.println("----Node Deletion by In-valid Value----");
        l1.deleteByVal(900);
        l1.display();
    }
}
