import java.util.*;
public class threediv {
    static boolean check(int n) { // TC O(root n) SC O(1)
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n/i) count++;
            }
        }
        return count == 3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(check(n));
    }
}