import java.util.*;
public class maxsubarraywithk {
    static void print1(int arr[], int k) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int left = -1;
        int right = -1;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    int len = j - i + 1;
                    if (len > maxlen) {
                        maxlen = len;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        if (left == -1) {
            System.out.println("No subarray found");
            return;
        }
        System.out.println("MaxLen = " + maxlen);
        for (int i = left; i <= right; i++)
            System.out.print(arr[i] + " ");
    }
    static void print2(int arr[], int k) { // TC O(n) SC O(1)
        int n = arr.length;
        int sum = arr[0];
        int maxlen = 0;
        int left = 0;
        int right = 0;
        int i = -1;
        int j = -1;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                int len = right - left + 1;
                if (len > maxlen) {
                    maxlen = len;
                    i = left;
                    j = right;
                }
            }
            right++;
            if (right < n) {
                sum += arr[right];
            }
        }
        if (i == -1) {
            System.out.println("No subarray found");
            return;
        }
        System.out.println("MaxLen = " + maxlen);
        for (int m = i; m <= j; m++)
            System.out.print(arr[m] + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        print1(arr, k);
        System.out.println();
        print2(arr, k);
    }
}