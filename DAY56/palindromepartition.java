import java.util.*;
public class palindromepartition { // TC O(n^2 * 2^n) SC O(n)
    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    static void backtrack(String s, int start, List<String> curr, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (ispalindrome(s,start,end)) {
                curr.add(s.substring(start, end + 1));
                backtrack(s, end + 1, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }
    static boolean ispalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(partition(s)
    }
}