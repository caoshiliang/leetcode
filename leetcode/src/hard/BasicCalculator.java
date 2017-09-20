/**
 * Created on Sep 15, 2017 10:16:01 AM
 */
package hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * The trap is when pull and calculate, do not use ASCII, use there minus result to '0'
 * 
 * This is not the BasicCalculator of the leetcode
 * 
 * it can calculate 1 + 2 * 3 / 4, this handles single digit calculating
 * without brackets.
 * 
 * 
 * @author caos1
 *
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("1+2*9/3"));
    }

    public int calculate(String s) {
        Queue<Character> ops = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();

        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (c == '*' || c == '/') {
                // calculate and push, nums can't be null now
                nums.offerLast(c == '*' ? nums.pollLast() * (int) (s.charAt(i + 1) - '0') : nums.pollLast() / (int) (s.charAt(i + 1) - '0'));
                i +=2;
            } else if (c == '+' || c == '-') {
                ops.offer(c);
                i ++;
            } else {
                nums.offerLast((int) (c - '0'));
                i ++;
            }
        }
        int result = nums.pollFirst();
        while (!ops.isEmpty()) {
            result = ops.poll() == '+' ? result + nums.pollFirst() : result - nums.pollFirst();
        }

        return result;
    }
}
