import java.util.*;
public class rangeofqueries {
    static int[] find(int queries[][]) { // TC O(MloglogM + Q) SC O(M + Q)
        int max = 0;
        for (int q[] : queries) {
            max = Math.max(max, q[1]);
        }
        boolean isprime[] = new boolean[max + 1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isprime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isprime[j] = false;
                }
            }
        }
        int prefix[] = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1];
            if (isprime[i]) {
                prefix[i]++;
            }
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefix[r] - prefix[l - 1];
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int queries[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        System.out.println(Arrays.toString(find(queries)));
    }
}