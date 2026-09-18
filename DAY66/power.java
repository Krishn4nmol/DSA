import java.util.*;
public class power {
    static double pow(double x, int n) { // TC O(logn) SC O(1)
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        while ( N > 0) {
            if ((N & 1) != 0) {
                ans *= x;
            }
            x *= x;
            N >>= 1;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(pow(x, n));
    }
}