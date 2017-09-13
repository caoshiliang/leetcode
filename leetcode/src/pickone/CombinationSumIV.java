package pickone;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/combination-sum-iv/discuss/
 * Refer to : https://discuss.leetcode.com/topic/52302/1ms-java-dp-solution-with-detailed-explanation
 * 
 * @author caos1
 *
 * Key points:
 *  1. Find the recursive formula;
 *  2. Need to understand the formula and prove it in mind;
 *  3. Use hashmap to store intermediate results, to save computing time.
 */
public class CombinationSumIV {
    public static void main (String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1,2,3}, 32));
    }
    Map<Integer, Integer> m = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if (m.containsKey(target)) { // save computing time if cached
            return m.get(target);
        }
        if (target == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (target >= nums[i]) {
                sum += combinationSum4(nums, target - nums[i]);
            }
        }
        m.put(target, sum); // cache before returning
        return sum;
    }
}
