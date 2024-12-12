public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Count: " + bst.getCount(bst.getRoot()));
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
        System.out.println("Preorder: ");
        bst.preOrder(bst.getRoot());
        System.out.println();

        bst.inOrder();
        System.out.println("Inorder");
        bst.inOrder(bst.getRoot());
        System.out.println();

        bst.postOrder();
        bst.postOrder1();
        System.out.println("Postorder:");
        bst.postOrder(bst.getRoot());
        System.out.println();

        System.out.println("Count: " + bst.getCount(bst.getRoot()));

        System.out.println("del: " + bst.delete(50));
        System.out.println("del: " + bst.delete(50));
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();
    }
}
