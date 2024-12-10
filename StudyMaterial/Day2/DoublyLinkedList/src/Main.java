public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insert(10);
        dll.display();
        dll.insert(20);
        dll.display();
        dll.insert(30);
        dll.display();
        dll.insert(40);
        dll.display();
        dll.insert(50);
        dll.display();

        dll.insert(60, 1);
        dll.display();
        dll.insert(70, 4);
        dll.display();
        dll.insert(80, 8);
        dll.display();
        dll.insert(90, 10);
        dll.display();

        dll.deleteByPosition(1);
        dll.display();
        dll.deleteByPosition(4);
        dll.display();
        dll.deleteByPosition(6);
        dll.display();
        dll.deleteByPosition(6);
        dll.display();

        /*dll.deleteByVal(60);
        dll.display();
        dll.deleteByVal(70);
        dll.display();
        dll.deleteByVal(80);
        dll.display();
        dll.deleteByVal(60);
        dll.display();*/



    }
}
