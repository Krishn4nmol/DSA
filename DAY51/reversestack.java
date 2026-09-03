import java.util.*;
public class reversestack {
    static void reverse(Stack<Integer> st) { // TC O(n^2) SC O(n)
        if (st.isEmpty()) {
            return;
        }
        int x = st.pop();
        reverse(st);
        insertatbottom(st, x);
    }
    static void insertatbottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insertatbottom(st, x);
        st.push(temp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }
        System.out.print(st);
        reverse(st);
        System.out.print(st);
    }
}