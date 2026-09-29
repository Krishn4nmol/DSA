import java.util.*;
public class postfixtoprefix { // TC O(n) SC O(n)
    
    static String postfixToPrefix(String exp) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        // Scan from left to right
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else if (isOperator(ch)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = ch + operand1 + operand2;
                stack.push(result);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println("Postfix: " + exp);
        System.out.println("Prefix:  " + postfixToPrefix(exp));
        sc.close();
    }
}