import java.util.*;
public class nextgreater2 {
    static int[] nextGreaterElement(int arr[]) { // TC O(n) SC O(n)
        int n = arr.length;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = arr[i % n];
            while (!st.isEmpty() && st.peek() <= curr) // for NSE st.peek() >= curr
                st.pop();
            if (i < n && !st.isEmpty())
                ans[i] = st.peek();
            st.push(curr);
        }
        return ans;
    } 
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int ans[] = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ans));
    }
}