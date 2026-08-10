import java.util.*;
public class nthroot {
    static int find(int n, int m) { // TC O(n * m pow 1/n) SC O(1)
        int ans = 0;
        for (int i = 1; i <= m; i++) { // for (int i = 1; Math.pow(i, n) <= m; i++) ans = i;
            long pow = 1;
            for (int j = 1; j <= n; j++) {
                pow *= i;
                if (pow > m) break;
            }
            if (pow <= m) {
                ans = i;
            }
            else {
                break;
            }
        }
        return ans;
    }
    static int find1(int n, int m) { // TC O(nlogm) SC O(1)
        int low = 1;
        int high = m;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long pow = 1;
            for (int i = 1; i <= n; i++) {
                pow *= mid;
                if (pow > m) break;
            }
            if (pow <= m) { // if (Math.pow(mid, n) <= m)
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
        int m = sc.nextInt();
        System.out.println(find(n, m));
        System.out.println(find1(n, m));
    }
}