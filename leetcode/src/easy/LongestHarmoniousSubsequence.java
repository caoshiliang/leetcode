package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Revisit on 9/5/2017
 * 
 * Understand the harmonious subsequence can only contain 2 elements
 * so find the 2 elements, who appears most frequently.
 * 
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 * 
 * @author caos1
 * Key points:
 *  1. Understand definition of harmonious sequence: only have 2 elements whose difference is 1
 *  2. Use hashmap
 *  3. Try to be simple
 */
public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestHarmoniousSubsequence().findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
    public int findLHS(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1); // simple point
        }
        int max = 0;
        for (int key : m.keySet()) {
            if (m.containsKey(key + 1)) {
                max = Math.max(max, m.get(key) + m.get(key + 1)); // simple point
            }
        }
        return max;
    }
}
