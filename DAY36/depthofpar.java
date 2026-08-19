import java.util.*;
public class depthofpar {
    static int find(String s) { // TC O(n) SC O(1)
        int depth = 0;
        int maxd = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxd = Math.max(maxd, depth);
            }
            else if (c == ')') {
                depth--;
            }
        }
        return maxd;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(find(s));
    }
}