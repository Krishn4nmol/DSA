import java.util.*;
public class stringpalindrome {
    static boolean check(String s) { // TC O(n) SC O(1)
        int a = 0;
        int b = s.length() - 1;
        while (a < b) {
            while (a < b && !Character.isLetterOrDigit(s.charAt(a)))
                a++;
            while (a < b && !Character.isLetterOrDigit(s.charAt(b)))
                b--;
            if (Character.toLowerCase(s.charAt(a)) != Character.toLowerCase(s.charAt(b))) return false;
            a++;
            b--;    
            }
            return true;
        }
        static boolean check1(String s) {
            return check2(s, 0, s.length() - 1);
        }
        private static boolean check2(String s, int left, int right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(left)) !=
            Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            return check2(s, left + 1, right - 1);
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(check1(s));
    }
}