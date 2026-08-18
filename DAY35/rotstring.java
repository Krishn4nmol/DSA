import java.util.*;
public class rotstring {
    static boolean find(String s, String t) { // TC O(n) SC O(n)
        if (s.length() != t.length()) return false;
        String d = s + s;
        return d.contains(t);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(find(s, t));
    }
}