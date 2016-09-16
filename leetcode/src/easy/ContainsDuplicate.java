package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * @author caos1
 * Key Points: use set
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (s.contains(i)) {
                return true;
            }
            s.add(i);
        }
        return false;
    }
}
