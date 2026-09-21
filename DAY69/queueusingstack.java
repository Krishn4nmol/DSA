import java.util.*;
class MyQueue { // SC O(n)
    Stack<Integer> st1;
    Stack<Integer> st2;
    MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    void enqueue(int x) { // TC O(1)
        st1.push(x);
    }
    int dequeue() { // TC O(1)
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    int peek() { // TC O(1)
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    boolean isEmpty() { // TC O(1)
        return st1.isEmpty() && st2.isEmpty();
    }
}
public class queueusingstack {
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}