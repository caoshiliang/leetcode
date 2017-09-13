package easy;

import java.util.HashMap;
import java.util.Map;
/**
 * Revisit on 9/11/2017
 * 
 * 
 * https://leetcode.com/problems/two-sum/
 * @author caos1
 * Key Points:
 *     1. Use Map;
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (m.containsKey(target - nums[i])) {
                return new int[] {m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        //won't run here
        return null;
    }
}
