import java.util.*;
public class jobsequencing { // TC O(nlogn + nD) SC O(D)
    static int[] JobScheduling(int Jobs[][]) {
        int n = Jobs.length;
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);
        int maxDeadline = 0;
        for (int i = 0; i < n; i++)
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        int slot[] = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);
        int count = 0;
        int totalProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = Jobs[i][1]; j > 0; j--) {
                
            }
        }
        return new int[]{count, totalProfit};
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Jobs[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++)
                Jobs[i][j] = sc.nextInt();
        }
        int ans[] = JobScheduling(Jobs);
        System.out.println(ans[0] + " " + ans[1]);
        sc.close();
    }
}