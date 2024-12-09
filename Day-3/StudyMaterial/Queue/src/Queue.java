public class Queue {
    private int[] arr;
    int front, rear;
    int size;

    public Queue(int size) {
        this.size = size;
        front = rear = -1;
        arr = new int[size];
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1) || (front > rear);
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean insert(int data) {
        if (isFull()) {
            return false;
        }

        arr[++rear] = data;
        if (front == -1) {
            front = 0;
        }

        //move the data to the front of the queue if the rear has reached the rearmost position
        if(front > 0 && rear == size-1) {
            int numElements = (rear - front + 1);
            for(int i = 0; i < numElements; i++) {
                arr[i] = arr[front++];
            }
            front = 0;
            rear = numElements - 1;
        }
        return true;
    }

    public int delete() {
        if (isEmpty()) {
            return -999;
        }
        return arr[front++];
    }
}

