import java.util.*;
public class rotrightbyk {
    static void rotate1(int arr[], int k) { // TC O(n) SC O(k)
        int n = arr.length;
        k = k % n;
        int temp[] = new int[k];
        for (int i = n - k; i < n; i++) {
            temp[i-(n-k)] = arr[i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i+k] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
    }
    static void rotate2(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        k = k % n;
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-k-1);
        reverse(arr, 0, n-1);
    }
    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int brr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            brr[i] = x;
        }
        int k = sc.nextInt();
        rotate1(arr, k);
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " ");
        System.out.println();
        rotate2(brr, k);
        for (int i = 0; i < n; i++)
            System.out.print(brr[i] + " ");
    }
}