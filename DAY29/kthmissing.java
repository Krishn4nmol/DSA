import java.util.*;
public class kthmissing {
    static int find(int arr[], int k) { // TC O(n^2) SC O(1)
        int num = 1;
        int missing = 0;
        while (missing < k) {
            boolean found = false;
            for (int x : arr) {
                if (x == num) {
                    found = true;
                    break;
                }
            }
            if (!found) missing++;
            if (missing >= k) return num;
            num++;
        }
        return -1;
    }
    static int find1(int arr[], int k) { // TC O(logn) SC O(1)
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low + k;
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