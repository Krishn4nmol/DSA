import java.util.*;
public class ceilfloor {
    static int[] print(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        int ceil = -1;
        int floor = -1;
        for (int x : arr) {
            if (x <= k) {
                floor = x;
            }
            if (x >= k) {
                ceil = x;
                break;
            }
        }
        return new int[] {floor, ceil};
    }
    static int[] print1(int arr[], int k) { // TC O(logn) SC O(1)
        return new int[] {floor(arr, k), ceil(arr, k)};
    }
    static int floor(int arr[], int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= k) {
                ans = arr[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    static int ceil(int arr[], int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= k) {
                ans = arr[mid];
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
        System.out.println(Arrays.toString(print(arr, k)));
        System.out.println(Arrays.toString(print1(arr, k)));
    }
}