import java.util.*;
public class isomorphic {
    static boolean find(String s, String t) { // TC O(n) SC O(n)
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> mapst = new HashMap<>();
        HashMap<Character, Character> mapts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (mapst.containsKey(a) && mapst.get(a) != b) return false;
            if (mapts.containsKey(b) && mapts.get(b) != a) return false;
            mapst.put(a, b);
            mapts.put(b, a);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(find(s, t));
    }
}