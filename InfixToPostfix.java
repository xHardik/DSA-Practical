import java.util.*;

public class InfixToPostfix {

    static int precedence(char ch) {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return 0;
    }

    static String convert(String infix) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            }

            // Operator
            else {
                while (!stack.isEmpty() &&
                       precedence(stack.peek()) >= precedence(ch)) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        System.out.println("Postfix expression: " + convert(infix));
    }
}