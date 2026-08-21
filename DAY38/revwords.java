import java.util.*;
public class revwords {
    static void rev(char c[], int left, int right) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }
    static String print1(String s) { // TC O(n) SC O(n)
        int n = s.length();
        char c[] = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < n) {
            while (right < n && c[right] == ' ') {
                right++;
            }
            while (right < n && c[right] != ' ') {
                c[left++] = c[right++];
            }
            if (right < n) {
                c[left++] = ' ';
            }
        }
        rev(c, 0, left - 1);
        int start = 0;
        for (int i = 0; i <= left; i++) {
            if (i == left || c[i] == ' ') {
                rev(c, start, i - 1);
                start = i + 1;
            }
        }
        return new String(c, 0, left);
    }
    static String print2(String s) { // TC O(n) SC O(n)
        String words[] = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            if (i != 0) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(print1(s));
        System.out.println(print2(s));
    }
}