public class DoubleStack {
    private int [] arr;
    private int size;
    private int top1, top2;

    public DoubleStack(int size) {
        this.size = size;
        top1 = -1;
        top2 = size;
        arr = new int[size];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == size;
    }

    public boolean isFull() {
        return (top1 +1) == top2;
    }

    public boolean push1(int data) {
        if(isFull()) {
            return false;
        }

        arr[++top1] = data;
        return true;
    }

    public int pop1() {
        if(isEmpty1()) {
            return -999;
        }
        return arr[top1--];
    }

    public boolean push2(int data) {
        if(isFull()) {
            return false;
        }
        arr[--top2] = data;
        return true;
    }

    public int pop2() {
        if(isEmpty2()) {
            return -999;
        }
        return arr[top2++];
    }
}
