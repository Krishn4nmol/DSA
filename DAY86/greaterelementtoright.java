import java.util.*;
public class greaterelementtoright {
    static int[] find(int arr[], int index[]) { // TC O(qn) SC O(n)
        int n = arr.length;
        int m = index.length;
        int ans[] = new int[m];
        for (int q = 0; q < m; q++) {
            int ind = index[q];
            ArrayDeque<Integer> st = new ArrayDeque<>();
            for (int i = n - 1; i > ind; i--) {
                if (arr[i] > arr[ind]) {
                    st.push(arr[i]);
                }
            }
            ans[q] = st.size();
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int index[] = new int[q];
        for (int i = 0; i < q; i++) {
            index[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(find(arr, index)));
    }
}