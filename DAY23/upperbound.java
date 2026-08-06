import java.util.*;
public class upperbound {
    static int search(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) return i;
        }
        return n;
    }
    static int search1(int arr[], int k) { // TC O(logn) SC O(1)
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(search(arr, k));
        System.out.println(search1(arr, k));
    }
}