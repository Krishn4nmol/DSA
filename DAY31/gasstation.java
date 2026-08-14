import java.util.*;
public class gasstation {
    static boolean canplace(int arr[], int k, double dist) {
        int station = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int gap = arr[i] - arr[i - 1];
            station += (int) Math.ceil(gap / dist) - 1;
            if (station > k) return false;
        }
        return true;
    }
    static double find(int arr[], int k) { // TC O(n log n + n log(maxGap/1e-6)) SC O(1)
        Arrays.sort(arr);
        int n = arr.length;
        double low = 0;
        double high = 0;
        for (int i = 1; i < n; i++) {
            high = Math.max(high, arr[i] - arr[i - 1]);
        }
        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2;
            if (canplace(arr, k, mid)) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(find(arr, k));
    }
}