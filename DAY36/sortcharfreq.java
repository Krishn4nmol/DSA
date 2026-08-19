import java.util.*;
public class sortcharfreq {
    static List<Character> find(String s) { // TC O(n + klogk) SC O(k)
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Character> ans = new ArrayList<>(map.keySet());
        ans.sort((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            return Character.compare(a, b);
        });
        return ans;
    }
    static String find1(String s) { // TC O(n + klogk) SC O(k)
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Character> an = new ArrayList<>(map.keySet());
        an.sort((a, b) -> {
            return map.get(b) - map.get(a);
        });
        StringBuilder ans = new StringBuilder();
        for (char c : an) {
            int count = map.get(c);
            while (count-- > 0) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<Character> ans = find(s);
        System.out.println(ans);
        System.out.println(find1(s));
    }
}