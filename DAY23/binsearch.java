import java.util.*;
public class binsearch {
    static int search(int arr[], int k) { // TC O(logn) SC O(1)
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) return mid;
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    static int search1(int arr[], int low, int high, int k) { // TC O(logn) SC O(logn)
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == k) return mid;
        else if (arr[mid] < k) return search1(arr, mid + 1, high, k);
        else return search1(arr, low, mid - 1, k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(search(arr, k));
        System.out.println(search1(arr, 0, n - 1, k));
    }
}