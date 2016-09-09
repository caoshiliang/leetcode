package easy;
/**
 * https://leetcode.com/problems/house-robber/
 * @author silent
 * Key Points:
 * 1. Dynamic Programming formula: f(n) = max(f(n-2) + a(n), f(n-1)):
 *     How to get this formula? There're 2 cases to get max profit in current position:
 *     a) including current one: f(n-2) + a(n) // because no allow adjacent rob
 *     b) not including current one: f(n-1)
 *     We should use the max value of these 2 possibilities
 * 2. Don't use array, because no need to store more elements 2 steps before current one.
 */
public class HourseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int p = nums[0];
        int q = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i ++) {
            int tmp = p + nums[i];
            p = q;
            if (tmp > q) {
                q = tmp;
            }
            
        }
        return q;
    }
}
