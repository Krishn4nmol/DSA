import java.util.*;
public class sieveoferatosthenes { // TC O(nloglogn) SC O(n)
    static void find(int n) {
        if (n < 2) return;
        boolean isprime[] = new boolean[n + 1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isprime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        find(n);
    }
}