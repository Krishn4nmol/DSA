import java.util.*;
public class maxpointcard {
    static int print(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            left += arr[i];
        }
        max = left;
        for (int i = 1; i <= k; i++) {
            left -= arr[k - i];
            right += arr[n - i];
            max = Math.max(max, left + right);
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(print(arr, k));
        sc.close();
    }
}