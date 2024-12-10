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

    @Override
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
       for ( int i = 1; i < pos; i++){
           prev = prev.getNext();
           System.out.println(i+" position");
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
            //curr.getNext()!= head => This condition will not print last node when list has total 2 Nodes.
        }while (curr!=head);
        System.out.println();
    }
}

class Main {

    public static void main(String[] args) {

        CircularLinkedList l1 = new CircularLinkedList();

        l1.display();

        l1.insert(10);
        l1.display();

        l1.insert(20);
        l1.display();

        l1.insert(30);
        l1.display();

        l1.insert(40);
        l1.display();

        l1.insert(50);
        l1.display();


    }


}
