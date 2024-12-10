import java.util.Stack;

public class LinkedList {
    private Node head;
    int size;

    public Node getHead() {
        return head;
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (newNode == null) {
            return false;
        }

        //check if the list is empty
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        //locate the last node
        Node last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        //link the new node to the last node
        last.setNext(newNode);
        size++;
        return true;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public int betterCount() {
        return size;
    }

    public int count() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public boolean insert(int data, int position) {

        if (position <= 0 || (position > 1 && head == null)) {
            return false;
        }

        //****
        //validate the position

        Node newNode = new Node(data);
        if (newNode == null) {
            return false;
        }

        if (position == 1) {
            if (head != null) {
                newNode.setNext(head);
            }
            head = newNode;
            size++;
            return true;
        }

        Node prev = head;
        for (int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if (prev == null) {
                return false;
            }
        }

        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        size++;
        return true;
    }

    public boolean delete(int position) {
        if (head == null) {
            return false;
        }

        /*if(position <= 0 || position > size) {
            return false;
        }*/

        if (position == 1) {
            head = head.getNext();
            size--;
            return true;
        }

        //locate the prev node
        /*Node prev = head;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev == null) {
                return false;
            }
        }

        //check if size + 1 position is available or not
        if(prev.getNext() == null) {
            return false;
        }*/

        //a2
        Node prev = head;
        for (int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if (prev.getNext() == null) {
                return false;
            }
        }

        //make prev next refer to the next of prev next
        /*Node del = prev.getNext();
        prev.setNext(del.getNext());*/

        prev.setNext(prev.getNext().getNext());
        size--;
        return true;
    }

    public boolean deleteByVal(int data) {
        if (head == null) {
            return false;
        }

        if (head.getData() == data) {
            head = head.getNext();
            size--;
            return true;
        }

        //locate the del node along with prev
        Node prev = head;
        Node del = head;

        while (del.getData() != data) {
            prev = del;
            del = del.getNext();
            if (del == null) {
                return false;
            }
        }

        prev.setNext(del.getNext());
        size--;
        return true;
    }

    public void displayReverse() {

        Stack<Node> stack = new Stack<>();
        Node temp = head;

        while(temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }

        while(!stack.empty()) {
            System.out.print(stack.pop().getData() + " ");
        }
        System.out.println();

        /*Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while(temp != null) {
            stack.push(temp.getData());
            temp = temp.getNext();
        }

        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();*/
    }

    public void displayReverse(Node head) {
        if(head == null) {
            System.out.println();
            return;
        }
        displayReverse(head.getNext());
        System.out.print(head.getData() + " ");
    }

    public void reverse() {
        if(head == null || head.getNext() == null) {
            return;
        }

        Node n1 = head;
        Node n2 = head.getNext();
        Node n3 = null;

        while(n2 != null) {
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2= n3;
        }

        head.setNext(null);
        head = n1;  
    }
}







