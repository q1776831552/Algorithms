package stackAndQueue;

import java.util.Stack;

public class LeetCode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths  = path.split("/");
        for (String s : paths) {
            if(s.equals(".") || s.equals(""))
                continue;
            if(s.equals("..")) {
                if(!stack.empty())
                    stack.pop();
            } else
                stack.push(s);
        }

        String res = "";
        while (!stack.empty()) {
            res = "/" + stack.pop() + res;
        }

        return res.length() == 0 ? "/" : res;
    }
}
