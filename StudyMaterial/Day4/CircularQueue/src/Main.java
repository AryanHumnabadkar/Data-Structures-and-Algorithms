public class Main {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        System.out.println("Ins: " + cq.insert(10));
        System.out.println("Ins: " + cq.insert(20));
        System.out.println("Ins: " + cq.insert(30));
        System.out.println("Ins: " + cq.insert(40));
        System.out.println("Ins: " + cq.insert(50));
        System.out.println("Ins: " + cq.insert(60));

        System.out.println("Del: " + cq.delete());
        System.out.println("Ins: " + cq.insert(60));

        System.out.println("Del: " + cq.delete());
        System.out.println("Ins: " + cq.insert(60));
    }
}
