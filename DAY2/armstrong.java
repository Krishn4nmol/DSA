import java.util.*; // TC O(d)=O(logn) SC O(1
public class armstrong {
    static void p(int n) {
        int o = n;
        int p = n;
        int s = 0;
        int c = 0;
        do {
            n /= 10;
            c++;
        } while (n > 0);
        do {
            int d = p % 10;
            s += Math.pow(d, c);
            p /= 10;
        } while (p > 0);
        if (s == o) System.out.print("Armstrong");
        else System.out.print("Not");
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