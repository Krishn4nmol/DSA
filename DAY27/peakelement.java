import java.util.*;
public class peakelement {
    static int find(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) return i;
        }
        if (arr[n - 1] > arr[n - 2]) return n - 1;
        return -1;
    }
    static int find1(int arr[]) { // TC O(logn) SC O(1)
        int n = arr.length;
        if (n == 1) return 0;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) { // for duplicates use arr[mid] <= arr[mid + 1]; 
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(find(arr));
        System.out.println(find1(arr));
    }
}