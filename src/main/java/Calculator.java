import java.util.Arrays;
import java.util.Stack;

public class Calculator {
    private Calculator() {
    }

    public static String[] parse(String text) {
        return text.split(" ");
    }

    public static int getResult(String[] split) {
        String operator = "";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 1) {
                operator = split[i];
            } else {
                stack.push(Integer.parseInt(split[i]));
                if (stack.size() == 2) {
                    stack.push(operate(operator, stack.pop(), stack.pop()));
                }
            }
        }
        return stack.pop();
    }

    private static int operate(String operator, int num1, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
    }
}
