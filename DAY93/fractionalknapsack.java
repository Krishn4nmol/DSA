import java.util.*;
public class fractionalknapsack { // TC O(nlogn) SC O(n)
    static double fractional(int val[], int wt[], int capacity) {
        int n = val.length;
        double idx[][] = new double[n][2];
        for (int i = 0; i < n; i++) {
            idx[i][0] = (double) val[i]/wt[i];
            idx[i][1] = i;
        }
        Arrays.sort(idx, (a,b) -> Double.compare(b[0],a[0]));
        double ans = 0.0;
        for (int i = 0; i < n && capacity > 0; i++) {
            int index = (int) idx[i][1];
            if (wt[index] <= capacity) {
                ans += val[index];
                capacity -= wt[index];
            }
            else {
                ans += (double) val[index] * capacity / wt[index];
                capacity = 0;
            }
        }
        return ans;
    }
    public static void main(String arsg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        double ans = fractional(val, wt, capacity);
        System.out.printf("%.6f", ans);
        sc.close();
    }
}