import java.util.*;
public class prefixtopostfix { // TC O(n) SC O(n)
    static boolean isOperator(char ch) {
        return ch == '+' ||
               ch == '-' ||
               ch == '*' ||
               ch == '/' ||
               ch == '%' ||
               ch == '^';
    }
    static String prefixToPostfix(String exp) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        // Scan from right to left
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } 
            else if (isOperator(ch)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = operand1 + operand2 + ch;
                stack.push(result);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println("Prefix:  " + exp);
        System.out.println("Postfix: " + prefixToPostfix(exp));
        sc.close();
    }
}