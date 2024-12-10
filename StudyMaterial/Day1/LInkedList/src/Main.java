public class Main {
    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();

        l1.displayReverse();

        System.out.println(l1.count());
        l1.display();

        l1.insert(10);
        l1.display();
        l1.insert(20);
        l1.display();
        l1.insert(30);
        System.out.println(l1.count());
        l1.display();
        l1.insert(40);
        l1.display();
        l1.insert(50);
        l1.display();
        l1.insert(60);
        l1.display();
        System.out.println(l1.count());

        l1.insert(70, 1);
        l1.display();
        l1.insert(80, 4);
        l1.display();
        l1.insert(90, 9);
        l1.display();

        System.out.println(l1.insert(100, 12));

        l1.insert(70, 5);
        l1.display();
        l1.insert(70, 8);
        l1.display();

        /*l1.delete(1);
        l1.display();
        l1.delete(4);
        l1.display();
        l1.delete(7);
        l1.display();
        l1.delete(7);
        l1.display();*/

        /*l1.deleteByVal(70);
        l1.display();
        l1.deleteByVal(80);
        l1.display();
        l1.deleteByVal(90);
        l1.display();
        l1.deleteByVal(70);
        l1.display();*/

        while( l1.deleteByVal(70))
            ;
        l1.display();
        l1.displayReverse();
        l1.displayReverse(l1.getHead());

        System.out.println("--------------");
        l1.display();
        l1.reverse();
        l1.display();



    }
}
