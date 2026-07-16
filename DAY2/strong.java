import java.util.*; // TC O(d)=O(logn) SC O(1)
public class strong {
    static int fact(int n) {
        if (n == 0 || n == 1) return 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    static void p(int n) {
        if (n <= 0) System.out.print("Not strong");
        else {
            int o = n;
            int s = 0;
            while (n > 0) {
                int d = n % 10;
                s += fact(d);
                n /= 10;
            }
            if (o == s) System.out.print("Strong number");
            else System.out.print("Not strong");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            p(n);
        }
    }
}