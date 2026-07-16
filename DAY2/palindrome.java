import java.util.*; // TC O(d)=O(logn) SC O(1)
public class palindrome {
    static boolean p(int n) {
        int o = n;
        int r = 0;
        if (n < 0) return false;
        if (n == 0) return true;
        while (n > 0) {
            r = r * 10 + n % 10;
            n /= 10;
        }
        if (r == o) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.print(p(n));
        }
    }
}