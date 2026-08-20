import java.util.*;
public class countexactk {
    static int find(String s, int k) {
        return atmost(s, k) - atmost(s, k - 1);
    }
    static int atmost(String s, int k) { // TC O(n) SC O(1)
        if (k == 0) return 0;
        int freq[] = new int[256];
        int left = 0;
        int distinct = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (freq[ch] == 0) {
                distinct++;
            }
            freq[ch]++;
            while (distinct > k) {
                char c = s.charAt(left);
                freq[c]--;
                if (freq[c] == 0) {
                    distinct--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(find(s, k));
    }
}