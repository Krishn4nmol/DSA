import java.util.*;
public class oddcheck {
    static boolean find(int n) { // TC O(1) SC O(1)
        return n % 2 != 0;
    }
    static boolean find1(int n) { // TC O(1) SC O(1)
        return (n & 1) != 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
        System.out.println(find1(n));
    }
}