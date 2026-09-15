import java.util.*;
public class operatoradd { // TC O(4^n * n) SC O(n)
    static List<String> result = new ArrayList<>();
    static List<String> opadd(String num, int target) {
        solve(num, target, 0, 0, 0, "");
        return result;
    }
    static void solve(String num, int target, int index, int value, int prev, String expression) {
        if (index == num.length()) {
            if (value == target) {
                result.add(expression);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break;
            String part = num.substring(index, i+1);
            int current = Integer.parseInt(part);
            if (index == 0) {
                solve(num, target, i + 1, current, current, part);
            }
            else {
                solve(num, target, i + 1, value + current, current, expression + "+" + part);
                solve(num, target, i + 1, value - current, -current, expression + "-" + part);
                solve(num, target, i + 1, value - prev + prev * current, prev * current, expression + "*" + part);
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int target = sc.nextInt();
        List<String> ans = opadd(num, target);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}