package stack;

import java.util.Arrays;

public class StackUsingArrays<T> {
    private T[] arr;
    private int size;
    private int top ;

    public StackUsingArrays(int size) {
        this.size = size;
        this.top = -1;
        this.arr = (T[]) new Object[size];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == (size -1);
    }

    public boolean push(T data){
        if (isFull()){
            System.out.println("Invalid Operation.. Stack is Full ");
            return false;
        }
        ++top;
        arr[top]=data;
        return true;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Invalid Operation !! Stack is Empty");
            return null;
        }
        top--;
        return arr[top];
    }

    public T peek(){
        if (isEmpty()){
            System.out.println("Invalid Operation !! Stack is Empty");
            return null;
        }
        return arr[top];
    }

    public T[] getArr() {
        return arr;
    }

    public int getTop() {
        return top;
    }
}

class Main{
    public static void main(String[] args) {
        StackUsingArrays<Integer> s = new StackUsingArrays<>(6);
        System.out.println("---Elements adding---");
        s.push(10);
        System.out.println(Arrays.toString(s.getArr()));
        s.push(20);
        System.out.println(Arrays.toString(s.getArr()));
        s.push(30);
        System.out.println(Arrays.toString(s.getArr()));
        s.push(40);
        System.out.println(Arrays.toString(s.getArr()));
        s.push(50);
        System.out.println(Arrays.toString(s.getArr()));
        s.push(60);
        System.out.println(Arrays.toString(s.getArr()));
        System.out.println("---Deleting Elements---");
        System.out.println("Before Deletion :"+ s.getTop());
        s.pop();
        System.out.println("After Deletion :"+ s.getTop());
        System.out.println("---Peeking Elements---");
        s.peek();
        System.out.println(Arrays.toString(s.getArr()));

    }


}
