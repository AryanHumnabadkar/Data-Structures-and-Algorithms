public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.preOrder();

        bst.insert(50);
        bst.insert(20);
        bst.insert(90);
        bst.insert(10);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);

        bst.insert(80);
        bst.insert(60);
        bst.insert(85);
        bst.insert(100);


        bst.preOrder();
    }
}
