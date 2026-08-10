import java.util.*;
public class sqrt {
    static int find(int n) { // TC O(root n) SC O(1)
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((long) i * i <= n) {
                ans = i;
            }
            else {
                break;
            }
        }
        return ans;
    }
    static int find1(int n) { // TC O(logn) SC O(1)
        int low = 1;
        int high = n;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
        System.out.println(find1(n));
    }
}