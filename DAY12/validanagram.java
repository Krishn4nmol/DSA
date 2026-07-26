import java.util.*;
public class validanagram {
    static boolean check1(String s, String t) { // TC O(n) SC O(1)
        if (s.length() != t.length()) return false;
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
    static boolean check2(String s, String t) { // TC O(n) SC O(k)
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c)-1);
            if(map.get(c) == 0) map.remove(c);
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(check1(s, t));
        System.out.println(check2(s, t));
    }
}