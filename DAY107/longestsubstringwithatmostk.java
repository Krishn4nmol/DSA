import java.util.*;
public class longestsubstringwithatmostk { // TC O(n) SC O(k)
    public static int longestSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(longestSubstring(s, k));
        sc.close();
    }
}