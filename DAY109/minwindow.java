import java.util.*;
public class minwindow { // TC O(n+m) SC O(1)
    static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int freq[] = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int left = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (freq[ch] > 0) {
                required--;
            }
            freq[ch]--;
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
        sc.close();
    }
}