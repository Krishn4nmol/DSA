import java.util.*;
public class inttoroman {
    static String find(int n) { // TC O(1) SC O(1) greedy approach
        int values[] = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String symbols[] = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                ans.append(symbols[i]);
                n -= values[i];
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
    }
}