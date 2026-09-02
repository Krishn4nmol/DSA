import java.util.*;
public class power {
    static double find(double x, int n) { // TC O(logn) SC O(1)
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N /= 2;
        }
        return ans;
    }
    static double find1(double x, int n) { // TC O(logn) SC O(logn)
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }
    static double pow(double x, long N) {
        if (N == 0) return 1;
        double half = pow(x, N/2);
        if (N % 2 == 1) {
            return half * half * x;
        }
        return half * half;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(find(x,n));
        System.out.println(find1(x,n));
    }
}