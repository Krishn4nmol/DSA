import java.util.*;
public class infixtoprefix { // TC O(n) SC O(n)
    static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
    static boolean isRightAssociative(char ch) {
        return ch == '^';
    }
    static String infixToPostfix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && (precedence(stack.peek()) > precedence(ch)
                        || (precedence(stack.peek()) == precedence(ch)
                        && !isRightAssociative(ch)))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
    static String infixToPrefix(String exp) {
        // 1. Reverse expression
        StringBuilder reversed = new StringBuilder(exp).reverse();
        // 2. Swap brackets
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            }
            else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }
        // 3. Convert to postfix
        String postfix = infixToPostfix(reversed.toString());
        // 4. Reverse postfix
        return new StringBuilder(postfix).reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println("Infix:  " + exp);
        System.out.println("Prefix: " + infixToPrefix(exp));
    }
}