import java.util.*;
public class countoccurrence {
    static int count(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                count++;
            }
        }
        return count;
    }
    static int first(int arr[], int k) {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                ans = mid;
                high = mid - 1;
            }
            else if (arr[mid] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    static int last(int arr[], int k) {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                ans = mid;
                low = mid + 1;
            }
            else if (arr[mid] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    static int count1(int arr[], int k) { // TC O(logn) SC O(1)
        int f = first(arr, k);
        if (f == -1) return 0;
        int l = last(arr, k);
        return l - f + 1;
    }
    static int lower(int arr[], int k) {
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static int upper(int arr[], int k) {
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static int count2(int arr[], int k) { // TC O(logn) SC O(1)
        int l = lower(arr, k);
        if (l == arr.length || arr[l] != k) return 0;
        int u = upper(arr, k);
        return u - l;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(count(arr, k));
        System.out.println(count1(arr, k));
        System.out.println(count2(arr, k));
    }
}