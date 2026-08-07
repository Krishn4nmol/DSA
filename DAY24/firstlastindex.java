import java.util.*;
public class firstlastindex {
    static int[] index(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        int first = -1;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[] {first, last};
    }
    static int[] index1(int arr[], int k) { // TC O(logn) SC O(1)
        return new int[] {first(arr, k), last(arr, k)};
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(Arrays.toString(index(arr, k)));
        System.out.println(Arrays.toString(index1(arr, k)));
    }
}