package cll.genericCll;

public class GenericCircularLinkedList {
}

class  Node<T> {

    private T data;
    private Node next;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
    }

}


class CLL<T> {

    private Node<T> head;

    public boolean insert(T data) {

        Node newNode = new Node(data);

        //Empty List
        if (newNode == null){
            return false;
        }

        //Non-Empty List
        Node<T> last = head;

        while (last.getNext()!= head) {
            last.setNext(newNode);

        }




        return true;

    }

}