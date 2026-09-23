import java.util.*;
public class balancedparenthesis {
    static boolean check(String str) { // TC O(n) SC O(n)
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if (ch == ')' && top != '(' ||
                    ch == '}' && top != '{' ||
                    ch == ']' && top != '[') {
                        return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(check(str));
    }
}