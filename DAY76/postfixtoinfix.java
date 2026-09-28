import java.util.*;
public class postfixtoinfix { // TC O(n) SC O(n)
    static boolean isOperator(char ch) {
        return ch == '+' ||
               ch == '-' ||
               ch == '*' ||
               ch == '/' ||
               ch == '%' ||
               ch == '^';
    }
    static String convert(String exp) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else if (isOperator(ch)) {
                String operator2 = stack.pop();
                String operator1 = stack.pop();
                String result = '(' + operator1 + ch + operator2 + ')';
                stack.push(result);
            }
        }
        return stack.pop()
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println("Postfix = " + exp);
        System.out.println("Infix = " + convert(exp));
    }
}