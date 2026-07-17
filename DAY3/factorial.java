import java.util.*; // TC O(n) SC O(n)
public class factorial {
    static void p1(int i, int n) {
        if (i < 1) {
            System.out.println(n);
            return;
        }
        p1(i-1, n*i);
    }
    static int p2(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        return n * p2(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            p1(n, 1);
            System.out.println(p2(n));
        }
    }
}