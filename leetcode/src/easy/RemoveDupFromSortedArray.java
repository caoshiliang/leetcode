package easy;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author silent
 * Key Points:
 *    1. Same kind of moving array elements;
 *    2. Keep track of the array boundary.
 */
public class RemoveDupFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[index - 1]) {
                continue;
            }
            nums[index] = nums[i];
            index ++;
        }
        return index;
    }
}
