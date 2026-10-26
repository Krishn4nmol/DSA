import java.util.*;
public class longestsubstring {
    static int find(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(find(s));
        sc.close();
    }
}