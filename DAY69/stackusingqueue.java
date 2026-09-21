import java.util.*;
class MyStack { // SC O(n)
    Queue<Integer> q;
    MyStack() {
        q = new LinkedList<>();
    }
    void push(int x) { // TC O(n) 
        q.add(x);
        int n = q.size();
        for (int i = 1; i < n; i++) {
            q.add(q.remove());
        }
    }
    int pop() { // TC O(1)
        return q.remove();
    }
    int peek() { // TC O(1)
        return q.peek();
    }
    boolean isEmpty() { // TC O(1)
        return q.isEmpty();
    }
}
public class stackusingqueue {
    public static void main(String args[]) {
        MyStack st = new MyStack();
        st.push(5);
        st.push(10);
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
    }
}