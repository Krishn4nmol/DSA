import java.util.*;
public class matmedian {
    static int upper(int arr[], int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    static int kth(int arr[][], int k) { // TC O(nlogmlog(max-min)) SC O(1)
        int n = arr.length;
        int m = arr[0].length;
        int low = arr[0][0];
        int high = arr[0][m - 1];
        for (int i = 1; i < n; i++) {
            low = Math.min(low, arr[i][0]);
            high = Math.max(high, arr[i][m - 1]);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += upper(arr[i], mid);
            }
            if (count < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    static double findMedian(int arr[][]) {
        int T = arr.length * arr[0].length;
        if (T % 2 == 1) return kth(arr, T / 2 + 1);
        return (kth(arr, T / 2) + kth(arr, T / 2 + 1)) / 2.0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findMedian(arr));
    }
}