import java.util.*;
public class goodnos {
    static long find(long n) { // TC O(logn) SC O(logn)
        long MOD = 1000000007;
        long even = (n + 1) / 2;
        long odd = n / 2;
        long result = (pow(4, odd) * pow(5, even)) % MOD;
        return result;
    }
    static long pow(long a, long b) {
        long MOD = 1000000007;
        if (b == 0) return 1;
        long half = pow(a, b / 2);
        long result = half * half;
        if (b % 2 == 1) return (a * result) % MOD;
        return result % MOD;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(find(n));
    }
}