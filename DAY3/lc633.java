import java.util.*; // TC O(root n) SC O(1)
public class lc633 {
    static boolean p(int n) {
        long a = 0;
        long b = (long)Math.sqrt(n);
        while (a <= b) {
            long sum = a * a + b * b;
            if (sum == n) return true;
            else if (sum < n) a++;
            else b--;
        }
        return false;
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