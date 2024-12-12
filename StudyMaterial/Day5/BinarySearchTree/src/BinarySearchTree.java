import java.util.Stack;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree() {
        root = null;
    }

    //Non-Recursive Approch
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

    public void inOrder() {
        System.out.println("Inorder: ");
        Stack<Node> stack = new Stack<>();
        Node temp = root;

        while(temp != null || !stack.isEmpty()) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }

            temp = stack.pop();
            System.out.print(temp.getData() + " ");
            temp = temp.getRight();
        }
        System.out.println();
    }

    public void postOrder() {
        class Pair {
            Node node;
            char flag;

            public Pair(Node node, char flag) {
                this.node = node;
                this.flag = flag;
            }
        }
        Stack<Pair> stack = new Stack<>();
        Node temp = root;

        System.out.println("Postorder:");

        while(temp != null || !stack.isEmpty()) {
            while(temp != null) {
                //temp may have a left child
                //before we shift temp to the left, push a pair of current temp and a flag on to the stack
                //the flag helps us find, what is the current status of that particualr node
                Pair pair = new Pair(temp, 'L');
                stack.push(pair);
                temp = temp.getLeft();
            }

            Pair pair = stack.pop();
            temp = pair.node;

            if(pair.flag == 'L') {
                pair.flag = 'R';
                stack.push(pair);
                temp = temp.getRight();
            }
            else {
                System.out.print(temp.getData() + " ");
                temp = null;
            }
        }
        System.out.println();

    }

    public void postOrder1() {
        class Pair {
            Node node;
            char flag;

            public Pair(Node node, char flag) {
                this.node = node;
                this.flag = flag;
            }
        }
        Stack<Pair> stack = new Stack<>();
        Node temp = root;

        System.out.println("Postorder:");

        while(temp != null || !stack.isEmpty()) {
            while(temp != null) {
                //temp may have a left child
                //before we shift temp to the left, push a pair of current temp and a flag on to the stack
                //the flag helps us find, what is the current status of that particualr node
                Pair pair = new Pair(temp, 'L');
                stack.push(pair);
                temp = temp.getLeft();
            }

            Pair pair = stack.pop();

            if(pair.flag == 'L') {
                pair.flag = 'R';
                stack.push(pair);
                temp = pair.node.getRight();
            }
            else {
                System.out.print(pair.node.getData() + " ");
            }
        }
        System.out.println();

    }

    //Resursiev Approch
    public void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    public void postOrder(Node root) {
        if(root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");

    }

    public int getCount(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + getCount(root.getLeft()) + getCount(root.getRight());
    }

    public boolean delete(int data) {
        if(root == null) {
            return false;
        }

        //locate the del node along with the parent node
        Node parent = root, del = root;
        while(del.getData() != data) {
            parent = del;
            if(data < del.getData()) {
                del = del.getLeft();
            }
            else {
                del = del.getRight();
            }
            if(del == null) {
                return false;
            }
        }

        while(true) {
            //check if the del node is a terminal node or not
            if (del.getLeft() == null && del.getRight() == null) {

                //check if the del node is root node
                if (del == root) {
                    root = null;
                    return true;
                }

                //check if the del is left or right child of the parent
                if (parent.getLeft() == del) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
                return true;
            }

            //del is a non terminal node
            if (del.getLeft() != null) {
                //find max from left subtree, also make sure that the parent is following max
                Node max = del.getLeft();
                parent = del;
                while (max.getRight() != null) {
                    parent = max;
                    max = max.getRight();
                }

                //Swap the del and max's data
                int temp = del.getData();
                del.setData(max.getData());
                max.setData(temp);

                //max is the node to be deleted
                del = max;
            }
            else {
                //find min from right subtree, also make sure that the parent is following min
                Node min = del.getRight();
                parent = del;

                while(min.getLeft() != null) {
                    parent = min;
                    min = min.getLeft();
                }

                //swap min with del
                int temp = del.getData();
                del.setData(min.getData());
                min.setData(temp);

                del = min;
            }
        }
    }
}
