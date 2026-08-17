import java.util.*;
public class reversewords {
    static String reverse(String s) { // TC O(n) SC O(n)
        char[] c = s.toCharArray();
        int n = s.length();
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
        return new String(c, 0 ,left);
    }
    static void rev(char c[], int left, int right) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
    }
}