import java.util.*;
public class fibonacci {
    static int fibo(int n) { // TC O(2^n) SC O(n)
        if (n <= 1) return n;
        return fibo(n-1) + fibo(n-2);
    }
    static int fibo1(int n) { // TC O(n) SC O(1)
        if (n <= 1) return n;
        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo1(n));
    }
}