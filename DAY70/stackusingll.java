import java.util.*;
class llstack { // SC O(n)
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    Node top = null;
    void push(int x) { // TC O(1)
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }
    int pop() { // TC O(1)
        if (top == null) {
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    int peek() { // TC O(1)
        if (top == null) {
            return -1;
        }
        return top.data;
    }
    boolean isEmpty() { // TC O(1)
        return top == null;
    }
}
public class stackusingll {
    public static void main(String args[]) {
        llstack st = new llstack();
        st.push(10);
        st.push(20);
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
    }
}