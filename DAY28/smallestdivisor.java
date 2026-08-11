import java.util.*;
public class smallestdivisor {
    static boolean check(int arr[], int div, int t) {
        int sum = 0;
        for (int x : arr) {
            sum += (x + div - 1) / div;
            if (sum > t) return false;
        }
        return true;
    }
    static int find(int arr[], int t) { // TC O(n*max(arr)) SC O(1)
        int max = 0;
        for (int x : arr) {
            max = Math.max(x, max);
        }
        for (int i = 1; i <= max; i++) {
            if (check(arr, i, t)) {
                return i;
            }
        }
        return -1;
    }
    static int find1(int arr[], int t) { // TC O(n*log(max(arr))) SC O(1)
        int low = 1;
        int high = 0;
        for (int x : arr) {
            high = Math.max(high, x);
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(arr, mid, t)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int t = sc.nextInt();
        System.out.println(find(arr, t));
        System.out.println(find1(arr, t));
    }
}