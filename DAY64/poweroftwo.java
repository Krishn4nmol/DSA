import java.util.*;
public class poweroftwo {
    static boolean find(int n) { // TC O(log2n) SC O(1)
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
    static boolean find1(int n) { // TC O(1) SC O(1)
        return n > 0 && 1073741824 % n == 0;
    }
    static boolean find2(int n) { // TC O(1) SC O(1)
        return n > 0 && (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
        System.out.println(find1(n));
        System.out.println(find2(n));
    }
}