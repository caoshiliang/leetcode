package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Revisited on 9/4/2017, wonderful and simple solution!
 * 
 * https://leetcode.com/problems/contains-duplicate-ii/
 * @author caos1
 * Key Points:
 *     1. Use set;
 *     2. Only keep k elements in set, remove previous elements because we only compare previous k
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (i > k) {
                s.remove(nums[i - k - 1]);
            }
            if (s.contains(nums[i])) {
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}
