import java.util.*;
public class ithsetornot {
    static boolean find(int n, int i) { // TC O(1) SC O(1)
        return ((1<<i)&n) != 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        System.out.println(find(n,i));
    }
}