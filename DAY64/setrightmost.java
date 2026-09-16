import java.util.*;
public class setrightmost {
    static int find(int n) { // TC O(1) SC O(1)
        return n | (n + 1);
    }
    static int find1(int n) { // TC O(1) SC O(1)
        return n & (n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
        System.out.println(find1(n));
    }
}