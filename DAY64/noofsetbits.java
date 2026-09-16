import java.util.*;
public class noofsetbits {
    static int find(int n) { // TC O(logn) SC O(1)
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    static int find1(int n) { // TC O(k) SC O(1) Brian Kernighan Approach k = no of set bits
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
        System.out.println(find1(n));
    }
}