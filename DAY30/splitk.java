import java.util.*;
public class splitk {
    static boolean cantake(int arr[], int k, int capacity) {
        int sub = 1;
        int curr = 0;
        for (int x : arr) {
            if (curr + x <= capacity) {
                curr += x;
            } 
            else {
                sub++;
                curr = x;
            }
        }
        return sub <= k;
    }
    static int find(int arr[], int k) { // TC O(n*sum(arr)) SC O(1)
        int max = 0;
        int min = 0;
        for (int x : arr) {
            min = Math.max(x, min);
            max += x;
        }
        for (int i = min; i <= max; i++) {
            if (cantake(arr, k, i)) {
                return i;
            }
        }
        return -1;
    }
    static int find1(int arr[], int k) { // TC O(n*log(sum(arr) - max(arr) + 1)) SC O(1)
        int low = 0;
        int high = 0;
        for (int x : arr) {
            low = Math.max(x, low);
            high += x;
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (cantake(arr, k, mid)) {
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
        int k = sc.nextInt();
        System.out.println(find(arr, k));
        System.out.println(find1(arr, k));
    }
}