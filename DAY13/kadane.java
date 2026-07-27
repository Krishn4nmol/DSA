import java.util.*;
public class kadane {
    static void max1(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int left = -1;
        int right = -1;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxsum) {
                    maxsum = sum;
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println("MAXSUM = " + maxsum);
        for (int i = left; i <= right; i++)
            System.out.print(arr[i] + " ");
    }
    static void max2(int arr[]) { // TC O(n) SC O(1)
        int n = arr.length;
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        int left = -1;
        int right = -1;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxsum) {
                maxsum = sum;
                left = temp;
                right = i;
            }
            if (sum < 0) {
                sum = 0;
                temp = i+1;
            }
        }
        System.out.println("MAXSUM = " + maxsum);
        for (int i = left; i <= right; i++)
            System.out.print(arr[i] + " ");
    }
    static int max3(int arr[], int low, int high) { // TC O(nlogn) SC O(logn)
        int n = arr.length;
        if (low >= high) return arr[low];
        int mid = low + (high - low) / 2;
        int left = max3(arr, low, mid);
        int right = max3(arr, mid + 1, high);
        int combine = clever(arr, low, mid, high);
        return Math.max(combine, Math.max(left, right));
    }
    static int clever(int arr[], int low, int mid, int high) {
    int sum = 0;
    int leftSum = Integer.MIN_VALUE;
    for (int i = mid; i >= low; i--) {
        sum += arr[i];
        leftSum = Math.max(leftSum, sum);
    }
    sum = 0;
    int rightSum = Integer.MIN_VALUE;
    for (int i = mid + 1; i <= high; i++) {
        sum += arr[i];
        rightSum = Math.max(rightSum, sum);
    }
    return leftSum + rightSum;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        max1(arr);
        max2(arr);
        System.out.println(max3(arr, 0, n - 1));
    }
}