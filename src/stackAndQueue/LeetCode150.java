package stackAndQueue;

import java.util.Stack;

public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s != "+" && s != "-" && s != "*" && s != "/") {
                stack.push(Integer.parseInt(s));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(s == "+")
                    stack.push(num1 + num2);
                else if(s == "-")
                    stack.push(num1 - num2);
                else if(s== "*")
                    stack.push(num1 * num2);
                else
                    stack.push(num1 / num2);
            }
        }

        return stack.peek();
    }
}
