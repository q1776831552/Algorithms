package stackAndQueue;

import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if(stack.empty())
                    return false;

                char match;
                if(c == '}')
                    match = '{';
                else if(c == ']')
                    match = '[';
                else
                    match = '(';

                if(stack.pop() != match)
                    return false;
            }
        }

        if(!stack.empty())
            return false;

        return true;
    }
}
