package easy;
/**
 * https://leetcode.com/problems/climbing-stairs/
 * @author silent
 * Solution (Actually it's a Fibonacci problem):
 * 1) Most simple: use recursive way;
 * 2) Simple: use array, treat as DP;
 * 3) Use iterative way withoutout array, only use 2 variables *
 * 4) There is a formula to calculate 
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i ++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
