package easy;

import java.util.Stack;

import org.junit.Test;

/**
 * Revisit on 9/11/2017
 * https://leetcode.com/problems/valid-parentheses/description/
 * @author caos1
 *
 */
public class ValidParentheses {
    @Test
    public void abc() {
        String a = "{}{}{()}";
        System.out.println(isValid(a));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c1 = stack.peek();
                if (c == ')' && c1 != '(') {
                    return false;
                }
                if (c == ']' && c1 != '[') {
                    return false;
                }
                if (c == '}' && c1 != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
 