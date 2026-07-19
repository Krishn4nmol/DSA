import java.util.*;
public class powerofthree {
    static boolean check(int n) { // TC O(log3(n)) SC O(1)
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
    static boolean check1(int n) { // TC O(1) SC O(1)
        return n > 0 && 1162261467 % n == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(check(n));
        System.out.println(check1(n));
    }
}