import java.util.*;
public class infixtopostfix { // TC O(n) SC O(n)
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
            // 1. Operand -> directly add to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // 2. Opening bracket -> push
            else if (ch == '(') {
                stack.push(ch);
            }
            // 3. Closing bracket -> pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                // Remove '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // 4. Operator
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
        // 5. Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println("Infix:   " + exp);
        System.out.println("Postfix: " + infixToPostfix(exp));
    }
}