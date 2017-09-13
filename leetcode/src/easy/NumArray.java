package easy;

/**
 * Revisited on 9/9/2017:
 * 
 * The description of frequently calling indicates that: we need a cache strategy, key points:
 * - What're keys and values in cache:
 *   key is the array index, and the value is the sum from first element to this one (inclusive)
 * - So, the range sum could be calculated via:
 *   end sum cache minus beginning sum cache.
 * 
 * 
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * @author caos1
 * Key Points:
 *     1. DP ideology: use a cache array to store sum from first element
 *     2. If have higher requirement for sumRange method, could make the cache
 *     a 2D array, directly storing results. The cost is O(n^2) when instantiating NumArray instance
 */
public class NumArray {
    int[] cache;
    int[] nums;
    int[][] cache2d;

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

    // =============== 2D cache ==================
    // NOTE: this won't AC due to O(n^2) time complexity of constructor method
    // More space and more fast (though still constant time complexity, a minus operation is saved):
    // Use a 2D cache
    

    

    public NumArray(int[] nums, boolean use2D) {
         cache2d = new int[nums.length][nums.length];
         for (int i = 0; i < nums.length; i ++) {
             for (int j = i; j < nums.length; j ++) {
                 if (j == i) {
                     cache2d[i][j] = nums[i];
                 } else {
                     cache2d[i][j] = cache2d[i][j - 1] + nums[j]; // recursion formula
                 }
             }
         }
    }

    public int sumRange(int i, int j, boolean use2D) {
        return cache2d[i][j];
    }

}
