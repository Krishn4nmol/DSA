import java.util.*;
public class binaryseq { // TC O(n * 2^n) SC O(n) more specific TC O(n * F(n)) where F(n+2) is fibonacci sequence
    static void generate(int n, String str, ArrayList<String> ans) {
        if (str.length() == n) {
            ans.add(str);
            return;
        }
        generate(n, str + "0", ans);
        // for all seq generate(n, str + "1", ans);
        if (str.length() == 0 || str.charAt(str.length() - 1) != '1')
            generate(n, str + "1", ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int n = sc.nextInt();
        generate(n, "", list);
        System.out.println(list);
    }
}