import java.util.*; // TC O(n) SC O(n)
public class print1ton {
    static void p1(int i, int n) { //simple parameterised rec
        if (i > n) return;
        System.out.println(i);
        p1(i+1, n);
    }
    static void p2(int i, int n) { //backtrack para rec
        if (i > n) return;
        p2(i, n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            p1(1, n);
            p2(1, n);
        }
    }
}