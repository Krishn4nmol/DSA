import java.util.*;
public class buysellstock {
    static int profit1(int arr[]) { // TC O(n^2) SC O(1)
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int profit = arr[j] - arr[i];
                max = Math.max(max, profit);
            }
        }
        return max;
    }
    static int profit2(int arr[]) { // Greedy Approach TC O(n) SC O(1)
        int n = arr.length;
        int min = arr[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            int profit = arr[i] - min;
            if (profit > max) max = profit;
        }
        return max;
    }
    static int profit3(int arr[]) { // Kadane algorithm TC O(n) SC O(1)
        int n = arr.length;
        int max = 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            sum += diff;
            if (sum < 0) sum = 0;
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(profit1(arr));
        System.out.println(profit2(arr));
        System.out.println(profit3(arr));
    }
}