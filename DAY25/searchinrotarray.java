import java.util.*;
public class searchinrotarray {
    static int print(int arr[], int k) { // TC O(logn) SC O(1)
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[low] <= arr[mid]) { // sorted part
                if (arr[low] <= k && k < arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (arr[mid] < k && k <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(print(arr, k));
    }
}