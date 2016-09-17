package easy;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * @author caos1
 * Key Points:
 *     1. DP ideology: use a cache array to store sum from first element
 *     2. If have higher requirement for sumRange method, could make the cache
 *     a 2D array, directly storing results. The cost is O(n^2) when instanciating NumArray instance
 */
public class NumArray {
    int[] cache;
    int[] nums;
    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        this.nums = nums;
        cache = new int[nums.length];
        cache[0] = nums[0];
        for (int i = 1; i < cache.length; i ++) {
            cache[i] = cache[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (nums == null) {
            return 0;
        }
        return cache[j] - cache[i] + nums[i];
    }
}
