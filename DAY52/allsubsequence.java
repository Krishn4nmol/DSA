import java.util.*;
public class allsubsequence { // TC O(n * 2^n) SC O(n)
    static void generate(String str, int i, String ans) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        generate(str, i + 1, ans + str.charAt(i));
        generate(str, i + 1, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        generate(str, 0, "");
    }
}