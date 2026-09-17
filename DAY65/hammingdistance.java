import java.util.*;
public class hammingdistance { // TC O(k) SC O(1)
    static int find(int a, int b) {
        int count = 0;
        int x = a ^ b;
        while (x != 0) {
            x = x & (x - 1);
            count++;
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(find(a, b));
    }
}