import java.util.*;
public class telephone {
    static List<String> find(String digits) { // TC O(n * 4^n) SC O(n)
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        String[] map = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        backtrack(digits, 0, "", ans, map);
        return ans;
    }
    static void backtrack(String digits, int i, String curr, List<String> ans, String[] map) {
        if (i == digits.length()) {
            ans.add(curr);
            return;
        }
        int digit = digits.charAt(i) - '0';
        String length = map[digit];
        for (char ch : length.toCharArray()) {
            curr += ch;
            backtrack(digits, i + 1, curr, ans, map);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        List<String> ans = find(digits);
        System.out.print(ans);
    }
}