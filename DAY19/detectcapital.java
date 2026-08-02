import java.util.*;
public class detectcapital {
    static boolean detect(String s) { // TC O(n) SC O(1)
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(s.charAt(i))) count++;
        }
        return count == 0 || count == n || (count == 1 && Character.isUpperCase(s.charAt(0)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(detect(s));
    }
}