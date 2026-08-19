import java.util.*;
public class romantointeger {
    static int find(String s) { // TC O(n) SC O(1)
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = map.get(s.charAt(i));
            if (i < s.length() - 1 && c < map.get(s.charAt(i+1))) {
                ans -= c;
            }
            else {
                ans += c;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(find(s));
    }
}