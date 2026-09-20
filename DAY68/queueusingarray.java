import java.util.*;
class ArrayQueue { // SC O(n)
    int arr[];
    int front;
    int rear;
    ArrayQueue(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
    }
    void enqueue(int x) { // TC O(1)
        if (rear == arr.length - 1) {
            System.out.println("Overflow");
            return;
        }
        arr[++rear] = x;
    }
    int dequeue() { // TC O(1)
        if (front > rear) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[front++];
    }
    int peek() { // TC O(1)
        if (front > rear) {
            return -1;
        }
        return arr[front];
    }
    boolean isEmpty() { // TC O(1)
        return front > rear;
    }
    boolean isFull() { // TC O(1)
        return rear == arr.length - 1;
    }
}
public class queueusingarray {
    public static void main(String args[]) {
        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(10);
        System.out.println(q.dequeue());
        q.enqueue(20);
    }
}