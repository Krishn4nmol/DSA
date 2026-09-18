import java.util.*;
public class xorrange {
    static int xor(int n) {
        if (n % 4 == 0) {
            return n;
        }
        else if (n % 4 == 1) {
            return 1;
        }
        else if (n % 4 == 2) {
            return n + 1;
        }
        else {
            return 0;
        }
    }
    static int print(int l, int r) { // TC O(1) SC O(1)
        return xor(r) ^ xor(l - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(print(l, r));
    }
}