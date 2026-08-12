import java.util.*;
public class shippackage {
    static int canship(int arr[], int capacity) {
        int days = 1;
        int curr = 0;
        for (int x : arr) {
            if (curr + x <= capacity) {
                curr += x;
            } 
            else {
                days++;
                curr = x;
            }
        }
        return days;
    }
    static int ship(int arr[], int d) { // TC O(n*sum(arr)) SC O(1)
        int max = 0;
        int min = 0;
        for (int x : arr) {
            min = Math.max(x, min);
            max += x;
        }
        for (int i = min; i <= max; i++) {
            int days = canship(arr, i);
            if (days <= d) {
                return i;
            }
        }
        return -1;
    }
    static int ship1(int arr[], int d) { // TC O(n*log(sum(arr))) SC O(1)
        int low = 0;
        int high = 0;
        for (int x : arr) {
            low = Math.max(x, low);
            high += x;
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int days = canship(arr, mid);
            if (days <= d) {
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
        int d = sc.nextInt();
        System.out.println(ship(arr, d));
        System.out.println(ship1(arr, d));
    }
}