public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        System.out.println("Ins: " + q.insert(10));
        System.out.println("Ins: " + q.insert(20));
        System.out.println("Ins: " + q.insert(30));
        System.out.println("Del: " + q.delete());
        System.out.println("Del: " + q.delete());
        System.out.println("Del: " + q.delete());
        System.out.println("Del: " + q.delete());

        System.out.println("is empty: " + q.isEmpty()  + " is full: " + q.isFull());

        System.out.println("Ins: " + q.insert(40));
        System.out.println("Ins: " + q.insert(50));
        System.out.println("Ins: " + q.insert(60));
        System.out.println("Del: " + q.delete());
        System.out.println("Del: " + q.delete());
        System.out.println("Del: " + q.delete());

        System.out.println("is empty: " + q.isEmpty()  + " is full: " + q.isFull());

    }
}
