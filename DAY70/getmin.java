import java.util.*;
class stack { // SC O(n)
    Stack<Integer> st1;
    Stack<Integer> st2;
    stack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    void push(int x) { // TC O(1)
        st1.push(x);
        if (st2.isEmpty() || x <= st2.peek()) {
            st2.push(x);
        }
    }
    void pop() { // TC O(1)
        if (st1.peek().equals(st2.peek())) {
            st2.pop();
        }
        st1.pop();
    }
    int peek() { // TC O(1)
        return st1.peek();
    }
    int getmin() { // TC O(1)
        return st2.peek();
    }
}
public class getmin {
    public static void main(String args[]) {
        stack st = new stack();
        st.push(10);
        st.push(20);
        System.out.println(st.getmin());
    }
}