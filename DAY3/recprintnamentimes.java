import java.util.*; // TC O(n) SC O(n)
public class recprintnamentimes {
    static void p(int n) {
        if (n == 0) return;
        System.out.println("Anmol Krishna");
        p(n-1);
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
