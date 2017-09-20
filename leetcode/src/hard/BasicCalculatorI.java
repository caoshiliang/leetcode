/**
 * Created on Sep 15, 2017 1:54:23 PM
 */
package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Could handle +-\*\/ and brackets
 * 
 * 
 * 
 * @author caos1
 *
 */
public class BasicCalculatorI {
    public static void main(String[] args) {
        System.out.println(new BasicCalculatorI().calculate("1 + 2 * 121"));
    }

    public int calculate(String exp) {
        List<Object> elements = convert(exp);
//        for (Object elem : elements) {
//            System.out.print(elem.toString() + "  ");
//        }
        Stack<Integer> s = new Stack<>();
        for (Object elem : elements) {
            if (elem instanceof Integer) {
                s.push((Integer) elem);
            } else {
                int op2 = s.pop();
                int op1 = s.pop();
                switch (((Character)elem).charValue()) {
                case '+':
                    s.push(op1 + op2);
                    break;
                case '-':
                    s.push(op1 - op2);
                    break;
                case '*':
                    s.push(op1 * op2);
                    break;
                case '/':
                    s.push(op1 / op2);
                    break;
                }
            }
        }
        return s.pop();
    }
    /**
     * Convert a in-position expression to a post-position expression
     * e.g. 1+2 => 12+
     * Rules:http://blog.csdn.net/qq_28602957/article/details/70948575
     */
    private List<Object> convert(String s) {

        List<Object> elements = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') { // accumulate number
                int acc = 0;
                while (i < s.length()) {
                    char cc = s.charAt(i);
                    if (cc < '0' || cc > '9') {
                        break;
                    }
                    acc = acc * 10 + cc - '0';
                    i ++;
                }
                elements.add(acc);
                i --;
            } else if (c == ' ') { // bypass whitespaces
                continue;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // pop all operators to result before pushing
                while (!stack.isEmpty() && egThan(stack.peek(), c)) {
                    elements.add(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while(!stack.isEmpty()) {
                    char current = stack.pop();
                    if (current == '(') {
                        break;
                    }
                    elements.add(current);
                }
            }
        }
        // append all operators in the stack
        while (!stack.isEmpty()) {
            elements.add(stack.pop());
        }

        return elements;
    }

    /**
     * 
     * @param a
     * @param b
     * @return true if a has equal or greater priority
     */
    private boolean egThan(char a, char b) {
        if (a != '(' && (b == '+' || b == '-')) {
            return true;
        }
        return false;
    }
}
