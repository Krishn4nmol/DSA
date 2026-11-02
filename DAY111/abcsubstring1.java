import java.util.*;
public class abcsubstring1 { // TC O(n) SC O(1)
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int count[] = new int[3];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 &&
                   count[1] > 0 &&
                   count[2] > 0) {
                ans += n - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
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