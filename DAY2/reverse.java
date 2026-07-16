import java.util.*; // TC O(d)=O(logn) SC O(1)
public class reverse {
    static int rev(int n) {
        int r = 0;
        int n1 = Math.abs(n);
        if (n == 0) return 0;
        while (n1 > 0) {
            int d = n1 % 10;
            r = r * 10 + d;
            n1 /= 10;
        }
        if (n < 0) return -r;
        else return r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.print(rev(n));
        }
    }
}