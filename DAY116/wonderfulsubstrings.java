import java.util.*;
public class wonderfulsubstrings { // TC O(n) SC O(n)
    static long countValidSubstrings(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int mask = 0;
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int bit = s.charAt(i) - 'a';
            mask ^= (1 << bit);
            ans += map.getOrDefault(mask, 0);
            for (int j = 0; j < 10; j++) {
                int newMask = mask ^ (1 << j);
                ans += map.getOrDefault(newMask, 0);
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(countValidSubstrings(s));
        sc.close();
    }
}