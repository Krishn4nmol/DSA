import java.util.*;
public class SJF {
    static double print(int bt[]) { // TC O(nlogn) SC O(1)
        int n = bt.length;
        Arrays.sort(bt);
        long total = 0;
        long wt = 0;
        for (int i = 0; i < n; i++) {
            total += wt;
            wt += bt[i];
        }
        return (double) total / n;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bt[] = new int[n];
        for (int i = 0; i < n; i++)
            bt[i] = sc.nextInt();
        System.out.println(print(bt));
    }
}