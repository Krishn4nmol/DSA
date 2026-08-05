import java.util.*;
public class maxprodsubarray {
    static int print(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= arr[j];
                max = Math.max(max, prod);
            }
        }
        return max;
    }
    static int print1(int arr[]) { // TC O(n) SC O(1) prefix + suffix
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
    static int print2(int arr[]) { // TC O(n) SC O(1) space optimised dp approach
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i], arr[i] * max);
            min = Math.min(arr[i], arr[i] * min);
            ans = Math.max(ans, max);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(print(arr));
        System.out.println(print1(arr));
        System.out.println(print2(arr));
    }
}