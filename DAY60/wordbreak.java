import java.util.*;
public class wordbreak { // TC O(2^n) SC O(n)
    static boolean find(String s, List<String> word) {
        HashSet<String> set = new HashSet<>(word);
        return help(0, s, set);
    }
    static boolean help(int index, String s, Set<String> set) {
        if (index == s.length()) {
            return true;
        }
        for (int end = index + 1; end <= s.length(); end++) {
            String w = s.substring(index, end);
            if (set.contains(w)) {
                if (help(end, s, set)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> word = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            word.add(sc.next());
        }
        System.out.println(find(s,word));
    }
}