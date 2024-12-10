public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(newNode == null) {
            return false;
        }

        if(head == null) {
            head = newNode;
            return true;
        }

        Node last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }

        last.setNext(newNode);
        newNode.setPrev(last);

        return true;
    }

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public boolean insert(int data, int position) {
        if(position <= 0 || (head == null && position > 1)) {
            return false;
        }

        Node newNode = new Node(data);
        if(newNode == null) {
            return false;
        }

        if(position == 1) {
            if(head != null) {
                newNode.setNext(head);
                head.setPrev(newNode);
            }
            head = newNode;
            return true;
        }

        //locate the prev and next node
        Node prev = head;
        Node next = null;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev == null) {
                return false;
            }
        }
        next = prev.getNext();

        //manage the links
        newNode.setPrev(prev);
        prev.setNext(newNode);
        if(next != null) {
            newNode.setNext(next);
            next.setPrev(newNode);
        }

        return true;
    }

    public boolean deleteByVal(int data) {
        if(head == null) {
            return false;
        }

        if(head.getData() == data) {
            if(head.getNext() == null) {
                head = null;
                return true;
            }

            head = head.getNext();
            head.setPrev(null);

            return true;
        }

        //locate del node
        Node del = head;
        while(del.getData() != data) {
            del = del.getNext();
            if(del == null) {
                return false;
            }
        }

        //set up prev and next
        Node prev = del.getPrev();
        Node next = del.getNext();

        //Manage the links
        prev.setNext(next);
        if(next != null) {
            next.setPrev(prev);
        }
        return true;
    }

    public boolean deleteByPosition(int position) {
        if(head == null) {
            return false;
        }

        if(position == 1) {
            if(head.getNext() == null) {
                head = null;
                return true;
            }

            head = head.getNext();
            head.setPrev(null);

            return true;
        }

        //locate del node
        Node del = head;
        for(int i = 1; i < position; i++) {
            del = del.getNext();
            if(del == null) {
                return false;
            }
        }

        //set up prev and next
        Node prev = del.getPrev();
        Node next = del.getNext();

        //Manage the links
        prev.setNext(next);
        if(next != null) {
            next.setPrev(prev);
        }
        return true;
    }
}




