import java.util.*;
public class sortstack {
    static void sort(Stack<Integer> st) { // TC O(n^2) SC O(n)
        if (st.isEmpty()) {
            return;
        }
        int x = st.pop();
        sort(st);
        insert(st, x);
    }
    static void insert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) { // for decreasing order st.peek() >= x
            st.push(x);
            return;
        }
        int temp = st.pop();
        insert(st, x);
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
        sort(st);
        System.out.print(st);
    }
}