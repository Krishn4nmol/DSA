import java.util.*;
public class outerparentheses {
    static String remove(String s) { // TC O(n) SC O(n)
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) {
                    ans.append(c);
                }
                count++;
            }
            else {
                count--;
                if (count > 0) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(remove(s));
    }
}