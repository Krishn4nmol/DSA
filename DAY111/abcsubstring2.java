import java.util.*;
public class abcsubstring2 { // TC O(n) SC O(1)
    public static int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            ans += 1 + Math.min(last[0],
                        Math.min(last[1], last[2]));
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numberOfSubstrings(s));
        sc.close();
    }
}