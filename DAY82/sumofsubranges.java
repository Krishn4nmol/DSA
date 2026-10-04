import java.util.*;
public class sumofsubranges {
    static long sumMax(int arr[]) {
        int n = arr.length;
        long ans = 0;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) { // i <= n sentinel
            while (!st.isEmpty() && (i == n || arr[st.peek()] <= arr[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1: mid - st.peek();
                int right = i - mid;
                ans += (long) arr[mid] * left * right;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }
    static long sumMin(int arr[]) {
        int n = arr.length;
        long ans = 0;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1: mid - st.peek();
                int right = i - mid;
                ans += (long) arr[mid] * left * right;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }
    static long find(int arr[]) { // TC O(n) SC O(n)
        return sumMax(arr) - sumMin(arr);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(find(arr));
        sc.close()
    }
}