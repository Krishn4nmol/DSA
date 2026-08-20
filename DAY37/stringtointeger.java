import java.util.*;
public class stringtointeger {
    static int find(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        return print(s,i,sign,0);
    }
    static int print(String s, int i, int sign, long num) { // TC O(n) SC O(n)
        if (i == s.length() || !Character.isDigit(s.charAt(i))) {
            num *= sign;
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) num;
        }
        int digit = s.charAt(i) - '0';
        num = num * 10 + digit;
        return print(s,i+1,sign,num);
    }
    static int print1(String s) { // TC O(n) SC O(1)
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        long num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) num*sign;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(find(s));
        System.out.println(print1(s));
    }
}