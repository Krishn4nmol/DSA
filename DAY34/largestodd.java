import java.util.*;
public class largestodd {
    static String find(String s) { // TC O(n) SC O(n)
        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0';
            if (num % 2 == 1) { // if largest even then == 0
                end = i;
                break;
            }
        }
        if (end == -1) {
            return "";
        }
        int start = 0;
        while (start < end && s.charAt(start) == '0') {
            start++;
        }
        return s.substring(start, end + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(find(s));
    }
}