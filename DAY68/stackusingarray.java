import java.util.*;
class ArrayStack { // SC O(n)
    int arr[];
    int top;
    ArrayStack(int size) {
        arr = new int[size];
        top = -1;
    }
    void push(int x) { // TC O(1)
        if (top == arr.length - 1) {
            System.out.println("Overflow");
            return;
        }
        arr[++top] = x;
    }
    int pop() { // TC O(1)
        if (top == -1) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[top--];
    }
    int top() { // TC O(1)
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }
    boolean isEmpty() { // TC O(1)
        return top == -1;
    }
    boolean isFull() { // TC O(1)
        return top == arr.length - 1;
    }
}
public class stackusingarray {
    public static void main(String args[]) {
        ArrayStack st = new ArrayStack(5);
        st.push(10);
        System.out.println(st.pop());
        st.push(20);
    }
}