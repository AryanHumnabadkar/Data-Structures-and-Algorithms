import java.util.Stack;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(newNode == null) {
            return false;
        }

        if(root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;

        while(true) {
            if (data == temp.getData()) {
                return false;
            }
            if (data < temp.getData()) {
                if (temp.getLeft() == null) {
                    //insert newNode to the left
                    temp.setLeft(newNode);
                    return true;
                }
                //temp already has a left child, so shift the temp to it's left
                temp = temp.getLeft();
            } else {
                if(temp.getRight() == null) {
                    //insert newNode to the right
                    temp.setRight(newNode);
                    return true;
                }
                temp = temp.getRight();
            }
        }

    }

    public void preOrder() {
        System.out.println("PreOrder");
        Node temp = root;

        Stack<Node> stack = new Stack<>();

        while(temp != null || !stack.isEmpty()) {
            while(temp != null) {
                System.out.print(temp.getData() + " ");
                stack.push(temp);
                temp = temp.getLeft();
            }

            temp = stack.pop();
            temp = temp.getRight();
        }
        System.out.println();
    }
}
