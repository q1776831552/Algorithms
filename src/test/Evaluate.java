package test;


import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.next();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double val = vals.pop();
                if (op.equals("+")) val = vals.pop() + val;
                else if (op.equals(("-"))) val = vals.pop() - val;
                else if (op.equals(("*"))) val = vals.pop() * val;
                else if (op.equals(("/"))) val = vals.pop() / val;
                vals.push(val);
            }
             else vals.push(Double.parseDouble(s));

        }
        System.out.print(vals.pop());
    }
}
