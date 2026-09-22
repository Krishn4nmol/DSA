import java.util.*;
class llqueue { // SC O(n)
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    Node front = null;
    Node rear = null;
    void enqueue(int x) { // TC O(1)
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
        }
        rear.next = newNode;
        rear = newNode;
    }
    int dequeue() { // TC O(1)
        if (front == null) {
            return -1;
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }
    int peek() { // TC O(1)
        if (front == null) {
            return -1;
        }
        return front.data;
    }
    boolean isEmpty() { // TC O(1)
        return front == null;
    }
}
public class queueusingll {
    public static void main(String args[]) {
        llqueue q = new llqueue();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}