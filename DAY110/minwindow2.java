import java.util.*;
public class minwindow2 { // TC O(nm) SC O(1)
    static String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int i = 0;
        while (i < n) {
            int j = 0;
            while (i < n) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    break;
                }
                i++;
            }
            if (i == n) {
                break;
            }
            int end = i;
            j = m - 1;
            while (j >= 0) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j--;
                }

                i--;
            }
            i++;
            if (end - i + 1 < minLen) {
                minLen = end - i + 1;
                start = i;
            }
            i++;
        }
        if (start == -1) {
            return "";
        }
        return s1.substring(start, start + minLen);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
        sc.close();
    }
}