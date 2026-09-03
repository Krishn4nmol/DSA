import java.util.*;
public class validparentheses { // TC O(n * Cn) SC O(n) where Cn is catalan number Cn = (1/n+1)2nCn
    static void generate(int n, int open, int close, String str, ArrayList<String> ans) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }
        if (open < n) generate(n, open + 1, close, str + "(", ans);
        if (close < open) generate(n, open, close + 1, str + ")", ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        generate(n, 0, 0, "", list);
        System.out.println(list);
    }
}